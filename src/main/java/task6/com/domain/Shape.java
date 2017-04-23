package task6.com.domain;

/**
 * Created by vlad on 14.02.17.
 */
public abstract class Shape {
    public abstract double getSquare();

    public double summ(Shape shape){
        return this.getSquare()+shape.getSquare();
    }
}
