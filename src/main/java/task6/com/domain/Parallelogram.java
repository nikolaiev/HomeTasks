package task6.com.domain;

/**
 * Created by vlad on 14.02.17.
 *
 * Parallelogram class
 */
public class Parallelogram extends Shape {
    private Point point;
    private double sideOne;
    private double sideTwo;
    private double angle;


    /**
     * Constructor
     * @param point
     * @param sideOne
     * @param sideTwo
     * @param angle
     */
    public Parallelogram(Point point, double sideOne, double sideTwo, double angle) {
        this.point = point;
        this.sideOne = sideOne;
        this.sideTwo = sideTwo;
        this.angle = angle;
    }

    /**
     * Constructor reload
     * @param x
     * @param y
     * @param sideOne
     * @param sideTwo
     * @param angle
     */
    public Parallelogram(double x,double y,double sideOne, double sideTwo, double angle) {
        this(new Point(x,y),sideOne, sideTwo, angle);
    }

    @Override
    public double getSquare() {
        return Math.abs(sideOne*sideTwo*Math.sin(angle));
    }
}
