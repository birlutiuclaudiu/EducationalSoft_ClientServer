import persistence.DataBaseSession;
import persistence.businesslogic.QuizBll;
import persistence.entities.Quiz;
import java.io.IOException;
import java.util.List;

public class MainClass {
    public static void main(String[] args) {
        DataBaseSession dataBaseSession = DataBaseSession.getInstance();
        List<Quiz> quizList = new QuizBll().getAllQuizzes();
        for(Quiz q:quizList){
            System.out.println(q.getUser().getUsername());
        }

        try {
            Server server = new Server("127.0.0.2", 5000);
            server.startServer();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
