package model.geometryutils;

import java.util.ArrayList;
import java.util.List;

public class Triangle implements java.io.Serializable {

    private List<Point> points;

    public Triangle() {
        this.points = new ArrayList<>();
    }

    public Triangle(Point a, Point b, Point c) {
        this.points = new ArrayList<>();
        this.points.add(a);
        this.points.add(b);
        this.points.add(c);
    }

    public List<Point> getPoints() {
        return this.points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }

    public Circle getCircumscribedCircle() {
        return new Circle(points.get(0), points.get(1), points.get(2));
    }

    public Circle getInscribedCircle() {
        Point a = this.points.get(0);
        Point b = this.points.get(1);
        Point c = this.points.get(2);
        float distA = b.getDistance(c);
        float distB = a.getDistance(c);
        float distC = b.getDistance(a);
        //we compute the center of the inscribed circle
        float inX = (distA * a.getX() + distB * b.getX() + distC * c.getX()) / (distA + distB + distC);
        float inY = (distA * a.getY() + distB * b.getY() + distC * c.getY()) / (distA + distB + distC);
        Point center = new Point(inX, inY);
        //we compute the radius; this is the distance from the center to one edge
        Line line = new Line(a, b);
        float radius = center.getDistanceToALine(line);
        return new Circle(center, radius);
    }

    public float getAngle(int i) {
        float angle = 0.0f;
        //determine the vectors
        Point anglePoint = points.get(i%3);
        Point firstPoint = points.get((i + 1) % 3);
        Point secondPoint = points.get((i + 2) % 3);
        Point vec1 = new Point(firstPoint.getX() - anglePoint.getX(), firstPoint.getY() - anglePoint.getY());
        Point vec2 = new Point(secondPoint.getX() - anglePoint.getX(), secondPoint.getY() - anglePoint.getY());
        float length1 = firstPoint.getDistance(anglePoint);
        float length2 = secondPoint.getDistance(anglePoint);
        float dotProduct = vec1.getX() * vec2.getX() + vec1.getY() * vec2.getY();
        float cosTheta = dotProduct / (length1 * length2);
        angle = (float) Math.acos(cosTheta);
        return angle;
    }

    //get the length of the oposite line
    public float getLength(int i) {
        return points.get((i + 1) % 3).getDistance(points.get((i + 2) % 3));
    }

    public Point getOrthocenter() {
        Point point = null;
        float angleA = this.getAngle(0);
        float angleB = this.getAngle(1);
        float angleC = this.getAngle(2);
        Point a = this.points.get(0);
        Point b = this.points.get(1);
        Point c = this.points.get(2);
        double v = Math.tan(angleA) + Math.tan(angleB) + Math.tan(angleC);
        float px = (float) ((a.getX() * Math.tan(angleA) + b.getX() * Math.tan(angleB) + c.getX() * Math.tan(angleC)) /
                v);
        float py = (float) ((a.getY() * Math.tan(angleA) + b.getY() * Math.tan(angleB) + c.getY() * Math.tan(angleC)) / v);
        point = new Point(px, py);
        point.setIdentifier("H");
        return point;
    }

    public Point getWeightCenter() {
        Point a = this.points.get(0);
        Point b = this.points.get(1);
        Point c = this.points.get(2);
        float px = (a.getX() + b.getX() + c.getX()) / 3;
        float py = (a.getY() + b.getY() + c.getY()) / 3;
        Point point = new Point(px, py);
        point.setIdentifier("G");
        return point;
    }

    public Line getMedian(int i) {
        Point a = this.points.get(i % 3);
        Point b = this.points.get((i + 1) % 3);
        Point c = this.points.get((i + 2) % 3);
        Line bc = new Line(b, c);
        Point ma = bc.getMiddle();
        return new Line(a, ma);
    }

    public Line getLineEdge(int i) {
        Point b = this.points.get((i + 1) % 3);
        Point c = this.points.get((i + 2) % 3);
        return new Line(b, c);
    }

    public float getBrocardAngle() {
        return (float) (1 / Math.tan(getAngle(0)) + 1 / Math.tan(getAngle(1)) + 1 / Math.tan(getAngle(2)));
    }

    public Point getIntersectBisector(int i) {
        Line line = getLineEdge(i);
        Point inters = getInscribedCircle().getCenter();
        Line bisect = new Line(this.points.get(i), inters);
        return bisect.intersectionPoint(line);
    }

    public Line getSymmedian(int i) {
        Line edge = this.getLineEdge(i);
        Point ma = this.getMedian(i).intersectionPoint(edge);
        Point ba = this.getIntersectBisector(i);
        float dist = ma.getDistance(ba);
        Line symmedian = null;
        if (ma.getDistance(edge.getP1()) < ba.getDistance(edge.getP1())) {
            Line line = new Line(ma, edge.getP2());
            float t = 2 * dist / line.getP1().getDistance(line.getP2());
            Point p = line.getParametricPoint(t);
            symmedian = new Line(points.get(i), p);
        } else {
            Line line = new Line(ma, edge.getP1());
            float t = 2 * dist / line.getP1().getDistance(line.getP2());
            Point p = line.getParametricPoint(t);
            symmedian = new Line(points.get(i), p);
        }
        return symmedian;
    }


}
