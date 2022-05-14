package view;

import model.Observer;
import model.QuizModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.json.JSONObject;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeListener;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;

public class LoggedUserView extends JFrame implements Observer {
    private JPanel mainPanel;
    private JTabbedPane tabLoggedUser;
    private JPanel quiPanel;
    private JPanel statisticPanel;
    private JTextPane quizTitle;
    private JTextPane questionTag;
    private JButton startButton;
    private JButton resetButton;
    private JRadioButton aRadioButton;
    private JRadioButton bRadioButton;
    private JRadioButton cRadioButton;
    private JRadioButton dRadioButton;
    private JLabel figureLabel;
    private JLabel iconLabel;
    private JPanel radialChartPanel;
    private JPanel barChartResultsPanel;
    private JPanel timeChartPanel;
    private JProgressBar progressBar1;
    private JProgressBar progressBar2;

    private final ButtonGroup buttonGroupRadio;
    private final QuizModel quizModel;

    private Map<String, String> dictionary;

    public LoggedUserView(String title, QuizModel quizModel) {
        super(title);
        this.quizModel = quizModel;
        quizModel.attach(this);
        changeLanguage(); //initialize the content
        //configure the interface
        this.setContentPane(mainPanel);

        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        // width will store the width of the screen
        int width = (int) (((float) 60 / 100) * size.getWidth());
        // height will store the height of the screen
        int height = (int) (((float) 60 / 100) * size.getHeight());

        this.setMinimumSize(new Dimension(width, height));
        this.setLocationRelativeTo(null);
        this.setMaximumSize(new Dimension(width, height));
        this.setPreferredSize(new Dimension(width, height));
        this.setResizable(false);
        //icon setting
        ImageIcon icon = null;
        try {
            icon = new ImageIcon(ImageIO.read(ClassLoader.getSystemResource("icons/bgloginImage.jpg")));
            Image image = icon.getImage(); // transform it
            Image newimg = image.getScaledInstance(400, 300, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
            figureLabel.setIcon(new ImageIcon(newimg));
            icon = new ImageIcon(ImageIO.read(ClassLoader.getSystemResource("icons/robertucker.jpg")));
            image = icon.getImage(); // transform it
            newimg = image.getScaledInstance(300, 200, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
            iconLabel.setIcon(new ImageIcon(newimg));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //group answer radio buttons
        buttonGroupRadio = new ButtonGroup();
        buttonGroupRadio.add(aRadioButton);
        buttonGroupRadio.add(bRadioButton);
        buttonGroupRadio.add(cRadioButton);
        buttonGroupRadio.add(dRadioButton);
        aRadioButton.setActionCommand("A");
        bRadioButton.setActionCommand("B");
        cRadioButton.setActionCommand("C");
        dRadioButton.setActionCommand("D");
        aRadioButton.setSelected(true);
        this.addWindowListener(new WindowsOnCloseListener());
        questionTag.setOpaque(true);
        questionTag.setEditable(false);
        StyledDocument doc = questionTag.getStyledDocument();
        StyledDocument doc2 = quizTitle.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);
        doc2.setParagraphAttributes(0, doc2.getLength(), center, false);

        this.pack();
    }

    public void addStartNextButtonListener(ActionListener e) {
        this.startButton.addActionListener(e);
    }

    public void addResetQuizButton(ActionListener resetListener) {
        this.resetButton.addActionListener(resetListener);
    }

    //add change listener for tabs
    public void addChangeListenerForTab(ChangeListener changeListener) {
        this.tabLoggedUser.addChangeListener(changeListener);
    }

    public String getSelectedAnswer() {
        return buttonGroupRadio.getSelection().getActionCommand();
    }

    @Override
    public void update(Object o) {
        String option = (String) o;
        switch (option) {
            case "open_quiz":
                setQuestionAndAnswers();
                //change text from start button in next
                startButton.setText(dictionary.get("startButton2"));
                quizTitle.setText(dictionary.get("quizTitle2") + 0);
                break;
            case "next_question":
                startButton.setText(dictionary.get("startButton2"));
                if (quizModel.getIndex() == 10) startButton.setText(dictionary.get("startButton3"));
                setQuestionAndAnswers();
                //change text from start button in next
                quizTitle.setForeground(quizModel.getAnswerColor());
                quizTitle.setText(dictionary.get("quizTitle2") + quizModel.getQuiz().get("score"));
                break;
            case "final_quiz":
                //change text from next button in start
                startButton.setText(dictionary.get("startButton1"));
                quizTitle.setText(dictionary.get("quizTitle3") + quizModel.getQuiz().get("score"));
                initQuizPage();
                break;
            case "reset":
                quizTitle.setText(dictionary.get("quizTitle1"));
                initQuizPage();
                break;
            case "set_language":
                changeLanguage();
                setStatisticsCharts();
                break;
            case "set_charts":
                setStatisticsCharts();
            default:
                break;
        }
    }

    private void initQuizPage() {
        questionTag.setText(dictionary.get("questionTag"));
        aRadioButton.setText("A");
        bRadioButton.setText("B");
        cRadioButton.setText("C");
        dRadioButton.setText("D");
        startButton.setText(dictionary.get("startButton1"));
        setHelpfulImage("icons/bgloginImage.jpg");
    }

    private void setStatisticsCharts() {
        //create pie chart
        radialChartPanel.removeAll();
        JFreeChart chart = ChartFactory.createPieChart(dictionary.get("chartPieTitle"), quizModel.getDataSetPieUserEvolution(), true, true, true);
        ChartPanel myChart = new ChartPanel(chart);
        myChart.setMouseWheelEnabled(true);
        radialChartPanel.setLayout(new java.awt.BorderLayout());
        radialChartPanel.add(myChart, BorderLayout.CENTER);
        radialChartPanel.validate();

        barChartResultsPanel.removeAll();
        JFreeChart barChart = ChartFactory.createBarChart(dictionary.get("barChartTitle"), "", dictionary.get("barChartLabel"), quizModel.getDataSetBarChart(), PlotOrientation.VERTICAL, false, true, true);
        ChartPanel chartPanel = new ChartPanel(barChart);
        barChartResultsPanel.setLayout(new java.awt.BorderLayout());
        barChartResultsPanel.add(chartPanel, BorderLayout.CENTER);
        barChartResultsPanel.validate();

        //for time chart
        timeChartPanel.removeAll();
        JFreeChart timeChart = ChartFactory.createTimeSeriesChart(dictionary.get("timeChartTitle"), // Chart
                "Date", // X-Axis Label
                "Quizzes", // Y-Axis Label
                quizModel.getTimeSeriesCollection(), true, true, true);

        //Changes background color
        XYPlot plot = (XYPlot) timeChart.getPlot();
        plot.setBackgroundPaint(new Color(255, 228, 196));
        ChartPanel timPanel = new ChartPanel(timeChart);
        timeChartPanel.setLayout(new java.awt.BorderLayout());
        timeChartPanel.add(timPanel, BorderLayout.CENTER);
        timeChartPanel.validate();
    }


    private void setQuestionAndAnswers() {
        JSONObject question = quizModel.getCurrentQuestion();
        switch (quizModel.getLanguage().getLanguage()) {
            case "english":
                questionTag.setText(quizModel.getIndex() + " " + question.get("englishBody"));
                aRadioButton.setText(question.get("englishAnswerA").toString());
                bRadioButton.setText(question.get("englishAnswerB").toString());
                cRadioButton.setText(question.get("englishAnswerC").toString());
                dRadioButton.setText(question.get("englishAnswerD").toString());
                break;
            case "german":
                questionTag.setText(quizModel.getIndex() + " " + question.get("germanBody"));
                aRadioButton.setText(question.get("germanAnswerA").toString());
                bRadioButton.setText(question.get("germanAnswerB").toString());
                cRadioButton.setText(question.get("germanAnswerC").toString());
                dRadioButton.setText(question.get("germanAnswerD").toString());
                break;
            default:
                questionTag.setText(quizModel.getIndex() + " " + question.get("romanianBody"));
                aRadioButton.setText(question.get("romanianAnswerA").toString());
                bRadioButton.setText(question.get("romanianAnswerB").toString());
                cRadioButton.setText(question.get("romanianAnswerC").toString());
                dRadioButton.setText(question.get("romanianAnswerD").toString());
                break;
        }
        //treat the case when the question has an image in resources
        if (question.get("figureURL") != null && !Objects.equals(question.get("figureURL"), "")) {
            setHelpfulImage(question.get("figureURL").toString());
        } else {
            setHelpfulImage("icons/bgloginImage.jpg");
        }
    }

    private void setHelpfulImage(String path) {
        ImageIcon icon = null;
        try {
            icon = new ImageIcon(ImageIO.read(ClassLoader.getSystemResource(path)));
            Image image = icon.getImage(); // transform it
            Image newimg = image.getScaledInstance(400, 300, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
            figureLabel.setIcon(new ImageIcon(newimg));
        } catch (IOException e) {
            System.out.println("Could not load image");
        }
    }

    private void changeLanguage() {
        dictionary = quizModel.getLanguage().getLanguageLabels();
        resetButton.setText(dictionary.get("reset"));
        if (!(quizModel.getState().equals("open_quiz") || quizModel.getState().equals("next_question") || quizModel.getState().equals("final_question"))) {
            quizTitle.setText(dictionary.get("quizTitle1"));
            questionTag.setText(dictionary.get("questionTag"));
            startButton.setText(dictionary.get("startButton1"));
        } else {
            setQuestionAndAnswers();
            quizModel.notifyObserver(quizModel.getState());
        }
    }

    private class WindowsOnCloseListener extends WindowAdapter {
        @Override
        public void windowClosing(java.awt.event.WindowEvent windowEvent) {
            quizModel.setLogged(false);
            quizModel.setQuiz(new JSONObject());
            quizModel.setUser(null);
            quizModel.setState("pending");
        }
    }
}
