import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import dto.QuestionDTO;
import dto.mapper.QuestionMapper;
import org.json.JSONObject;
import persistence.businesslogic.QuestionBll;
import java.time.LocalDateTime;

import persistence.businesslogic.QuizBll;
import persistence.businesslogic.UserBll;
import persistence.entities.Quiz;
import persistence.entities.User;

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
                JSONObject jsonObject = new JSONObject(request);
                System.out.println(jsonObject);
                switch (jsonObject.get("TYPE").toString()) {
                    case "GET" -> processGET(jsonObject);
                    case "POST" -> processPOST(jsonObject);
                    case "LOGIN" -> processLOGIN(jsonObject);
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

    private void processGET(JSONObject jsonObject) throws JsonProcessingException {
        String sendingString="";
        ObjectWriter ow = new ObjectMapper().writer();
        QuestionDTO questionDTO;
        switch (jsonObject.get("ENTITY").toString()){
            case "question" -> {
                questionDTO = QuestionMapper.toDTO(new QuestionBll().findById((int)jsonObject.get("ID")));
                sendingString = ow.writeValueAsString(questionDTO);
            }
            case "user" -> sendingString="" ;
        }

        // send to client
        System.out.println(sendingString);
        printStream.println(sendingString);
        printStream.flush();
    }

    private void processPOST(JSONObject jsonObject) throws JsonProcessingException {

        ObjectWriter ow = new ObjectMapper().writer();
        QuestionDTO questionDTO;

        switch (jsonObject.get("ENTITY").toString()){
            case "quiz" -> {
                postSaveQuiz(jsonObject.get("OBJECT").toString());
            }
            case "user" -> questionDTO=null;
        }
        JSONObject sendingString = new JSONObject();
        sendingString.put("BAD_REQUEST", false);
        System.out.println(sendingString);
        printStream.println(sendingString);
        printStream.flush();

    }

    private void postSaveQuiz(String objectFields){
        JSONObject jsonObject = new JSONObject(objectFields);
        User user = new UserBll().findById((int)jsonObject.get("user_id"));
        Quiz quiz = Quiz.builder()
                .date(LocalDateTime.parse(jsonObject.get("date").toString()))
                .score((int)jsonObject.get("score"))
                .user(user)
                .build();
        new QuizBll().saveQuiz(quiz);
        System.out.println("Quiz saved");
    }

    private void processLOGIN(JSONObject jsonObject){
        ObjectWriter ow = new ObjectMapper().writer();

        switch (jsonObject.get("SUBTYPE").toString()){
            case "LOGIN" -> {
                postSaveQuiz(jsonObject.get("OBJECT").toString());
            }
            case "REGISTER" -> ow.withDefaultPrettyPrinter();
        }
        JSONObject sendingString = new JSONObject();
        sendingString.put("BAD_REQUEST", false);
        System.out.println(sendingString);
        printStream.println(sendingString);
        printStream.flush();
    }
}

