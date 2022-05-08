package persistence.businesslogic;


import persistence.dao.QuizQuestionDao;
import persistence.entities.QuizQuestion;

public class QuizQuestionBll {

    private QuizQuestionDao questionDao;

    public QuizQuestionBll(){
        this.questionDao = new QuizQuestionDao();
    }

    public Boolean saveQuizQuestion(QuizQuestion quiz) {
        return questionDao.save(quiz);
    }
}
