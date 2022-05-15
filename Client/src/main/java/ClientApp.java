import controller.DrawingController;
import connection.EduClient;
import model.EducationalModel;
import view.EducationalSoftGUI;

import java.util.WeakHashMap;

public class ClientApp {
    public static void main(String[] args)  {
        //Create connection
        EduClient.getInstance();
        EducationalModel model = new EducationalModel();
        EducationalSoftGUI view = new EducationalSoftGUI("Educational Soft", model);
        DrawingController DrawingController = new DrawingController(view, model);
        view.setVisible(true);

    }
}
