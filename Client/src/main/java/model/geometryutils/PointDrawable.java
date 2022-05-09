package model.geometryutils;

import java.awt.*;

public class PointDrawable extends GeometricElementDrawable implements java.io.Serializable, ShapeDrawable{
    private Point point;


    public PointDrawable() {
        super(Color.RED, "continue", 1.0f);
        this.point = new Point();
    }

    public PointDrawable(Point point, Color color, String lineStyle, Float width) {
        super(color, lineStyle, width);
        this.point = point;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        graphics2D.setColor(super.getColor());
        int x = Math.round(point.getX());
        int y = Math.round(point.getY());
        graphics2D.fillRect(x, y, 6, 6);
        if (point.getIdentifier() != null)
            graphics2D.drawString(point.getIdentifier(), x + 2, y + 3);


    }
}
