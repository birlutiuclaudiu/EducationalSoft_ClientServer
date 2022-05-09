package model.geometryutils;

import java.awt.*;

public abstract class GeometricElementDrawable implements java.io.Serializable, ShapeDrawable{

    private Color color;
    private String lineStyle;
    private Float width;

    public GeometricElementDrawable() {
    }

    public GeometricElementDrawable(Color color, String lineStyle, Float width) {
        this.color = color;
        this.lineStyle = lineStyle;
        this.width = width;
    }

    public Color getColor() {
        return color;
    }

    public String getLineStyle() {
        return lineStyle;
    }

    public Float getWidth() {
        return width;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setLineStyle(String lineStyle) {
        this.lineStyle = lineStyle;
    }

    public void setWidth(Float width) {
        this.width = width;
    }

    @Override
    public String toString() {
        return "GeometricElementDrawable{" +
                "color=" + color +
                ", lineStyle='" + lineStyle + '\'' +
                ", width=" + width +
                '}';
    }

}
