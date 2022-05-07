package model.geometryutils;

import java.util.ArrayList;
import java.util.List;

public class TuckerCircleProperty extends OperationCircleProperties {

    public TuckerCircleProperty() {
    }

    public TuckerCircleProperty(Triangle triangle) {
        super(triangle);
    }

    @Override
    public List<GeometricElement> getResultComponents() {
        //to determine this circle, we need the antiparallels of the circle
        List<GeometricElement> geometricElements = new ArrayList<>();

        //in the folowing lines of code we determine an antiparallel, specific to point A
        Point bisPoint = triangle.getIntersectBisector(0);
        Line bisect = new Line(triangle.getPoints().get(0), bisPoint);
        float t = 0.25f;  //deplasare cu 25% fata de a
        Point p1 = bisect.getParametricPoint(t);
        Point p2 = bisect.getPerpendicularLines(p1, 20).get(0);

        Line antiparalellAux = new Line(p1, p2);
        Line ab = triangle.getLineEdge(2);
        Line ac = triangle.getLineEdge(1);
        Line bc = triangle.getLineEdge(0);
        Point p11 = ab.intersectionPoint(antiparalellAux);
        Point p12 = ac.intersectionPoint(antiparalellAux);
        Line antiparallelA = new Line(p11, p12);
        geometricElements.add(bisPoint);
        geometricElements.add(antiparallelA);

        //we determine now a paralell line P11R, R e BC using the property of distance
        float distP11Ac = p11.getDistanceToALine(ac);
        float lenbc = bc.getP1().getDistance(bc.getP2());
        float tP = (lenbc - distP11Ac) / lenbc;
        Point r = bc.getParametricPoint(tP);

        Circle circle = new Circle(p11, p12, r);
        geometricElements.add(circle);
        List<Point> pointsAB = circle.getCircleLineIntersection(ab);
        List<Point> pointsAC = circle.getCircleLineIntersection(ac);
        List<Point> pointsBC = circle.getCircleLineIntersection(bc);
        for (Point item : pointsAB) {
            for (Point value : pointsBC) {
                for (Point point : pointsAC) {
                    geometricElements.add(new Line(item, value));
                    geometricElements.add(new Line(item, point));
                    geometricElements.add(new Line(point, value));
                }
            }
        }
        return geometricElements;
    }


}
