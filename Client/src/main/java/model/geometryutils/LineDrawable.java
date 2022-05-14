package model.geometryutils;

import java.awt.*;
import java.awt.geom.Line2D;

public class LineDrawable extends GeometricElementDrawable implements java.io.Serializable, ShapeDrawable {

    private Line line = null;

    public LineDrawable() {

    }

    public LineDrawable(Line line) {
        this.line = line;
    }


    public LineDrawable(Line line, Color color, String lineStyle, Float width) {
        super(color, lineStyle, width);
        this.line = line;
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        Line2D line2D = new Line2D.Float(line.getP1().getX(), line.getP1().getY(), line.getP2().getX(), line.getP2().getY());

        float[] dash1 = {10.0f, 20.0f};
        BasicStroke basicStroke;
        if (super.getLineStyle().contains("discont")) {
            basicStroke = new BasicStroke(super.getWidth(), BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER, 10.0f, dash1, 5.0f);
        } else {
            basicStroke = new BasicStroke(super.getWidth());
        }
        graphics2D.setStroke(basicStroke);
        graphics2D.setColor(super.getColor());
        graphics2D.draw(line2D);

    }

    public Line getLine() {
        return line;
    }

    public void setLine(Line line) {
        this.line = line;
    }

}
