package view;

import model.EducationalModel;
import model.Observer;
import model.QuizModel;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;

public class EducationalSoftGUI extends JFrame implements Observer {
    private JPanel mainPanel;
    private JButton buttonColor;
    private JComboBox comboStyle;
    private JPanel resultsPanel;
    private JLabel arcLengthLabel;
    private JLabel sectionAriaLabel;
    private JLabel circleAriaLabel;
    private JLabel lengthCircleLabel;
    private JTextField widthTextField;
    private DrawingArea drawingArea;
    private JRadioButton drawCircleRadio;
    private JRadioButton drawPolygonRadio;
    private JComboBox propertiesTriangle;
    private JButton loadButton;
    private JButton saveButton;
    private JPanel drawingPanel;
    private JLabel circleRadiusLabel;
    private JTextField startArcAngle;
    private JTextField endArcAngle;
    private JTextField numberOfVerticesPolygonText;
    private JTextField numberOfVerticesText;
    private JRadioButton drawTriangleRadio;
    private JButton germButton;
    private JButton engButton;
    private JButton romButton;
    private JPanel romanianButton;
    private JLabel setLineTitle;
    private JLabel setColorTitle;
    private JLabel setLineStyleTitle;
    private JLabel lineWidthTitle;
    private JLabel polygonTitle;
    private JLabel nbOfVerticesTitle;
    private JLabel arcPropertyTitle;
    private JLabel startAngleTitle;
    private JLabel endAngleTitle;
    private JLabel resultTitle;
    private JLabel lengthTitle;
    private JLabel circleAriaTitle;
    private JLabel sectionTitle;
    private JLabel arcLengthTitle;
    private JButton quizButton;
    private ButtonGroup buttonGroupRadio;
    //pentru parametri
    private Color color = Color.BLACK;
    //attribute for drawing components

    //modelul
    private EducationalModel modelEdu;

    private LoginView loginView;

