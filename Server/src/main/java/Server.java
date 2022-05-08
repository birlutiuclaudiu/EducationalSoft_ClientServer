import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import persistence.entities.FooClass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private ServerSocket serverSocket;
    private PrintStream printStream;
    private BufferedReader bufferedReader;

    public Server(String ipAddress, int port) throws IOException {
        serverSocket = new ServerSocket();
        serverSocket.setReuseAddress(true);
        serverSocket.bind(new InetSocketAddress(ipAddress, port));
    }

    public void startServer() throws IOException {
        Socket s = this.serverSocket.accept();
        System.out.println("Connection established with " + s.getInetAddress().getHostAddress());
        // to send data to the client
        this.printStream = new PrintStream(s.getOutputStream());

        // to read data coming from the client
        this.bufferedReader = new BufferedReader(new InputStreamReader(s.getInputStream()));

        // server executes continuously
        while(true) {

            String request;

            // read from client
            while ((request = bufferedReader.readLine()) != null) {
                System.out.println(request);
                switch (request) {
                    case "ala" -> process_ala();
                    case "bala" -> process_bala();
                }
            }

            // close connection
            printStream.close();
            bufferedReader.close();
            this.serverSocket.close();
            s.close();
            // terminate application
            System.exit(0);
        } // end of while
    }

    private void process_ala() throws JsonProcessingException {
        String str1;
        FooClass fooClass = new FooClass("aha1", "aha2",
                "aha3", 3);
        ObjectWriter ow = new ObjectMapper().writer();
        str1 = ow.writeValueAsString(fooClass);
        System.out.println(str1);
        // send to client
        printStream.println(str1);
        printStream.flush();
    }

    private void process_bala() throws JsonProcessingException {
        String str1;
        FooClass fooClass = new FooClass("bala1", "bala2",
                "bala3", 4);
        ObjectWriter ow = new ObjectMapper().writer();
        str1 = ow.writeValueAsString(fooClass);
        System.out.println(str1);
        // send to client
        printStream.println(str1);
        printStream.flush();

    }
}

