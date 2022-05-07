package model.geometryutils;

import java.awt.*;
import java.util.List;

public class TriangleDrawable extends GeometricElementDrawable implements java.io.Serializable{

    private Triangle triangle;

    public TriangleDrawable() {
        this.triangle = new Triangle();
    }

    public TriangleDrawable(Triangle triangle) {
        this.triangle = triangle;
    }

    public TriangleDrawable(Triangle triangle, Color color, String lineStyle, Float width) {
        super(color, lineStyle, width);
        this.triangle = triangle;
    }


    @Override
    public void draw(Graphics2D g) {
        List<Point> pointList = this.triangle.getPoints();
        Polygon polygon = new Polygon(pointList);
        PolygonDrawable polygonDrawable = new PolygonDrawable(polygon, super.getColor(),
                super.getLineStyle(), super.getWidth());
        polygonDrawable.draw(g);
        g.drawString(pointList.get(0).getIdentifier(), pointList.get(0).getX() + 2, pointList.get(0).getY());
        g.drawString(pointList.get(1).getIdentifier(), pointList.get(1).getX() + 2, pointList.get(1).getY());
        g.drawString(pointList.get(2).getIdentifier(), pointList.get(2).getX() + 2, pointList.get(2).getY());
    }

    public Triangle getTriangle() {
        return triangle;
    }

    public void setTriangle(Triangle triangle) {
        this.triangle = triangle;
    }
}
