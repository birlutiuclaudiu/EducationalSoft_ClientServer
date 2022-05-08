package model;

import lombok.Getter;
import lombok.Setter;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.json.JSONObject;

import java.awt.*;
import java.util.ArrayList;


@Getter
@Setter
public class QuizModel extends Subject {

    private Language language;
    private JSONObject user;
    private JSONObject quiz;
    private boolean logged = false;
    private JSONObject currentQuestion = null;
    private Integer index = 0;
    private Color answerColor;
    private String state = "pending";


    private DefaultPieDataset dataSetPieUserEvolution = new DefaultPieDataset();
    private DefaultCategoryDataset dataSetBarChart = new DefaultCategoryDataset();
    private TimeSeriesCollection timeSeriesCollection = new TimeSeriesCollection();

    public QuizModel(Language language, JSONObject user, JSONObject quiz) {
        this.language = language;
        this.user = user;
        this.quiz = quiz;
        this.answerColor = Color.GREEN;
    }

    public QuizModel() {
        this.language = new Language("romanian");
        this.user = null;
        this.quiz = new JSONObject();
        this.answerColor = Color.GREEN;
        this.setState("non_logged");
    }


    @Override
    public void notifyObserver(String operation) {
        for (Observer observer : super.getObserverList()) {
            observer.update(operation);
        }
    }

    public void addDataSetPieUserEvolution(String quizResult, long number) {
        this.dataSetPieUserEvolution.setValue("Points: " + quizResult, number);
    }

    public void addDataBarUsersScore(String username, float number) {
        this.dataSetBarChart.setValue(number, "AverageScore", username);
    }

    public void addTimeSeries(TimeSeries series) {
        timeSeriesCollection.addSeries(series);
    }


}
