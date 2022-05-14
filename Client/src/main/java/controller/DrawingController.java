package controller;

import controller.command.DrawCommand;
import controller.command.ICommand;
import controller.command.LoadCommand;
import controller.command.SaveCommand;
import model.EducationalModel;
import model.QuizModel;
import view.EducationalSoftGUI;
import view.LoginView;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DrawingController {
    private final EducationalSoftGUI educationalSoftGUI;
    private final QuizModel quizModel;
    private final EducationalModel modelEdu;
    private LoginView loginView;
    private LoginController loginController;

    public DrawingController(EducationalSoftGUI educationalSoftGUI, EducationalModel educationalModel) {
        this.educationalSoftGUI = educationalSoftGUI;
        this.modelEdu = educationalModel;
        this.educationalSoftGUI.addColorButtonListener(new ColorButtonListener());
        this.educationalSoftGUI.addSaveButtonListener(new SaveButtonListener());
        this.educationalSoftGUI.addLoadButtonListener(new LoadButtonListener());
        this.educationalSoftGUI.addMouseDrawingListener(new MouseDrawingListener());
        this.educationalSoftGUI.addRomanianListener(new RomanianListener());
        this.educationalSoftGUI.addEnglishListener(new EnglishListener());
        this.educationalSoftGUI.addGermanListener(new GermanListener());
        this.educationalSoftGUI.addQuizButtonListener(new QuizButtonListener());
        this.quizModel = new QuizModel();
        quizModel.setLanguage(educationalModel.getLanguage());
    }

    public void drawElements() {
        ICommand drawingCommand = new DrawCommand(modelEdu, educationalSoftGUI);
        drawingCommand.Execute();
    }

    /////////////////////////////////////////////   FOR PERSISTENCE    //////////////////////////////////////////////
    private void saveFigure(String filePath) {
        ICommand saveCommand = new SaveCommand(modelEdu, filePath);
        saveCommand.Execute();
    }

    private void loadFigure(String filePath) {
        ICommand loadCommand = new LoadCommand(modelEdu, filePath);
        loadCommand.Execute();
    }

    private class ColorButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Color initialColor = Color.BLACK;
            Color color = JColorChooser.showDialog(educationalSoftGUI,
                    "Select a color for shapes", initialColor);
            modelEdu.getDrawing().setColor(color);
        }
    }

    private class SaveButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser jFileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
            jFileChooser.setAcceptAllFileFilterUsed(false);
            jFileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Only .xml files", "xml"));
            String filePath = "";
            int invoke = jFileChooser.showSaveDialog(null);
            if (invoke == JFileChooser.APPROVE_OPTION) {
                filePath = jFileChooser.getSelectedFile().getAbsolutePath();
                saveFigure(filePath);
            } else {
                JOptionPane.showMessageDialog(null, "Could not save the figure");
            }
        }
    }

    private class LoadButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser jFileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
            jFileChooser.setAcceptAllFileFilterUsed(false);
            jFileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Only .xml files", "xml"));
            String filePath = "";
            int invoke = jFileChooser.showOpenDialog(null);
            if (invoke == JFileChooser.APPROVE_OPTION) {
                filePath = jFileChooser.getSelectedFile().getAbsolutePath();
                loadFigure(filePath);
            } else {
                JOptionPane.showMessageDialog(null, "Could not load the figure");
            }
        }
    }

    private class MouseDrawingListener extends MouseAdapter {
        public void mousePressed(MouseEvent e) {
            modelEdu.getDrawing().setMouseOldPosition(e.getX(), e.getY());
        }

        public void mouseDragged(MouseEvent e) {
            modelEdu.getDrawing().setMouseNewPosition(e.getX(), e.getY());
            drawElements();
        }

        public void mouseReleased(MouseEvent e) {
            modelEdu.getDrawing().setMouseNewPosition(e.getX(), e.getY());
            drawElements();
        }
    }

    private class RomanianListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            modelEdu.getLanguage().setLanguage("romanian");
            quizModel.setLanguage(modelEdu.getLanguage());
            modelEdu.notifyObserver("set_language");
            quizModel.notifyObserver("set_language");
        }
    }

    private class EnglishListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            modelEdu.getLanguage().setLanguage("english");
            quizModel.setLanguage(modelEdu.getLanguage());
            modelEdu.notifyObserver("set_language");
            quizModel.notifyObserver("set_language");
        }
    }

    private class GermanListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            modelEdu.getLanguage().setLanguage("german");
            quizModel.setLanguage(modelEdu.getLanguage());
            modelEdu.notifyObserver("set_language");
            quizModel.notifyObserver("set_language");
        }
    }

    private class QuizButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //determine when the button is avaible
            if (loginView != null && !loginView.isVisible() && quizModel != null && quizModel.isLogged()) {
                JOptionPane.showMessageDialog(null, "You are already logged");
            } else if (loginView != null && !loginView.isVisible() && quizModel != null) {
                loginView.setVisible(true);
            } else if (loginView != null && loginView.isVisible()) {
                loginView.setVisible(true);
            } else {
                loginView = new LoginView("Login page", quizModel);
                loginController = new LoginController(quizModel, loginView);
                loginView.setVisible(true);
            }
        }
    }
}


