package model.geometryutils;

import java.util.List;
import java.util.Objects;

public class Point extends GeometricElement implements java.io.Serializable {
    private float x;
    private float y;
    private String identifier = null;

    public Point() {
        this.x = 0;
        this.y = 0;
    }

    public Point(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Point(float x, float y, String identifier) {
        this.x = x;
        this.y = y;
        this.identifier = identifier;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public boolean isDifferentFrom(final Point p) {
        return this.equals(p);
    }

    public float getDistance(Point p) {
        return (float) Math.sqrt(Math.pow(this.x - p.getX(), 2) + Math.pow(this.y - p.getY(), 2));
    }

    public Point getProjection(Line line) {
        Point vect1 = new Point(line.getP2().getX() - line.getP1().getX(), line.getP2().getY() - line.getP1().getY());
        Point vect2 = new Point(this.x - line.getP1().getX(), this.y - line.getP1().getY());

        float dotProduct = vect1.getX() * vect2.getX() + vect1.getY() * vect2.getY();
        float length1 = line.getP2().getDistance(line.getP1());
        float length2 = this.getDistance(line.getP1());
        float cos = dotProduct / (length1 * length2);
        float projLen = cos * length2;

        return new Point(line.getP1().getX() + projLen * vect1.getX() / length1,
                line.getP1().getY() + projLen * vect1.getY() / length1);

    }

    public float getDistanceToALine(Line l) {
        List<Float> equation = l.getGeneralEquation();
        float a = equation.get(0);
        float b = equation.get(1);
        float c = equation.get(2);
        float r = (float) (Math.abs(a * this.x + b * this.y + c) / Math.sqrt(a * a + b * b));
        return r;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Objects.equals(x, point.x) && Objects.equals(y, point.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

}
