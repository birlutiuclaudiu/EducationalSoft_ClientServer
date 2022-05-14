import connections.Server;
import persistence.DataBaseSession;

import java.io.IOException;

public class ServerApp {
    public static void main(String[] args) {

        //connect to database first in order not to wait for connection when user logged in app
        DataBaseSession.getInstance();
        try {
            //the address of port is 127.0.0.2, and it is listening on port 5000
            Server server = new Server("127.0.0.2", 5000);
            server.startServer();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
