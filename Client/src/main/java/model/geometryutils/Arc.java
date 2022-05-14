package model.geometryutils;

public class Arc extends GeometricFigure {

    private Float startAngle;
    private Float endAngle;
    private Point center;
    private Float radius;

    public Arc() {

    }

    public Arc(Float startAngle, Float endAngle, Point p, Float radius) {
        this.startAngle = startAngle;
        this.endAngle = endAngle;
        this.center = p;
        this.radius = radius;
    }

    @Override
    public Float computeAria() {
        return (float) (this.getAngularExtent() * Math.PI * this.radius * this.radius / 360);
    }

    public Float getSectorAria() {

        return (float) (this.getAngularExtent() * Math.PI * this.radius * this.radius / 360);
    }

    public Float getArcLength() {
        return (float) (this.getAngularExtent() * 2 * Math.PI * this.radius / 360);
    }

    public Float getAngularExtent() {

        return Math.min(Math.abs(endAngle - startAngle), 360);
    }

    public Float getStartAngle() {
        return this.startAngle;
    }

    public void setStartAngle(Float startAngle) {
        this.startAngle = startAngle;
    }

    public Float getRadius() {
        return this.radius;
    }

    public void setRadius(Float radius) {
        this.radius = radius;
    }

    public Float getCenterX() {
        return center.getX();
    }

    public Float getCenterY() {
        return center.getY();
    }

    public Float getEndAngle() {
        return endAngle;
    }

    public void setEndAngle(Float endAngle) {
        this.endAngle = endAngle;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }
}
