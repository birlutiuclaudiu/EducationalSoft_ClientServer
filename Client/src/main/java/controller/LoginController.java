package controller;

import database.businesslogic.UserBll;
import model.QuizModel;
import model.entities.User;
import view.LoggedUserView;
import view.LoginView;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController {

    private QuizModel quizModel;
    private LoginView loginView;
    private LoggedUserView loggedUserView;
    private LoggedUserController loggedUserController;

    public LoginController(QuizModel quizModel, LoginView loginView){
        this.quizModel = quizModel;
        this.loginView = loginView;
        this.loginView.addLoginListener(new LoginListener());
        this.loginView.addRegisterListener(new RegisterListener());
    }

    private class LoginListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            UserBll userBll = new UserBll();
            String username = loginView.getUserName();
            String password = loginView.getPassword();
            User user = userBll.exists(username, password);
            if(user==null){
                JOptionPane.showMessageDialog(null, "Invalid credentials");
            }else{
                quizModel.setUser(user);
                quizModel.setLogged(true);
                quizModel.notifyObserver("login");
                loggedUserView = new LoggedUserView(user.getUsername(), quizModel);
                loggedUserController = new LoggedUserController(quizModel,loggedUserView);
                loggedUserView.setVisible(true);
            }
        }
    }
    private class RegisterListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //create bll to access the entity oprations
            UserBll userBll = new UserBll();
            String username = loginView.getUserName();
            String password = loginView.getPassword();
            try {
                User user = userBll.createNewUser(username, password);
                quizModel.setUser(user);
                quizModel.notifyObserver("register");
                quizModel.setLogged(true);
                loggedUserView = new LoggedUserView(username, quizModel);
                loggedUserController = new LoggedUserController(quizModel,loggedUserView);
                loggedUserView.setVisible(true);
            }catch (IllegalArgumentException argumentException){
                JOptionPane.showMessageDialog(null, argumentException.getMessage());
            }
        }
    }
}
