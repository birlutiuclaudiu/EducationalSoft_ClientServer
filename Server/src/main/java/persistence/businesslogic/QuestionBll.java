package persistence.businesslogic;


import persistence.dao.QuestionDao;
import persistence.entities.Question;

public class QuestionBll {

    private QuestionDao questionDao;

    public QuestionBll(){
        this.questionDao = new QuestionDao();
    }

    public Question findById(Integer id){
        return questionDao.findById(id);
    }

}
