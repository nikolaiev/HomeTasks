package task7.com.domain;

/**
 * Created by vlad on 14.02.17.
 */
public class Wheel {
    private double diameter=13;

    public Wheel(double diameter) {
        setDiameter(diameter);
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        if(diameter>30||diameter<10)
            return;
        this.diameter = diameter;
    }
}
