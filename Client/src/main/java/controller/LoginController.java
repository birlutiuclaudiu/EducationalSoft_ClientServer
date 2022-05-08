package controller;

import database.businesslogic.UserBll;
import model.QuizModel;
import model.entities.User;
import org.json.JSONObject;
import view.LoggedUserView;
import view.LoginView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class LoginController {

    private QuizModel quizModel;
    private LoginView loginView;
    private LoggedUserView loggedUserView;
    private LoggedUserController loggedUserController;

    public LoginController(QuizModel quizModel, LoginView loginView) {
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
            JSONObject toLogUser=null;

            try {
                toLogUser = EduClient.getInstance().getRequestLogin(username, password, "LOGIN");
                toLogUser.get("username");
                quizModel.setUser(toLogUser);
                quizModel.setLogged(true);
                quizModel.notifyObserver("login");
                quizModel.setState("pending");
                loggedUserView = new LoggedUserView(toLogUser.get("username").toString(), quizModel);
                loggedUserController = new LoggedUserController(quizModel, loggedUserView);
                loggedUserView.setVisible(true);

            } catch (Exception r) {
                if(toLogUser==null)
                    JOptionPane.showMessageDialog(null, r.getMessage());
                else
                    JOptionPane.showMessageDialog(null, toLogUser.get("MESSAGE"));
            }
        }
    }

    private class RegisterListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //create bll to access the entity operations
            String username = loginView.getUserName();
            String password = loginView.getPassword();
            JSONObject toLogUser = null;
            try {
                toLogUser = EduClient.getInstance().getRequestLogin(username, password, "REGISTER");
                System.out.println("Register"+toLogUser);
                toLogUser.get("username");
                quizModel.setUser(toLogUser);
                quizModel.notifyObserver("register");
                quizModel.setLogged(true);
                loggedUserView = new LoggedUserView(username, quizModel);
                loggedUserController = new LoggedUserController(quizModel, loggedUserView);
                loggedUserView.setVisible(true);
            } catch (Exception r) {
                if(toLogUser==null)
                    JOptionPane.showMessageDialog(null, r.getMessage());
                else
                    JOptionPane.showMessageDialog(null, toLogUser.get("MESSAGE"));
            }
        }
    }
}
