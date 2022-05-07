package view;

import model.Observer;
import model.QuizModel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Map;

public class LoginView extends JFrame implements Observer {
    private JPanel mainPanel;
    private JTextField userNameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton registerButton;
    private JLabel loginTitle;
    private JLabel usernameTitle;
    private JLabel passwordTitle;

    private final QuizModel quizModel;

    public LoginView(String title, QuizModel model) {
        super(title);
        this.quizModel = model;
        this.quizModel.attach(this);
        this.setContentPane(mainPanel);
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        // width will store the width of the screen
        int width = (int) (((float) 25 / 100) * size.getWidth());
        // height will store the height of the screen
        int height = (int) (((float) 20 / 100) * size.getHeight());
        this.setMinimumSize(new Dimension(width, height));
        this.setMaximumSize(new Dimension(width, height));
        this.setPreferredSize(new Dimension(width, height));
        this.setLocation(new Point((int) (size.getWidth() / 2.2f), (int) (size.getHeight() / 2.2)));
        this.setResizable(false);
        mainPanel.setBackground(new Color(217, 228, 234));
        changeLanguage();
        this.pack();
    }

    public void addLoginListener(ActionListener e) {
        this.loginButton.addActionListener(e);
    }

    public void addRegisterListener(ActionListener e) {
        this.registerButton.addActionListener(e);
    }

    public String getUserName() {
        return this.userNameField.getText();
    }

    public String getPassword() {
        return this.passwordField.getText();
    }

    @Override
    public void update(Object o) {
        String option = (String) o;
        //optiunile listernerilor
        switch (option) {
            case "login":
                this.setVisible(false);
                break;
            case "register":
                this.setVisible(false);
                JOptionPane.showMessageDialog(null, "Welcome, new user!");
                break;
            case "set_language":
                changeLanguage();
            default:
                break;
        }
    }

    private void changeLanguage() {
        Map<String, String> dictionary = quizModel.getLanguage().getLanguageLabels();
        loginTitle.setText(dictionary.get("loginTitle"));
        usernameTitle.setText(dictionary.get("usernameTitle"));
        passwordTitle.setText(dictionary.get("password"));
        loginButton.setText(dictionary.get("loginButton"));
        registerButton.setText(dictionary.get("registerButton"));
    }


}
