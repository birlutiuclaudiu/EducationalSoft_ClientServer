package model.geometryutils;

import java.util.ArrayList;
import java.util.List;

public class Polygon extends GeometricFigure implements java.io.Serializable {
    private List<Point> points;

    public Polygon() {
        points = new ArrayList<>();
    }

    public Polygon(List<Point> points) {
        this.points = points;
    }

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }

    public int getNbOfVertices() {
        return points.size();
    }

    @Override
    public Float computeAria() {
        return null;
    }
}
