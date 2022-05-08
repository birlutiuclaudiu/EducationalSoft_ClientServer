import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import dto.QuestionDTO;
import dto.UserDTO;
import dto.mapper.QuestionMapper;
import dto.mapper.UserMapper;
import org.json.JSONObject;
import persistence.businesslogic.QuestionBll;
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
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Server {

    private ServerSocket serverSocket;
    private PrintStream printStream;
    private BufferedReader bufferedReader;
    private ObjectWriter objectWriter;

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
        this.objectWriter = new ObjectMapper().writer();
        // server executes continuously
        while (true) {
            String request;
            // read from client
            while ((request = bufferedReader.readLine()) != null) {
                JSONObject jsonObject = new JSONObject(request);
                System.out.println("HEADER REQUEST" + jsonObject.toString(1));
                switch (jsonObject.get("TYPE").toString()) {
                    case "GET" -> processGET(jsonObject);
                    case "POST" -> processPOST(jsonObject);
                    case "LOGIN" -> processLOGIN(jsonObject);
                    case "CHART" -> processCHART(jsonObject);
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
        String sendingString = "";
        QuestionDTO questionDTO;
        switch (jsonObject.get("ENTITY").toString()) {
            case "question" -> {
                System.out.println("Sending to client the question with id: "+jsonObject.get("ID"));
                questionDTO = QuestionMapper.toDTO(new QuestionBll().findById((int) jsonObject.get("ID")));
                sendingString =  this.objectWriter.writeValueAsString(questionDTO);
            }
        }
        // send to client
        printStream.println(sendingString);
        printStream.flush();
    }

    private void processPOST(JSONObject jsonObject) throws JsonProcessingException {

        switch (jsonObject.get("ENTITY").toString()) {
            case "quiz" -> {
                postSaveQuiz(jsonObject.get("OBJECT").toString());
            }
        }
        JSONObject sendingString = new JSONObject();
        sendingString.put("BAD_REQUEST", false);
        System.out.println(sendingString);
        printStream.println(sendingString);
        printStream.flush();
    }

    private void postSaveQuiz(String objectFields) {
        JSONObject jsonObject = new JSONObject(objectFields);
        User user = new UserBll().findById((int) jsonObject.get("user_id"));
        Quiz quiz = Quiz.builder()
                .date(LocalDateTime.parse(jsonObject.get("date").toString()))
                .score((int) jsonObject.get("score"))
                .user(user)
                .build();
        new QuizBll().saveQuiz(quiz);
        System.out.println("Quiz saved: " + jsonObject.toString(1));
    }

    private void processLOGIN(JSONObject jsonObject) {
        User user = null;
        UserDTO userDTO = null;
        JSONObject badRequest = new JSONObject();
        switch (jsonObject.get("SUBTYPE").toString()) {
            case "LOGIN" -> {
                user = new UserBll().exists(jsonObject.get("USERNAME").toString(), jsonObject.get("PASSWORD").toString());
                if (user != null)
                    userDTO = UserMapper.toDTO(user);
                else
                    badRequest.put("MESSAGE", "Invalid credentials");
            }
            case "REGISTER" -> {
                try {
                    user = new UserBll().createNewUser(jsonObject.get("USERNAME").toString(),
                            jsonObject.get("PASSWORD").toString());
                } catch (Exception e) {
                    badRequest.put("MESSAGE", e.getMessage());
                }
            }
        }
        String sendingString = "";
        if (user != null) {
            userDTO = UserMapper.toDTO(user);
            try {
                sendingString = this.objectWriter.writeValueAsString(userDTO);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        } else {
            sendingString = badRequest.toString();
        }
        printStream.println(sendingString);
        printStream.flush();
    }

    private void processCHART(JSONObject jsonObject) {
        User user = new UserBll().findById((int) jsonObject.get("USER_ID"));
        JSONObject dataset = null;
        switch (jsonObject.get("SUBTYPE").toString()) {
            case "PIE" -> {
                dataset = getPIEDataSet(user);
            }
            case "TIME" -> {
                dataset = getTimeDataSet(user);
            }
            case "BAR" -> {
                dataset = getBarDataSet(user);
            }
        }
        if (dataset == null)
            dataset = new JSONObject();
        printStream.println(dataset);
        printStream.flush();

    }

    private JSONObject getPIEDataSet(User user) {
        QuizBll quizBll = new QuizBll();
        List<Quiz> quizList = quizBll.getAllQuizzesByUser(user);
        Map<Integer, Long> countResults = quizList.stream()
                .map(Quiz::getScore)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        //create dataset for pie chart
        return new JSONObject(countResults);
    }

    private JSONObject getTimeDataSet(User user) {
        QuizBll quizBll = new QuizBll();
        List<Quiz> quizList = quizBll.getAllQuizzesByUser(user);
        Map<String, Long> countQuizPerDay = quizList.stream()
                .map(q -> q.getDate().toLocalDate().atTime(LocalTime.MIN).toString())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return new JSONObject(countQuizPerDay);
    }

    private JSONObject getBarDataSet(User user) {
        List<Quiz> quizList = new QuizBll().getAllQuizzes();
        //determine the average score
        Map<String, Float> averageMap = new HashMap<>();
        for (Quiz quiz : quizList) {
            averageMap.put(quiz.getUser().getUsername(), quiz.getUser().getAverageScore());
        }
        int i = 0;
        Map<String, Float> barData = new HashMap<>();
        for (var entry : averageMap.entrySet()) {
            if (entry.getKey().equals(user.getUsername()))
                barData.put(entry.getKey(), entry.getValue());
            else
                barData.put("User" + (++i), entry.getValue());
        }
        return new JSONObject(barData);
    }
}

