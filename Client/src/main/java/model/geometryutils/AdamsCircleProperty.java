package model.geometryutils;

import java.util.ArrayList;
import java.util.List;

public class AdamsCircleProperty extends OperationCircleProperties {


    public AdamsCircleProperty() {
    }

    public AdamsCircleProperty(Triangle triangle) {
        super(triangle);
    }

    @Override
    public List<GeometricElement> getResultComponents() {
        List<GeometricElement> geometricElements = new ArrayList<>();
        //centrul triunghiului lui Adams este centru cercului inscri
        //https://mathworld.wolfram.com/AdamsCircle.html
        Circle inscribed = triangle.getInscribedCircle();
        Point centerA = inscribed.getCenter();
        Line bc = triangle.getLineEdge(2);
        //find the radius for circle
        float a = triangle.getLength(0);
        float b = triangle.getLength(1);
        float c = triangle.getLength(2);
        float s = (a + b + c) / 3;
        float p = a * b + b * c + c * a;
        float r = inscribed.getRadius();
        float ra = (float) (r * Math.sqrt(p * p - a * b * c * s - p * s * s) / (p - s * s));
        Circle adamCircle = new Circle(centerA, ra);
        geometricElements.add(adamCircle);
        adamCircle.getCenter().setIdentifier("I");
        geometricElements.add(inscribed);

        String identifier = "P";
        List<Point> allPoints = new ArrayList<>();
        Line line = triangle.getLineEdge(0);
        List<Point> points;
        points = adamCircle.getCircleLineIntersection(line);
        allPoints.addAll(points);
        points = inscribed.getCircleLineIntersection(line);
        allPoints.addAll(points);

        line = triangle.getLineEdge(1);
        points = adamCircle.getCircleLineIntersection(line);
        allPoints.addAll(points);
        points = inscribed.getCircleLineIntersection(line);
        allPoints.addAll(points);

        line = triangle.getLineEdge(2);
        points = adamCircle.getCircleLineIntersection(line);
        allPoints.addAll(points);
        points = inscribed.getCircleLineIntersection(line);
        allPoints.addAll(points);

        for (Point point : allPoints) {
            point.setIdentifier(identifier);
            identifier = String.valueOf((char) (identifier.charAt(0) + 1));
        }
        geometricElements.addAll(allPoints);

        geometricElements.add(new Line(centerA, triangle.getPoints().get(0)));
        geometricElements.add(new Line(centerA, triangle.getPoints().get(1)));
        geometricElements.add(new Line(centerA, triangle.getPoints().get(2)));

        return geometricElements;
    }

}
