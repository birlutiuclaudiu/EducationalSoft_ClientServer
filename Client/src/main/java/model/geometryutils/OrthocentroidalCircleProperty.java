package model.geometryutils;

import java.util.ArrayList;
import java.util.List;

public class OrthocentroidalCircleProperty extends OperationCircleProperties {

    public OrthocentroidalCircleProperty(Triangle triangle) {
        super(triangle);
    }

    @Override
    public List<GeometricElement> getResultComponents() {
        List<GeometricElement> geometricElements = new ArrayList<>();
        Point orthoCenter = triangle.getOrthocenter();
        Point weightCenter = triangle.getWeightCenter();
        Line line = new Line(orthoCenter, weightCenter);
        Point circleCenter = line.getMiddle();
        float radius = circleCenter.getDistance(orthoCenter);
        Circle circle = new Circle(circleCenter, radius);
        geometricElements.add(circle);
        //construct helpful circles
        Circle cLa = getTangentCircle(0);
        cLa.getCenter().setIdentifier("CLa");
        Circle cLb = getTangentCircle(1);
        cLb.getCenter().setIdentifier("CLb");
        Circle cLc = getTangentCircle(2);
        cLc.getCenter().setIdentifier("CLc");
        geometricElements.add(cLa);
        geometricElements.add(cLb);
        geometricElements.add(cLc);
        return geometricElements;
    }

    private Circle getTangentCircle(int i) {
        //we apply this formula to extract LA coordinates MaB^2 =MaLa * MaA
        //get the points
        Point a = triangle.getPoints().get(i % 3);
        Point b = triangle.getPoints().get((i + 1) % 3);
        Point c = triangle.getPoints().get((i + 2) % 3);
        //find the middle of edges
        Point ma = triangle.getLineEdge(i % 3).getMiddle();
        Point mb = triangle.getLineEdge((i + 1) % 3).getMiddle();
        Point mc = triangle.getLineEdge((i + 2) % 3).getMiddle();
        //get the distance
        float distMAb = ma.getDistance(b);
        float distMBc = mb.getDistance(c);
        float distMCa = mc.getDistance(a);
        float MaLa = distMAb * distMAb / ma.getDistance(a);
        float ta = MaLa / ma.getDistance(a);
        Line MaA = new Line(ma, a);
        Point La = MaA.getParametricPoint(ta);
        Circle circleLa = new Circle(La, a, b);
        return circleLa;

    }

}
