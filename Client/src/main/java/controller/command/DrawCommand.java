package controller.command;

import lombok.AllArgsConstructor;
import model.EducationalModel;
import model.geometryutils.Point;
import model.geometryutils.Polygon;
import model.geometryutils.*;
import view.EducationalSoftGUI;

import java.awt.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@AllArgsConstructor
public class DrawCommand implements ICommand {

    public EducationalModel modelEdu;
    public EducationalSoftGUI educationalSoftGUI;


    @Override
    public void Execute() {
        Drawing drawing = this.modelEdu.getDrawing();
        drawing.setGeometricElementDrawables(new ArrayList<>());
        try {
            drawing.setLineStyle(this.educationalSoftGUI.getLineStyle());
            drawing.setLineWidth(Float.parseFloat(this.educationalSoftGUI.getLineWidth()));
        } catch (NumberFormatException n) {
            drawing.setLineWidth(1.0f);
        }
        switch (this.educationalSoftGUI.getDrawingOption()) {
            case "circle":
                constructCircle();
                this.modelEdu.notifyObserver("draw");
                break;
            case "polygon":
                constructPolygon();
                this.modelEdu.notifyObserver("draw");
                break;
            case "triangle":
                Triangle triangle = constructTriangle();
                switch (this.educationalSoftGUI.getTriangleProperty()) {
                    case 0:   //Circumscribed Circle
                        drawCircumscribedCircleOfTriangle(triangle);
                        break;
                    case 1:    //"Inscribed Circle"
                        drawInscribedCircleOfTriangle(triangle);
                        break;
                    case 2:    //"Tucker Circle"
                        drawingElementsOfTriangle(new TuckerCircleProperty(triangle));
                        break;
                    case 3:     //"Lucas Circle"
                        drawingElementsOfTriangle(new LucasCircleProperty(triangle));
                        break;
                    case 4:     //"Orthocentroidal Circle":
                        drawingElementsOfTriangle(new OrthocentroidalCircleProperty(triangle));
                        break;
                    case 5:     //"Neuberg Circle":
                        drawingElementsOfTriangle(new NeubergCricleProperty(triangle));
                        break;
                    case 6:     //"Adams Circle":
                        drawingElementsOfTriangle(new AdamsCircleProperty(triangle));
                        break;
                    case 7:     // "Brocard Circle":
                        drawingElementsOfTriangle(new BrocardCircleProperty(triangle));
                        break;
                    default:
                        break;
                }
                break;
            default:
                break;
        }
        this.modelEdu.notifyObserver("draw");
        this.modelEdu.setState("draw");
    }

    //for drawing the circle and his specific components
    private void constructCircle() {
        Drawing drawing = this.modelEdu.getDrawing();
        model.geometryutils.Point center = new model.geometryutils.Point(drawing.getOldX(), drawing.getOldY());
        model.geometryutils.Point point2 = new model.geometryutils.Point(drawing.getNewX(), drawing.getNewY());
        float radius = center.getDistance(point2);
        Circle circle = new Circle(center, radius);
        Line radiusLine = new Line(center, point2);

        drawing.addGeometricElement(new PointDrawable(center, drawing.getColor(), drawing.getLineStyle(), drawing.getLineWidth()));
        drawing.addGeometricElement(new LineDrawable(radiusLine, drawing.getColor(), drawing.getLineStyle(), drawing.getLineWidth()));
        drawing.addGeometricElement(new CircleDrawable(circle, drawing.getColor(), drawing.getLineStyle(), drawing.getLineWidth()));
        //computations to determine the arc properties
        float startAngleArc = 0;
        float endAngelArc = 0;
        try {
            startAngleArc = Integer.parseInt(this.educationalSoftGUI.getArcStartAngle());
            endAngelArc = Integer.parseInt(this.educationalSoftGUI.getArcEndAngle());
        } catch (NumberFormatException exc) {
            startAngleArc = 0;
            endAngelArc = 0;
        } finally {
            //the two values must be between 0 and 360
            startAngleArc %= 360;
            startAngleArc %= 360;
        }
        Arc arc = new Arc(startAngleArc, endAngelArc, center, radius);
        //the case in which the arc should not be drawn
        if (!(startAngleArc == 0 && endAngelArc == 0)) {
            Random r = new Random();
            Color randColor = new Color(r.nextFloat(), r.nextFloat() / 2f, r.nextFloat() / 2f);
            drawing.addGeometricElement(new ArcDrawable(arc, randColor, "discontinue", 3.0f));
        }
        setCircleProperties(circle, arc);
    }

