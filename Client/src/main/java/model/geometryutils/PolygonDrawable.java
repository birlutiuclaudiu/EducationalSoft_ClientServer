package model.geometryutils;

import java.awt.*;
import java.util.List;

public class PolygonDrawable extends GeometricElementDrawable implements java.io.Serializable, ShapeDrawable {

    private Polygon polygon;

    public PolygonDrawable() {
        this.polygon = new Polygon();
    }

    public PolygonDrawable(Polygon polygon) {
        this.polygon = polygon;
    }

    public PolygonDrawable(Polygon polygon, Color color, String lineStyle, Float width) {
        super(color, lineStyle, width);
        this.polygon = polygon;
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        List<Point> points = this.polygon.getPoints();
        for (int i = 0; i < this.polygon.getNbOfVertices() - 1; i++) {
            Line line = new Line(points.get(i), points.get(i + 1));
            LineDrawable lineDrawable = new LineDrawable(line, this.getColor(), this.getLineStyle(), this.getWidth());
            lineDrawable.draw(graphics2D);
        }
        Line line = new Line(points.get(0), points.get(points.size() - 1));
        LineDrawable lineDrawable = new LineDrawable(line, this.getColor(), this.getLineStyle(), this.getWidth());
        lineDrawable.draw(graphics2D);
    }

    public Polygon getPolygon() {
        return polygon;
    }

    public void setPolygon(Polygon polygon) {
        this.polygon = polygon;
    }
}
