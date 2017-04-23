package task6.com.domain;

/**
 * Created by vlad on 14.02.17.
 */
public class Ring extends Shape{
    private Point point;
    private double radius;

    public Ring(Point point, double length) {
        this.point = point;
        this.radius = length;
    }

    public Ring(double x,double y,double length) {
        this.radius = length;
        this.point=new Point(x,y);
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getSquare() {
        return Math.PI*radius*radius;
    }
}
