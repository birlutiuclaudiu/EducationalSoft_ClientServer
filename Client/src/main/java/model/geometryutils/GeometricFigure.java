package model.geometryutils;

public abstract class GeometricFigure extends GeometricElement implements java.io.Serializable {

    public GeometricFigure() {
    }

    public abstract Float computeAria();
}
