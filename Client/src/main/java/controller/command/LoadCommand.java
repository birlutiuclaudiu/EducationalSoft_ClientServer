package controller.command;

import lombok.AllArgsConstructor;
import model.EducationalModel;
import model.persistence.PersistenceGeometricElementDrawable;

import javax.swing.*;
import java.io.IOException;

@AllArgsConstructor
public class LoadCommand implements ICommand {
    public EducationalModel modelEdu;
    public String filePath;

    @Override
    public void Execute() {
        PersistenceGeometricElementDrawable persistence = new PersistenceGeometricElementDrawable();
        try {

            this.modelEdu.setDrawing(persistence.loadElementFromXML(filePath));
            this.modelEdu.notifyObserver("draw");

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not load the figure");
        }
    }
}
