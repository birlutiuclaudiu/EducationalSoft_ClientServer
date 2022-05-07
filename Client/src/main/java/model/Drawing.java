package model;

import lombok.Getter;
import lombok.Setter;
import model.geometryutils.GeometricElementDrawable;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Drawing implements Serializable {

    List<Float> triangleX;
    List<Float> triangleY;
    private List<GeometricElementDrawable> geometricElementDrawables;
    //line properties
    private String lineStyle;
    private Float lineWidth;
    private Color color;
    private int oldX;
    private int oldY;
    private int newX;
    private int newY;

    public Drawing() {
        this.geometricElementDrawables = new ArrayList<>();
        this.color = Color.BLACK;
        this.triangleX = new ArrayList<>(List.of(new Float[]{200f, 500f, 400f}));
        this.triangleY = new ArrayList<>(List.of(new Float[]{400f, 100f, 400f}));
    }

    public Drawing(List<Float> triangleX, List<Float> triangleY, List<GeometricElementDrawable> geometricElementDrawables,
                   String lineStyle, Float lineWidth, Color color, int oldX, int oldY, int newX, int newY) {
        this.triangleX = new ArrayList<>(List.of(new Float[]{200f, 500f, 400f}));
        this.triangleY = new ArrayList<>(List.of(new Float[]{400f, 100f, 400f}));
        this.geometricElementDrawables = geometricElementDrawables;
        this.lineStyle = lineStyle;
        this.lineWidth = lineWidth;
        this.color = color;
        this.oldX = oldX;
        this.oldY = oldY;
        this.newX = newX;
        this.newY = newY;
    }

    public Drawing(List<GeometricElementDrawable> geometricElementDrawables) {
        this.geometricElementDrawables = geometricElementDrawables;

    }

    public void addGeometricElement(GeometricElementDrawable geometricElementDrawable) {
        this.geometricElementDrawables.add(geometricElementDrawable);
    }

    public void deleteGeometricElement(GeometricElementDrawable geometricElementDrawable) {
        this.geometricElementDrawables.remove(geometricElementDrawable);
    }

    public void drawGeometricElements(Graphics2D graphics2D) {
        for (GeometricElementDrawable geom : geometricElementDrawables) {
            geom.draw(graphics2D);
        }
    }

    public void setMouseOldPosition(int oldX, int oldY) {
        this.oldX = oldX;
        this.oldY = oldY;
    }

    public void setMouseNewPosition(int newX, int newY) {
        this.newX = newX;
        this.newY = newY;
    }

}
