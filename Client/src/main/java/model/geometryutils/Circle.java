package model.geometryutils;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Circle extends GeometricFigure implements java.io.Serializable{

    private Point center;
    private Float radius;

    public Circle() {
        this.center = new Point();
        this.radius = 0.0f;
    }

    public Circle(Point center, Float radius) {
        this.center = center;
        this.radius = radius;
    }

    //constructor for circle determinate by 3 points
    public Circle(Point a, Point b, Point c) {
        //we compute the radius and center of circle from the equation of circle determinate by 3 points
        // x^2 + y^2 + 2mx + 2ny + p = 0;  => circcle center C(-m,-n) and R^2= m*m + n*n - p
        //we resolve the determinant equation ann obtain m, n and p
        //some differences
        float aXbX = a.getX() - b.getX();
        float aXcX = a.getX() - c.getX();
        float aYbY = a.getY() - b.getY();
        float aYcY = a.getY() - c.getY();

        float cYaY = c.getY() - a.getY();
        float bYaY = b.getY() - a.getY();
        float cXaX = c.getX() - a.getX();
        float bXaX = b.getX() - a.getX();

        //compute aX^2 - cX^2
        float sqAxCx = (float) (Math.pow(a.getX(), 2) - Math.pow(c.getX(), 2));
        //compute aY^2 - cY^2
        float sqAyCy = (float) (Math.pow(a.getY(), 2) - Math.pow(c.getY(), 2));
        //compute bX^2 - aX^2
        float sqBxAx = (float) (Math.pow(b.getX(), 2) - Math.pow(a.getX(), 2));
        //compute bY^2 - aY^2
        float sqByAy = (float) (Math.pow(b.getY(), 2) - Math.pow(a.getY(), 2));

        //compute m from the equation
        float n = (sqAxCx * aXbX + sqAyCy * aXbX + sqBxAx * aXcX + sqByAy * aXcX) / (2 * (cYaY * aXbX - bYaY * aXcX));
        //compute n from the equation
        float m = (sqAxCx * aYbY + sqAyCy * aYbY + sqBxAx * aYcY + sqByAy * aYcY) / (2 * (cXaX * aYbY - bXaX * aYcY));

        float p = -(float) Math.pow(a.getX(), 2) - (float) Math.pow(a.getY(), 2) - 2 * m * a.getX() - 2 * n * a.getY();

        this.center = new Point(-m, -n);
        this.radius = (float) Math.sqrt(m * m + n * n - p);

    }

    public List<Point> getCircleLineIntersection(Line line) {
        //method taken from  https://www.codegrepper.com/code-examples/java/circle+line+intersection+java
        Point pointA = line.getP1();
        Point pointB = line.getP2();
        double baX = pointB.getX() - pointA.getX();
        double baY = pointB.getY() - pointA.getY();
        double caX = center.getX() - pointA.getX();
        double caY = center.getY() - pointA.getY();

        double a = baX * baX + baY * baY;
        double bBy2 = baX * caX + baY * caY;
        double c = caX * caX + caY * caY - radius * radius;

        double pBy2 = bBy2 / a;
        double q = c / a;

        double disc = pBy2 * pBy2 - q;
        if (disc < 0) {
            return Collections.emptyList();
        }
        double tmpSqrt = Math.sqrt(disc);
        double abScalingFactor1 = -pBy2 + tmpSqrt;
        double abScalingFactor2 = -pBy2 - tmpSqrt;

        Point p1 = new Point((float) (pointA.getX() - baX * abScalingFactor1), (float) (pointA.getY()
                - baY * abScalingFactor1));
        if (disc == 0) {
            return Collections.singletonList(p1);
        }
        Point p2 = new Point((float) (pointA.getX() - baX * abScalingFactor2), (float) (pointA.getY()
                - baY * abScalingFactor2));
        return Arrays.asList(p1, p2);
    }

    @Override
    public Float computeAria() {
        return (float) (Math.PI * this.radius * this.radius);
    }

    public Float computeLength() {
        return (float) (2 * Math.PI * this.radius);
    }


    public Point getCenter() {
        return center;
    }

    public Float getRadius() {
        return radius;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public void setRadius(Float radius) {
        this.radius = radius;
    }

}
