import controller.DrawingController;
import connection.EduClient;
import model.EducationalModel;
import view.EducationalSoftGUI;

public class ClientApp {
    public static void main(String[] args)  {
        //Create connection
        EduClient.getInstance();
        EducationalModel model = new EducationalModel();
        EducationalSoftGUI view = new EducationalSoftGUI("Educational Soft", model);
        DrawingController drawingController = new DrawingController(view, model);
        view.setVisible(true);

    }
}
