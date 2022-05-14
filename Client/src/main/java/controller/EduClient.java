package controller;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.HibernateException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;


@Getter
@Setter
public class EduClient {
    private static EduClient single_instance = null;
    private Socket socket;
    private BufferedReader bufferedReader;
    private PrintStream printStream;

    private EduClient() {
        try {
            connectToServer("127.0.0.2", 5000);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * There is one client which have to connect to server; So we obtain a client which connects to server only one time
     * The solution is to create the object by singleton pattern
     */
    public static EduClient getInstance() throws HibernateException {
        if (single_instance == null)
            single_instance = new EduClient();
        return single_instance;
    }

    public void connectToServer(String ipAddress, int port) throws IOException {
        this.socket = new Socket(ipAddress, port);
        // to read data coming from the server
        this.printStream = new PrintStream(this.socket.getOutputStream());
        this.bufferedReader = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
    }

    //the following methods create a json object with the request specification; the json object is sent to the server
    public JSONObject getRequestById(String objectClass, int id) throws IOException {
        JSONObject configuration = new JSONObject();
        configuration.put("TYPE", "GET");
        configuration.put("ENTITY", objectClass);
        configuration.put("ID", id);
        printStream.println(configuration);
        printStream.flush();
        return new JSONObject(bufferedReader.readLine());
    }

    public void postObject(JSONObject object, String entity) throws IOException {
        JSONObject configuration = new JSONObject();
        configuration.put("TYPE", "POST");
        configuration.put("ENTITY", entity);
        configuration.put("OBJECT", object);

        printStream.println(configuration);
        printStream.flush();
        new JSONObject(bufferedReader.readLine()).get("BAD_REQUEST");
    }

    public JSONObject getRequestLogin(String username, String password, String subtype) throws IOException {
        JSONObject configuration = new JSONObject();
        configuration.put("TYPE", "LOGIN");
        configuration.put("SUBTYPE", subtype);
        configuration.put("USERNAME", username);
        configuration.put("PASSWORD", password);
        printStream.println(configuration);
        printStream.flush();
        return new JSONObject(bufferedReader.readLine());
    }

    public JSONObject getRequestCharts(String typeChart, int user_id) throws IOException {
        JSONObject configuration = new JSONObject();
        configuration.put("TYPE", "CHART");
        configuration.put("SUBTYPE", typeChart);
        configuration.put("USER_ID", user_id);
        printStream.println(configuration);
        printStream.flush();
        return new JSONObject(bufferedReader.readLine());
    }

    public void close() {
        try {
            if (this.socket != null) {
                this.socket.close();
                single_instance = null;
            }
            this.socket = null;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

