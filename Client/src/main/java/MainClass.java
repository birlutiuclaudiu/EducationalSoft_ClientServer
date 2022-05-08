import controller.DrawingController;
import model.EducationalModel;
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

    }
}
