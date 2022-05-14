import controller.DrawingController;
import controller.EduClient;
import model.EducationalModel;
import view.EducationalSoftGUI;
import java.io.IOException;


public class ClientApp {
    public static void main(String[] args) throws IOException {
        //Create connection
        EduClient.getInstance();
        EducationalModel model = new EducationalModel();
        EducationalSoftGUI view = new EducationalSoftGUI("Educational Soft", model);
        DrawingController drawingController = new DrawingController(view, model);
        view.setVisible(true);

    }
}
