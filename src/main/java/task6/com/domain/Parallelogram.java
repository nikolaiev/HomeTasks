package task6.com.domain;

/**
 * Created by vlad on 14.02.17.
 */
public class Parallelogram extends Shape {
    private Point point;
    private double sideOne;
    private double sideTwo;
    private double angle;

    public Parallelogram(Point point, double sideOne, double sideTwo, double angle) {
        this.point = point;
        this.sideOne = sideOne;
        this.sideTwo = sideTwo;
        this.angle = angle;
    }

    public Parallelogram(double x,double y,double sideOne, double sideTwo, double angle) {
        this.sideOne = sideOne;
        this.sideTwo = sideTwo;
        this.angle = angle;
        this.point=new Point(x,y);
    }

    public double getSquare() {
        return sideOne*sideTwo*Math.sin(angle);
    }
}
