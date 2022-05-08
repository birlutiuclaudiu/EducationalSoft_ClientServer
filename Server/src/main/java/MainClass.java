import persistence.DataBaseSession;
import persistence.businesslogic.QuizBll;
import persistence.entities.Quiz;

import java.util.List;

public class MainClass {
    public static void main(String[] args) {
        DataBaseSession dataBaseSession = DataBaseSession.getInstance();
        List<Quiz> quizList = new QuizBll().getAllQuizzes();
        for(Quiz q:quizList){
            System.out.println(q.getUser().getUsername());
        }
    }
}