    private void setCircleProperties(Circle circle, Arc arc) {
        DecimalFormat df = new DecimalFormat("0.00");
        this.educationalSoftGUI.setCircleRadius("R: " + df.format(circle.getRadius()));
        this.educationalSoftGUI.setCircleLength(df.format(circle.computeLength()));
        this.educationalSoftGUI.setCircleAria(df.format(circle.computeAria()));
        this.educationalSoftGUI.setArcLength(df.format(arc.getArcLength()));
        this.educationalSoftGUI.setSectionAria(df.format(arc.getSectorAria()));
    }

    private void constructPolygon() {
        Drawing drawing = this.modelEdu.getDrawing();
        model.geometryutils.Point center = new model.geometryutils.Point(drawing.getOldX(), drawing.getOldY());
        model.geometryutils.Point point2 = new model.geometryutils.Point(drawing.getNewX(), drawing.getNewY());
        float radius = center.getDistance(point2);
        int nbVertices = 3;
        try {
            nbVertices = Integer.parseInt(this.educationalSoftGUI.getNbOfVertices());
            if (nbVertices < 3)
                nbVertices = 3; //default it remains 3; to define a triangle -> the minimum polygon
        } catch (NumberFormatException ignored) {

        }
        float angle = (float) (2 * Math.PI / nbVertices);
        java.util.List<model.geometryutils.Point> pointList = new ArrayList<>();
        //adaugare primul punct
        pointList.add(new model.geometryutils.Point(center.getX() + (int) Math.round(radius), center.getY()));
        for (int i = 1; i < nbVertices; i++) {
            float px = (float) (Math.cos((angle) * i) * radius + center.getX());
            float py = (float) (Math.sin((angle) * i) * radius + center.getY());
            pointList.add(new model.geometryutils.Point(px, py));
        }
        GeometricElement polygon = new model.geometryutils.Polygon(pointList);
        drawing.addGeometricElement(new PolygonDrawable((Polygon) polygon, drawing.getColor(), drawing.getLineStyle(), drawing.getLineWidth()));
        //circumscribed circle
        drawing.addGeometricElement(new CircleDrawable(new Circle(center, radius), Color.RED, "continue", 2.0f));
        float inscribedRadius = center.getDistanceToALine(new Line(pointList.get(0), pointList.get(1)));
        GeometricElement inscribedCircle = new Circle(center, inscribedRadius);
        drawing.addGeometricElement(new CircleDrawable((Circle) inscribedCircle, Color.BLUE, "continue", 2.0f));
        drawing.addGeometricElement(new PointDrawable(center, Color.BLUE, "continue", 1.0f));
    }

    private Triangle constructTriangle() {
        Drawing drawing = this.modelEdu.getDrawing();
        java.util.List<Float> x = drawing.getTriangleX();
        java.util.List<Float> y = drawing.getTriangleY();
        model.geometryutils.Point a = new model.geometryutils.Point(x.get(0), y.get(0), "A");
        model.geometryutils.Point b = new model.geometryutils.Point(x.get(1), y.get(1), "B");
        model.geometryutils.Point c = new model.geometryutils.Point(x.get(2), y.get(2), "C");
        model.geometryutils.Point oldMousePoint = new model.geometryutils.Point(drawing.getOldX(), drawing.getOldY());
        model.geometryutils.Point newMousePoint = new model.geometryutils.Point(drawing.getNewX(), drawing.getNewY());
        if (oldMousePoint.getDistance(a) < 10f) {
            a = newMousePoint;
            a.setIdentifier("A");
            x.set(0, a.getX());
            y.set(0, a.getY());
        } else if (oldMousePoint.getDistance(b) < 10f) {
            b = newMousePoint;
            b.setIdentifier("B");
            x.set(1, b.getX());
            y.set(1, b.getY());
        } else if (oldMousePoint.getDistance(c) < 10f) {
            c = newMousePoint;
            c.setIdentifier("C");
            x.set(2, c.getX());
            y.set(2, c.getY());
        }
        drawing.setTriangleX(x);
        drawing.setTriangleY(y);
        drawing.setMouseOldPosition(drawing.getNewX(), drawing.getNewY());
        //construct the triangle
        Triangle triangle = new Triangle(a, b, c);
        drawing.addGeometricElement(new TriangleDrawable(triangle, drawing.getColor(), drawing.getLineStyle(), drawing.getLineWidth()));
        return triangle;
    }

