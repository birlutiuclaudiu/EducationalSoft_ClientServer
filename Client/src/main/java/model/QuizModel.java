package model;

import lombok.Getter;
import lombok.Setter;
import model.entities.Question;
import model.entities.Quiz;
import model.entities.QuizQuestion;
import model.entities.User;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.json.JSONObject;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class QuizModel extends Subject {

    private Language language;
    private User user;
    private JSONObject quizJSON;
    private boolean logged =false;
    private Question currentQuestion=null;
    private Integer index=0;
    private List<QuizQuestion> quizQuestionList;
    private Color answerColor;
    private String state="pending";


    private DefaultPieDataset dataSetPieUserEvolution = new DefaultPieDataset();
    private DefaultCategoryDataset dataSetBarChart = new DefaultCategoryDataset();
    private TimeSeriesCollection timeSeriesCollection = new TimeSeriesCollection();

    public QuizModel(Language language, User user, JSONObject quiz) {
        this.language = language;
        this.user = user;
        this.quizJSON = quiz;
        this.quizQuestionList = new ArrayList<>();
        this.answerColor = Color.GREEN;
    }

    public QuizModel() {
        this.language = new Language("romanian");
        this.user = null;
        this.quizJSON = new JSONObject();
        this.quizQuestionList = new ArrayList<>();
        this.answerColor = Color.GREEN;
    }

    public void addNewQuizQuestion(QuizQuestion question){
        this.quizQuestionList.add(question);
    }

    @Override
    public void notifyObserver(String operation) {
        for (Observer observer : super.getObserverList()) {
            observer.update(operation);
        }
    }

    public void addDataSetPieUserEvolution(String quizResult, long number){
        this.dataSetPieUserEvolution.setValue("Points: " + quizResult, number);
    }

    public void addDataBarUsersScore(String username, float number){
        this.dataSetBarChart.setValue(number, "AverageScore", username);
    }

    public void addTimeSeries(TimeSeries series){
        timeSeriesCollection.addSeries(series);
    }


}
