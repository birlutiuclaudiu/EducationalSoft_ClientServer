package database.businesslogic;

import database.dao.QuizQuestionDao;
import model.entities.QuizQuestion;

public class QuizQuestionBll {

    private QuizQuestionDao questionDao;

    public QuizQuestionBll(){
        this.questionDao = new QuizQuestionDao();
    }

    public Boolean saveQuizQuestion(QuizQuestion quiz) {
        return questionDao.save(quiz);
    }
}
