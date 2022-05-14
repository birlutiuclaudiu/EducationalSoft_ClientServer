package persistence.businesslogic;


import persistence.dao.QuizDao;
import persistence.entities.Quiz;
import persistence.entities.User;

import java.util.List;

public class QuizBll {

    private final QuizDao quizDao;

    public QuizBll() {
        this.quizDao = new QuizDao();
    }

    public Boolean saveQuiz(Quiz quiz) {
        return quizDao.save(quiz);
    }

    public List<Quiz> getAllQuizzesByUser(User user) {
        return quizDao.getAllQuizzesByUser(user);
    }

    public List<Quiz> getAllQuizzes() {
        return quizDao.getAll();
    }


}
