import persistence.DataBaseSession;
import java.io.IOException;

public class MainClass {
    public static void main(String[] args) {
        DataBaseSession dataBaseSession = DataBaseSession.getInstance();

        try {
            Server server = new Server("127.0.0.2", 5000);
            server.startServer();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
