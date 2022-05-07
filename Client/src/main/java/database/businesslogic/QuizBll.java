package database.businesslogic;

import database.dao.QuizDao;
import model.entities.Quiz;
import model.entities.User;

import java.util.List;


public class QuizBll {

    private QuizDao quizDao;

    public QuizBll() {
        this.quizDao = new QuizDao();
    }

    public Boolean saveQuiz(Quiz quiz) {
        return quizDao.save(quiz);
    }

    public List<Quiz> getAllQuizzesByUser(User user){
        return quizDao.getAllQuizzesByUser(user);
    }

    public List<Quiz> getAllQuizzes(){
        return quizDao.getAll();
    }


}
