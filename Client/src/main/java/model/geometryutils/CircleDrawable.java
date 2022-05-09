package model.geometryutils;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class CircleDrawable extends GeometricElementDrawable implements java.io.Serializable, ShapeDrawable{

    private Circle circle;


    public CircleDrawable() {
        this.circle = new Circle();
    }

    public CircleDrawable(Circle circle) {
        this.circle = circle;
    }

    public CircleDrawable(Circle circle, Color color, String lineStyle, Float width) {
        super(color, lineStyle, width);
        this.circle = circle;
    }

    public Circle getCircle() {
        return circle;
    }

    public void setCircle(Circle circle) {
        this.circle = circle;
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        graphics2D.setColor(this.getColor());
        float[] dash1 = {10.0f, 20.0f};
        BasicStroke basicStroke;
        if (super.getLineStyle().contains("discont")) {
            basicStroke = new BasicStroke(super.getWidth(),
                    BasicStroke.CAP_ROUND,
                    BasicStroke.JOIN_MITER,
                    10.0f, dash1, 5.0f);
        } else {
            basicStroke = new BasicStroke(super.getWidth());
        }
        graphics2D.setStroke(basicStroke);
        float radius = this.circle.getRadius() * 2;
        float x = circle.getCenter().getX() - radius / 2;
        float y = circle.getCenter().getY() - radius / 2;
        Ellipse2D ellipse2D = new Ellipse2D.Float(x, y, radius, radius);
        graphics2D.draw(ellipse2D);
        if (circle.getCenter().getIdentifier() != null) {
            PointDrawable point = new PointDrawable(circle.getCenter(), Color.RED, "continue", 3f);
            point.draw(graphics2D);
        }
    }
}
