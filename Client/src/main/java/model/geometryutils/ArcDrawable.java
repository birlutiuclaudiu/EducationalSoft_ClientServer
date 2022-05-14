package model.geometryutils;

import java.awt.*;
import java.awt.geom.Arc2D;

public class ArcDrawable extends GeometricElementDrawable implements java.io.Serializable {

    private Arc arc;

    public ArcDrawable() {
    }

    public ArcDrawable(Arc arc, Color color, String lineStyle, Float width) {
        super(color, lineStyle, width);
        this.arc = arc;
    }

    public Arc getArc() {
        return arc;
    }

    public void setArc(Arc arc) {
        this.arc = arc;
    }

    @Override
    public void draw(Graphics2D graphics2D) {

        float radius = arc.getRadius() * 2;
        graphics2D.setColor(this.getColor());
        float[] dashingPattern3 = {10f, 10f, 1f, 10f};
        Stroke stroke = new BasicStroke(4f, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_MITER, 1.0f, dashingPattern3, 0.0f);
        graphics2D.setStroke(stroke);
        Arc2D arc2D = new Arc2D.Float(arc.getCenterX() - radius / 2, arc.getCenterY() - radius / 2, radius, radius, arc.getStartAngle(), arc.getAngularExtent(), 2);
        graphics2D.draw(arc2D);
    }
}