    public EducationalSoftGUI(String title, EducationalModel modelEdu) {
        super(title);
        //assign the model
        this.modelEdu = modelEdu;
        //set the observer
        modelEdu.attach(this);
        //configure the interface
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        // width will store the width of the screen
        int width = (int) (((float) 75 / 100) * size.getWidth());
        // height will store the height of the screen
        int height = (int) (((float) 75 / 100) * size.getHeight());
        resultsPanel.setMaximumSize(new Dimension(50, 50));
        resultsPanel.setPreferredSize(new Dimension(50, 50));
        resultsPanel.setBackground(Color.RED);
        buttonGroupRadio = new ButtonGroup();
        buttonGroupRadio.add(drawCircleRadio);
        buttonGroupRadio.add(drawPolygonRadio);
        buttonGroupRadio.add(drawTriangleRadio);
        drawCircleRadio.setActionCommand("circle");
        drawPolygonRadio.setActionCommand("polygon");
        drawTriangleRadio.setActionCommand("triangle");
        drawCircleRadio.setSelected(true);
        this.setMinimumSize(new Dimension(width, height));
        this.setLocationRelativeTo(null);

        try {
            romButton.setIcon(getLanguageIcon("icons/rom.png"));
            engButton.setIcon(getLanguageIcon("icons/eng.png"));
            germButton.setIcon(getLanguageIcon("icons/germ.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.pack();
        //update initial triangle
    }

    public LoginView configureLoginView(QuizModel model){
        this.loginView = new LoginView("Login page", model);
        return this.loginView;
    }
    private ImageIcon getLanguageIcon(String resourcePath) throws IOException {
        ImageIcon icon = new ImageIcon(ImageIO.read(ClassLoader.getSystemResource(resourcePath)));
        Image image = icon.getImage(); // transform it
        Image newimg = image.getScaledInstance(50, 30, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        return new ImageIcon(newimg);  // transform it back
    }

    //LISTENERS ------------------------------------------
    public void addColorButtonListener(ActionListener e) {
        this.buttonColor.addActionListener(e);
    }

    public void addSaveButtonListener(ActionListener e) {
        this.saveButton.addActionListener(e);
    }

    public void addLoadButtonListener(ActionListener e) {
        this.loadButton.addActionListener(e);
    }

    public void addMouseDrawingListener(MouseAdapter mouseAdapter) {
        this.drawingArea.addMouseListener(mouseAdapter);
        this.drawingArea.addMouseMotionListener(mouseAdapter);
    }

    public void addRomanianListener(ActionListener e) {
        this.romButton.addActionListener(e);
    }

    public void addEnglishListener(ActionListener e) {
        this.engButton.addActionListener(e);
    }

    public void addGermanListener(ActionListener e) {
        this.germButton.addActionListener(e);
    }
    public void addQuizButtonListener(ActionListener e) {
        this.quizButton.addActionListener(e);
    }
    //-----------------------------------------------------------

    public String getLineStyle() {
        if (Objects.requireNonNull(this.comboStyle.getSelectedItem()).toString().contains("discont") ||
                Objects.requireNonNull(this.comboStyle.getSelectedItem()).toString().contains("diskontinuierlich")
        ) {
            return "discontinue";
        } else
            return "continue";
    }


    public String getLineWidth() {
        return this.widthTextField.getText();
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getLineColor() {
        return this.color;
    }

    public void setCircleRadius(String radius) {
        this.circleRadiusLabel.setText(radius);
    }

    public void setCircleLength(String circleLength) {
        this.lengthCircleLabel.setText(circleLength);
    }

    public void setCircleAria(String circleAria) {
        this.circleAriaLabel.setText(circleAria);
    }

    public void setSectionAria(String sectionAria) {
        this.sectionAriaLabel.setText(sectionAria);
    }

    public void setArcLength(String arcLength) {
        this.arcLengthLabel.setText(arcLength);
    }

    public String getArcStartAngle() {
        return this.startArcAngle.getText();
    }

    public String getArcEndAngle() {
        return this.endArcAngle.getText();
    }

    //for polygon
    public String getNbOfVertices() {
        return this.numberOfVerticesText.getText();
    }

    public int getTriangleProperty() {
        return this.propertiesTriangle.getSelectedIndex();
    }

    public String getDrawingOption() {
        return buttonGroupRadio.getSelection().getActionCommand();
    }


    @Override
    public void update(Object o) {
        String option = (String) o;
        switch (option) {
            case "draw":
                Graphics g = drawingArea.getGraphics();
                drawingArea.paint(g);
                Graphics2D graphics2D = (Graphics2D) g.create();
                this.modelEdu.getDrawing().drawGeometricElements(graphics2D);
                break;
            case "set_language":
                changeLanguage();
                break;
            case "quiz":
                this.loginView.setVisible(true);
            default:
                break;
        }
    }

    private void changeLanguage() {
        Map<String, String> language = this.modelEdu.getLanguage().getLanguageLabels();

        setLineTitle.setText(language.get("setLineTitle"));
        setColorTitle.setText(language.get("setColorTitle"));
        buttonColor.setText(language.get("buttonColor"));
        comboStyle.removeAllItems();
        comboStyle.addItem(language.get("comboStyle1"));
        comboStyle.addItem(language.get("comboStyle2"));
        setLineStyleTitle.setText(language.get("setLineStyleTitle"));
        lineWidthTitle.setText(language.get("lineWidthTitle"));
        drawCircleRadio.setText(language.get("drawCircleRadio"));
        drawPolygonRadio.setText(language.get("drawPolygonRadio"));
        drawTriangleRadio.setText(language.get("drawTriangleRadio"));
        polygonTitle.setText(language.get("polygonTitle"));
        nbOfVerticesTitle.setText(language.get("nbOfVerticesTitle"));
        arcPropertyTitle.setText(language.get("arcPropertyTitle"));
        startAngleTitle.setText(language.get("startAngleTitle"));
        endAngleTitle.setText(language.get("endAngleTitle"));
        loadButton.setText(language.get("loadButton"));
        saveButton.setText(language.get("saveButton"));
        resultTitle.setText(language.get("resultTitle"));
        lengthTitle.setText(language.get("lengthTitle"));
        circleAriaTitle.setText(language.get("circleAriaTitle"));
        sectionTitle.setText(language.get("sectionTitle"));
        arcLengthTitle.setText(language.get("arcLengthTitle"));

        propertiesTriangle.removeAllItems();
        propertiesTriangle.addItem(language.get("circumscribed"));
        propertiesTriangle.addItem(language.get("inscribed"));
        propertiesTriangle.addItem(language.get("tucker"));
        propertiesTriangle.addItem(language.get("lucas"));
        propertiesTriangle.addItem(language.get("orthocentroidal"));
        propertiesTriangle.addItem(language.get("neuberg"));
        propertiesTriangle.addItem(language.get("adams"));
        propertiesTriangle.addItem(language.get("brocard"));
    }
    //config login view
    public void createNewModel(QuizModel model){
        this.loginView = new LoginView("Login page", model);
    }
}
