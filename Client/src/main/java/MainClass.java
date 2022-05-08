import controller.DrawingController;
import model.EducationalModel;
import org.json.JSONObject;
import view.EducationalSoftGUI;
import java.io.IOException;


public class MainClass {
    public static void main(String[] args) throws IOException {

        //create connection to database at start application
       // DataBaseSession dataBaseSession = DataBaseSession.getInstance();
        //instantiere model
        EducationalModel model = new EducationalModel();
        EducationalSoftGUI view = new EducationalSoftGUI("Educational Soft", model);
        DrawingController drawingController = new DrawingController(view, model);
        view.setVisible(true);

        JSONObject jsonObject= new JSONObject();
        jsonObject.put("question", "hahahha");
        jsonObject.put("question2", "vafas");
        System.out.println(jsonObject);

        /*Client client = Client.getInstance();
        client.connectToServer("127.0.0.2", 5000);
        client.sendRequest("ala");
        client.sendRequest("bala");*/



    }
}
