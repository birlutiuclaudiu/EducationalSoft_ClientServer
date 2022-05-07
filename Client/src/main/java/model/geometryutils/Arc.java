package model.geometryutils;

public class Arc extends GeometricFigure {

    private Float startAngle;
    private Float endAngle;
    private Point center;
    private Float radius;

    public Arc(){

    }

    @Override
    public Float computeAria() {
        return (float) (this.getAngularExtent() * Math.PI * this.radius * this.radius / 360);
    }

    public Arc(Float startAngle, Float endAngle, Point p, Float radius) {
        this.startAngle = startAngle;
        this.endAngle = endAngle;
        this.center = p;
        this.radius = radius;
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

    public Float getRadius() {
        return this.radius;
    }

    public Float getCenterX() {
        return (float) center.getX();
    }

    public Float getCenterY() {
        return (float) center.getY();
    }

    public Float getEndAngle() {
        return endAngle;
    }

    public Point getCenter() {
        return center;
    }

    public void setStartAngle(Float startAngle) {
        this.startAngle = startAngle;
    }

    public void setEndAngle(Float endAngle) {
        this.endAngle = endAngle;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public void setRadius(Float radius) {
        this.radius = radius;
    }
}
