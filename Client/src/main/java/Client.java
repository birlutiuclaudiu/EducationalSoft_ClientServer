import lombok.Getter;
import lombok.Setter;
import org.hibernate.HibernateException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;


@Getter
@Setter
public class Client {
    private static Client single_instance = null;
    private Socket socket;
    private DataOutputStream dataOutputStream;
    private BufferedReader bufferedReader;

    private Client() {

    }

    public static Client getInstance() throws HibernateException {
        if (single_instance == null)
            single_instance = new Client();
        return single_instance;
    }

    public void connectToServer(String ipAddress, int port) throws IOException {
        this.socket = new Socket(ipAddress, port);
        // to read data coming from the server
        this.dataOutputStream = new DataOutputStream(this.socket.getOutputStream());
        this.bufferedReader = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
    }

    public void sendRequest(String request) throws IOException {
        // send to the server
        dataOutputStream.writeBytes(request + "\n");
        dataOutputStream.flush();
        // receive from the server
        JSONObject jsonObject = new JSONObject(bufferedReader.readLine());
        System.out.println(jsonObject.get("s2"));
        System.out.println(jsonObject.get("s3"));
        System.out.println(jsonObject.get("a"));
    }
}