    private void drawCircumscribedCircleOfTriangle(Triangle triangle) {
        Drawing drawing = this.modelEdu.getDrawing();
        Circle circle = triangle.getCircumscribedCircle();
        drawing.addGeometricElement(new CircleDrawable(circle, Color.RED, "continue", 2.0f));
        model.geometryutils.Point ma = circle.getCenter().getProjection(new Line(triangle.getPoints().get(1), triangle.getPoints().get(2)));
        model.geometryutils.Point mb = circle.getCenter().getProjection(new Line(triangle.getPoints().get(0), triangle.getPoints().get(2)));
        model.geometryutils.Point mc = circle.getCenter().getProjection(new Line(triangle.getPoints().get(0), triangle.getPoints().get(1)));
        drawing.addGeometricElement(new LineDrawable(new Line(circle.getCenter(), ma),
                Color.BLUE, "discontinue", 2.0f));
        drawing.addGeometricElement(new LineDrawable(new Line(circle.getCenter(), mb),
                Color.BLUE, "discontinue", 2.0f));
        drawing.addGeometricElement(new LineDrawable(new Line(circle.getCenter(), mc),
                Color.BLUE, "discontinue", 2.0f));
    }

    private void drawInscribedCircleOfTriangle(Triangle triangle) {
        Drawing drawing = this.modelEdu.getDrawing();
        Circle circle = triangle.getInscribedCircle();
        Line bisA = new Line(circle.getCenter(), triangle.getPoints().get(0));
        Line bisB = new Line(circle.getCenter(), triangle.getPoints().get(1));
        Line bisC = new Line(circle.getCenter(), triangle.getPoints().get(2));
        CircleDrawable circleDrawable = (CircleDrawable) new ShapeDrawableFactory().getShape("CIRCLE");
        circleDrawable.setCircle(circle);
        circleDrawable.setColor(Color.green);
        circleDrawable.setLineStyle("discontinue");
        circleDrawable.setWidth(2.0f);
        drawing.addGeometricElement(circleDrawable);
        drawing.addGeometricElement(new LineDrawable(bisA, Color.MAGENTA, "discontinue", 2f));
        drawing.addGeometricElement(new LineDrawable(bisB, Color.MAGENTA, "discontinue", 2f));
        drawing.addGeometricElement(new LineDrawable(bisC, Color.MAGENTA, "discontinue", 2f));
    }

    private void drawingElementsOfTriangle(OperationCircleProperties operation) {
        Drawing drawing = this.modelEdu.getDrawing();
        List<GeometricElement> geometricElements = operation.getResultComponents();
        for (GeometricElement geom : geometricElements) {
            if (geom instanceof model.geometryutils.Point) {
                drawing.addGeometricElement(new PointDrawable((Point) geom, Color.BLUE, "continue", 2.0f));
            } else if (geom instanceof Circle) {
                drawing.addGeometricElement(new CircleDrawable((Circle) geom, Color.RED, "continue", 2.0f));
            } else if (geom instanceof Line) {
                drawing.addGeometricElement(new LineDrawable((Line) geom, Color.MAGENTA, "discontinue", 2.0f));
            }
        }
    }
}