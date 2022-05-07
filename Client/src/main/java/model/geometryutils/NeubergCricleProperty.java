package model.geometryutils;

import java.util.ArrayList;
import java.util.List;

public class NeubergCricleProperty extends OperationCircleProperties {


    public NeubergCricleProperty() {
    }

    public NeubergCricleProperty(Triangle triangle) {
        super(triangle);
    }

    @Override
    public List<GeometricElement> getResultComponents() {
        List<GeometricElement> geometricElements = new ArrayList<>();
        //we determine the neuberg circle using brocard angle; we want to determine the circle C(Na, R)
        geometricElements.addAll(getNeubergCircle(0, "Na"));
        geometricElements.addAll(getNeubergCircle(1, "Nb"));
        geometricElements.addAll(getNeubergCircle(2, "Nc"));

        return geometricElements;
    }

    private List<GeometricElement> getNeubergCircle(int i, String identifier) {
        List<GeometricElement> geometricElements = new ArrayList<>();
        float cotOmega = triangle.getBrocardAngle();
        float NaMa = triangle.getLength(i % 3) * cotOmega / 2;
        float radius = (float) (0.5 * triangle.getLength(i % 3) * Math.sqrt(cotOmega * cotOmega - 3));
        //find point Na
        Line bc = new Line(triangle.getPoints().get((i + 1) % 3), triangle.getPoints().get((i + 2) % 3));
        //mijlocul laturii bc este un capat al liniei
        Point ma = bc.getMiddle();
        List<Point> points = bc.getPerpendicularLines(ma, NaMa);
        Point Na1 = points.get(0);
        Point Na2 = points.get(1);
        Point Na = Na1.getDistance(triangle.getPoints().get(0)) > Na2.getDistance(triangle.getPoints().get(i)) ? Na2 : Na1;
        Circle neubergCircle = new Circle(Na, radius);
        neubergCircle.getCenter().setIdentifier(identifier);
        geometricElements.add(neubergCircle);
        geometricElements.add(ma);
        geometricElements.add(new Line(Na, ma));
        return geometricElements;
    }
}
