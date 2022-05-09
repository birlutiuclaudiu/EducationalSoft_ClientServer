package controller.command;

import lombok.AllArgsConstructor;
import model.EducationalModel;
import model.geometryutils.Drawing;
import model.persistence.PersistenceGeometricElementDrawable;

@AllArgsConstructor
public class SaveCommand implements ICommand {
    public EducationalModel modelEdu;
    public String filePath;
    @Override
    public void Execute() {
        Drawing drawing = this.modelEdu.getDrawing();
        PersistenceGeometricElementDrawable persistence = new PersistenceGeometricElementDrawable();
        persistence.saveElementToXML(drawing, filePath);

    }
}
