package controller;

import database.businesslogic.QuestionBll;
import database.businesslogic.QuizBll;
import database.businesslogic.QuizQuestionBll;
import model.QuizModel;
import model.entities.Question;
import model.entities.Quiz;
import model.entities.QuizQuestion;
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
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


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
                model.setQuizQuestionList(new ArrayList<>());
                JSONObject quizJSON = new JSONObject();
                quizJSON.put("user_id", model.getUser().getUserID());
                quizJSON.put("date", LocalDateTime.now().toString());
                quizJSON.put("score", 0);
                model.setQuizJSON(quizJSON);
                QuestionBll questionBll = new QuestionBll();
                Question question = questionBll.findById(getRandomQuestion());
                model.setCurrentQuestion(question);

                model.notifyObserver("open_quiz");
                model.setState("open_quiz");
            } else {
                if (String.valueOf(model.getCurrentQuestion().getCorrectAnswer()).equals(loggedUserView.getSelectedAnswer())) {
                    int newScore = (int)model.getQuizJSON().get("score") + 10;
                    model.getQuizJSON().put("score", newScore);
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
                    Question question = new QuestionBll().findById(getRandomQuestion());
                    model.setCurrentQuestion(question);
                    model.notifyObserver("next_question");
                    model.setState("next_question");
                }
            }
        }

        private int getRandomQuestion() {
            Random random = new Random();
            //choose the question by dificulty; divide the 50 exiting questions in ten intervals
            return random.nextInt(5) + (model.getIndex() - 1) * 5 + 1;
        }

        private void saveResultsQuiz() {
            //save quiz information
            System.out.println(model.getQuizJSON());
            //save the specific questions to this quiz
            QuizQuestionBll questionBll = new QuizQuestionBll();
            /*for (QuizQuestion question : model.getQuizQuestionList()) {
                question.setQuiz(model.getQuiz());
                questionBll.saveQuizQuestion(question);
            }*/
        }
    }

    private class ResetListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //model.setOpenQuiz(false);
            model.notifyObserver("reset");
        }
    }

    private class ChangeListenerTab implements ChangeListener {
        @Override
        public void stateChanged(ChangeEvent e) {
            int index = ((JTabbedPane) e.getSource()).getSelectedIndex();
            if (index == 1) {
                setPieAndTimeDataset();
                setBarDataSet();
                model.notifyObserver("set_charts");
            }
        }

        private void setPieAndTimeDataset() {
            QuizBll quizBll = new QuizBll();
            List<Quiz> quizList = quizBll.getAllQuizzesByUser(model.getUser());
            Map<Integer, Long> countResults = quizList.stream()
                    .map(Quiz::getScore)
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
            //create dataset fo
            model.setDataSetPieUserEvolution(new DefaultPieDataset());
            for (var entry : countResults.entrySet()) {
                model.addDataSetPieUserEvolution(entry.getKey().toString(), entry.getValue());
            }
            //populate date for times
            model.setTimeSeriesCollection(new TimeSeriesCollection());
            Map<LocalDateTime, Long> countQuizPerDay = quizList.stream()
                    .map(q -> q.getDate().toLocalDate().atTime(LocalTime.MIN))
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

            TimeSeries series = new TimeSeries("Date");
            SortedSet<LocalDateTime> keys = new TreeSet<>(countQuizPerDay.keySet());  //to sort
            for (LocalDateTime key : keys) {
                series.add(new Day(key.getDayOfMonth(), key.getMonthValue(), key.getYear()),
                        countQuizPerDay.get(key));
            }
            model.addTimeSeries(series);
        }

        private void setBarDataSet() {
            List<Quiz> quizList = new QuizBll().getAllQuizzes();
            //determine the average score
            Map<String, Float> averageMap = new HashMap<>();
            for (Quiz quiz : quizList) {
                averageMap.put(quiz.getUser().getUsername(), quiz.getUser().getAverageScore());
            }
            int i = 0;
            for (var entry : averageMap.entrySet()) {
                if (entry.getKey().equals(model.getUser().getUsername()))
                    model.addDataBarUsersScore(entry.getKey(), entry.getValue());
                else
                    model.addDataBarUsersScore("User" + (++i), entry.getValue());
            }

        }
    }
}
