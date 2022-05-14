package model.geometryutils;

import java.util.ArrayList;
import java.util.List;

public class Line extends GeometricElement {
    private Point p1;
    private Point p2;

    public Line() {
        this.p1 = new Point();
        this.p2 = new Point();
    }

    public Line(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public Line(Float x, Float y, Float x2, Float y2) {
        super();
        p1 = new Point(x, y);
        p2 = new Point(x2, y2);
    }


    public Point getP1() {
        return p1;
    }

    public void setP1(Point p1) {
        this.p1 = p1;
    }

    public Point getP2() {
        return p2;
    }

    public void setP2(Point p2) {
        this.p2 = p2;
    }

    public Point intersectionPoint(Line line) {
        //to find intersection point we use the following method
        //extract the values form first line
        float x1 = this.p1.getX();
        float y1 = this.p1.getY();
        float x2 = this.p2.getX();
        float y2 = this.p2.getY();
        //extract the values from second line
        float x3 = line.getP1().getX();
        float y3 = line.getP1().getY();
        float x4 = line.getP2().getX();
        float y4 = line.getP2().getY();
        float determinant = (x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4);
        if (determinant == 0) {
            return new Point(0, 0);
        }
        float px = ((x3 - x4) * (x1 * y2 - y1 * x2) - (x1 - x2) * (x3 * y4 - y3 * x4)) / determinant;
        float py = ((y3 - y4) * (x1 * y2 - y1 * x2) - (y1 - y2) * (x3 * y4 - y3 * x4)) / determinant;
        return new Point(px, py);
    }

    public List<Float> getGeneralEquation() {
        List<Float> equation = new ArrayList<>();
        // ax+by +c = 0
        equation.add(p1.getY() - p2.getY());   //a
        equation.add(p2.getX() - p1.getX());  //b
        equation.add(p1.getX() * p2.getY() - p1.getY() * p2.getX());  //c
        return equation;
    }

    public float getSlopeEquation() {
        return ((p2.getY() - p1.getY()) / (p2.getX() - p1.getX()));
    }

    public Point getMiddle() {
        float x = (p1.getX() + p2.getX()) / 2;
        float y = (p1.getY() + p2.getY()) / 2;
        return new Point(x, y);
    }

    public Point getParametricPoint(float t) {
        float px = (1 - t) * p1.getX() + t * p2.getX();
        float py = (1 - t) * p1.getY() + t * p2.getY();
        return new Point(px, py);
    }

    public List<Point> getPerpendicularLines(Point ma, float NaMa) {
        float m = -1 / this.getSlopeEquation();
        float px;
        float py;
        float px2;
        float py2;
        if (m == 0) {
            px = ma.getX() + NaMa;
            py = ma.getY();
            px2 = ma.getX() - NaMa;
            py2 = ma.getY();
        } else if (Float.isInfinite(m)) {
            px = ma.getX();
            py = ma.getY() + NaMa;
            px2 = ma.getX();
            py2 = ma.getY() - NaMa;
        } else {
            float dx = (float) (NaMa / Math.sqrt(1 + (m * m)));
            float dy = m * dx;
            px = ma.getX() + dx;
            py = ma.getY() + dy;
            px2 = ma.getX() - dx;
            py2 = ma.getY() - dy;
        }
        Point Na1 = new Point(px, py);
        Point Na2 = new Point(px2, py2);
        List<Point> list = new ArrayList<>();
        list.add(Na1);
        list.add(Na2);
        return list;
    }

    @Override
    public String toString() {
        return "Line{" + "p1=" + p1 + ", p2=" + p2 + '}';
    }
}
