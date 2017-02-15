package task6.com.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vlad on 14.02.17.
 */
public class Triangle extends Shape{
    List<Point> points=new ArrayList<Point>(3);

    public Triangle(List<Point> points) {
        if(points.size()!=3)
            throw new IllegalArgumentException();
        this.points = points;
    }

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        if(points.size()!=3)
            throw new IllegalArgumentException();
        this.points = points;
    }

    @Override
    public double getSquare() {
        double sideOne=getSideLength(0,1);
        double sideTwo=getSideLength(1,2);
        double sideThree=getSideLength(0,2);
        /*half perimeter*/
        double p=(sideOne+sideThree+sideTwo)/2;
        /*Heron's formula*/
        return  Math.sqrt(p*(p-sideOne)*(p-sideTwo)*(p-sideThree));

    }

    private double getSideLength(int firstPointIndex,int secondPointIndex){
        Point pointOne=this.points.get(firstPointIndex);
        Point pointTwo=this.points.get(secondPointIndex);

        return Math.sqrt(
                Math.pow(pointOne.getX()-pointTwo.getX(),2)
                + Math.pow(pointOne.getY()-pointTwo.getY(),2)
        );
    }
}
