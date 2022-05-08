package controller;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.HibernateException;
import org.json.JSONObject;

import java.io.*;
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

    public void sendRequest(String request) throws IOException {
        // send to the server
       // dataOutputStream.writeBytes(request + "\n");
       // dataOutputStream.flush();
        // receive from the server
        JSONObject jsonObject = new JSONObject(bufferedReader.readLine());
        System.out.println(jsonObject.get("s2"));
        System.out.println(jsonObject.get("s3"));
        System.out.println(jsonObject.get("a"));
    }

    public JSONObject getRequestById(String objectClass, int id) throws IOException {
        JSONObject configuration = new JSONObject();
        configuration.put("TYPE", "GET");
        configuration.put("ENTITY", objectClass);
        configuration.put("ID", id);
        printStream.println(configuration);
        printStream.flush();
        return new JSONObject(bufferedReader.readLine());
    }

    public boolean postObject(JSONObject object, String entity) throws IOException {
        JSONObject configuration = new JSONObject();
        configuration.put("TYPE", "POST");
        configuration.put("ENTITY", entity);
        configuration.put("OBJECT", object);

        printStream.println(configuration);
        printStream.flush();
        return new JSONObject(bufferedReader.readLine()).get("BAD_REQUEST")=="true";
    }

    public JSONObject getRequestLogin(String username, String password ) throws IOException {
        JSONObject configuration= new JSONObject();
        configuration.put("TYPE", "LOGIN");
        configuration.put("SUBTYPE", "LOGIN");
        configuration.put("USERNAME", username);
        configuration.put("PASSWORD", password);
        printStream.println(configuration);
        printStream.flush();
        return new JSONObject(bufferedReader.readLine());

    }
}

