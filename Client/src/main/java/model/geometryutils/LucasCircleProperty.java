package model.geometryutils;

import java.util.ArrayList;
import java.util.List;

public class LucasCircleProperty extends OperationCircleProperties {

    public LucasCircleProperty(Triangle triangle) {
        super(triangle);
    }

    @Override
    public List<GeometricElement> getResultComponents() {
        //to compute Lucas Circle we need the R = circumscribed radius and the length of edges
        //we must determine C(L1, l1), C(L2, l2), C(L3, l3); L1 belongs to OA, L2 belongs to OB, L3 belongs to OC,
        //where O is circumscribed circle
        List<GeometricElement> geometricElements = new ArrayList<>();
        Point a = triangle.getPoints().get(0);
        Point b = triangle.getPoints().get(1);
        Point c = triangle.getPoints().get(2);
        float lenA = triangle.getLength(0);
        float lenB = triangle.getLength(1);
        float lenC = triangle.getLength(2);
        Circle circumCircle = triangle.getCircumscribedCircle();
        Point centerO = circumCircle.getCenter();
        float r = circumCircle.getRadius();
        //determine the radius
        float l1 = (r * lenB * lenC) / (lenB * lenC + 2 * lenA * r);
        float l2 = (r * lenC * lenA) / (lenC * lenA + 2 * lenB * r);
        float l3 = (r * lenA * lenB) / (lenA * lenB + 2 * lenC * r);
        //find center using parametric equation of line
        float t1 = l1 / r;
        float t2 = l2 / r;
        float t3 = l3 / r;
        Point L1 = new Point((1 - t1) * a.getX() + t1 * centerO.getX(), (1 - t1) * a.getY() + t1 * centerO.getY());
        Point L2 = new Point((1 - t2) * b.getX() + t2 * centerO.getX(), (1 - t2) * b.getY() + t2 * centerO.getY());
        Point L3 = new Point((1 - t3) * c.getX() + t3 * centerO.getX(), (1 - t3) * c.getY() + t3 * centerO.getY());

        Circle c1 = new Circle(L1, l1);
        Circle c2 = new Circle(L2, l2);
        Circle c3 = new Circle(L3, l3);
        c1.getCenter().setIdentifier("L1");
        c2.getCenter().setIdentifier("L2");
        c3.getCenter().setIdentifier("L3");
        circumCircle.getCenter().setIdentifier("O");
        geometricElements.add(c1);
        geometricElements.add(c2);
        geometricElements.add(c3);
        geometricElements.add(circumCircle);

        return geometricElements;
    }
}
