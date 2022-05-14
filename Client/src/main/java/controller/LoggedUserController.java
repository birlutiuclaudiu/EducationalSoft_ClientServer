package controller;

import model.QuizModel;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.json.JSONObject;
import view.LoggedUserView;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;


public class LoggedUserController {

    private final QuizModel model;
    private final LoggedUserView loggedUserView;

    public LoggedUserController(QuizModel model, LoggedUserView loggedUserView) {
        this.model = model;
        this.loggedUserView = loggedUserView;
        this.loggedUserView.addStartNextButtonListener(new StartNextListener());
        this.loggedUserView.addResetQuizButton(new ResetListener());
        this.loggedUserView.addChangeListenerForTab(new ChangeListenerTab());
    }

    private class StartNextListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (model.getState().equals("pending") || model.getState().equals("final_quiz")) {
                model.setIndex(1);
                //initializare quiz
                JSONObject quizJSON = new JSONObject();
                quizJSON.put("user_id", model.getUser().get("id"));
                quizJSON.put("date", LocalDateTime.now().toString());
                quizJSON.put("score", 0);
                model.setQuiz(quizJSON);
                getRandomQuestion(); //call server for a question

                model.notifyObserver("open_quiz");
                model.setState("open_quiz");
            } else {
                if (String.valueOf(model.getCurrentQuestion().get("correctAnswer")).equals(loggedUserView.getSelectedAnswer())) {
                    int newScore = (int) model.getQuiz().get("score") + 10;
                    model.getQuiz().put("score", newScore);
                    model.setAnswerColor(Color.GREEN);
                } else {
                    model.setAnswerColor(Color.RED);
                }
                //reach the of the quiz or not
                if (model.getIndex() == 10) {
                    saveResultsQuiz();
                    model.setState("final_quiz");
                    model.notifyObserver("final_quiz");
                    model.setState("final_quiz");
                } else {
                    model.setIndex(model.getIndex() + 1);
                    getRandomQuestion(); //call for server
                    model.notifyObserver("next_question");
                    model.setState("next_question");
                }
            }
        }

        private void getRandomQuestion() {
            Random random = new Random();
            //choose the question by dificulty; divide the 50 exiting questions in ten intervals
            int id_question = random.nextInt(5) + (model.getIndex() - 1) * 5 + 1;
            EduClient eduClient = EduClient.getInstance();
            try {
                JSONObject currentQuestion = eduClient.getRequestById("question", id_question);
                model.setCurrentQuestion(currentQuestion);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        private void saveResultsQuiz() {
            JSONObject jsonObject = model.getQuiz();
            try {
                EduClient.getInstance().postObject(jsonObject, "quiz");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }

    private class ResetListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            model.setState("pending");
            model.notifyObserver("reset");
        }
    }

    private class ChangeListenerTab implements ChangeListener {
        @Override
        public void stateChanged(ChangeEvent e) {
            int index = ((JTabbedPane) e.getSource()).getSelectedIndex();
            if (index == 1) {
                setChartDataSet();
                model.notifyObserver("set_charts");
                model.setState("set_charts");
            } else {
                model.notifyObserver("reset");
                model.setState("pending");
            }
        }

        private void setChartDataSet() {
            JSONObject pieData = null;
            JSONObject timeData = null;
            JSONObject barData = null;
            try {
                pieData = EduClient.getInstance().getRequestCharts("PIE", (int) model.getUser().get("id"));
                timeData = EduClient.getInstance().getRequestCharts("TIME", (int) model.getUser().get("id"));
                barData = EduClient.getInstance().getRequestCharts("BAR", (int) model.getUser().get("id"));
                //populate data for
                model.setDataSetPieUserEvolution(new DefaultPieDataset());
                for (var entry : pieData.toMap().entrySet()) {
                    model.addDataSetPieUserEvolution(entry.getKey(), (Integer) entry.getValue());
                }
                //populate date for times
                model.setTimeSeriesCollection(new TimeSeriesCollection());

                TimeSeries series = new TimeSeries("Date");
                Map<LocalDateTime, Long> countQuizPerDay = new HashMap<>();
                for (var entry : timeData.toMap().entrySet()) {
                    countQuizPerDay.put(LocalDateTime.parse(entry.getKey()),
                            Long.valueOf(entry.getValue().toString()));
                }
                SortedSet<LocalDateTime> keys = new TreeSet<>(countQuizPerDay.keySet());  //to sort
                for (LocalDateTime key : keys) {
                    series.add(new Day(key.getDayOfMonth(), key.getMonthValue(), key.getYear()),
                            countQuizPerDay.get(key));
                }
                model.addTimeSeries(series);

                //for BAR
                for (var entry : barData.toMap().entrySet()) {
                    model.addDataBarUsersScore(entry.getKey(), Float.parseFloat(entry.getValue().toString()));
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
