package task6.com.domain;

/**
 * Created by vlad on 14.02.17.
 */
public class Trapezium extends Shape{
    private Point point;
    private double mainSideOne;
    private double mainSideTwo;
    private double side;
    private double angle;

    public Trapezium(Point point, double mainSideOne, double mainSideTwo,
                     double side,double angle) {
        this.point = point;
        this.mainSideOne = mainSideOne;
        this.mainSideTwo = mainSideTwo;
        this.side = side;
        /*sharp angle*/
        this.angle=angle>Math.PI/2?Math.PI-angle:angle;
    }

    public Trapezium(double x,double y,double mainSideOne, double mainSideTwo,
                     double side,double angle) {
        this.point=new Point(x,y);
        this.mainSideOne = mainSideOne;
        this.mainSideTwo = mainSideTwo;
        this.side = side;
        /*sharp angle*/
        this.angle=angle>Math.PI/2?Math.PI-angle:angle;
    }


    public double getSquare() {
        double height=side*Math.sin(angle);
        return (mainSideOne+mainSideTwo)/2*height;
    }
}
