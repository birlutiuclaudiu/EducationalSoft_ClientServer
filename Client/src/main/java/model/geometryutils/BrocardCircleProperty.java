package model.geometryutils;

import java.util.ArrayList;
import java.util.List;


public class BrocardCircleProperty extends OperationCircleProperties {

    public BrocardCircleProperty() {
    }

    public BrocardCircleProperty(Triangle triangle) {
        super(triangle);
    }

    @Override
    public List<GeometricElement> getResultComponents() {
        List<GeometricElement> geometricElements = new ArrayList<>();
        Line symmedian1 = triangle.getSymmedian(0);
        Line symmedian2 = triangle.getSymmedian(1);
        geometricElements.add(symmedian1);
        geometricElements.add(symmedian2);
        geometricElements.add(triangle.getSymmedian(2));

        //the center of brocard circle is the middle of the OK segment; K -Lemoine point, O -circumscribed circle
        Point k = symmedian1.intersectionPoint(symmedian2);
        k.setIdentifier("K");
        //find o
        Circle circumscribed = triangle.getCircumscribedCircle();
        float r = circumscribed.getRadius();
        Point o = circumscribed.getCenter();
        o.setIdentifier("O");
        Point brocardCenter = new Line(k, o).getMiddle();
        //radius computation
        float brocardRadius = k.getDistance(o);
        Circle brocardCircle = new Circle(brocardCenter, brocardRadius);

        geometricElements.add(brocardCircle);
        geometricElements.add(o);
        geometricElements.add(k);
        return geometricElements;
    }
}
