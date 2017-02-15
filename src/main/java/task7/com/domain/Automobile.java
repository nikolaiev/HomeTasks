package task7.com.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vlad on 14.02.17.
 */
public class Automobile implements AutoInterface {
    private double tankCapacity;
    private double fuelAmount;
    private int wheelsAmount;
    private String mark;
    private List<Wheel> wheels;
    private Engine engine;

    public Automobile(double tankCapacity, double fuelAmount, int wheelsAmount,
                      double wheelDiameter, String mark, Engine engine) {
        this.tankCapacity = tankCapacity;
        this.fuelAmount = fuelAmount;
        this.wheelsAmount = wheelsAmount;
        this.mark = mark;
        this.engine = engine;
        //init automobile wheels
        initWheels(wheelsAmount, wheelDiameter);
    }

    /**
     * Initialize automobile wheels
     *
     * @param wheelsAmount
     * @param wheelDiameter
     */
    private void initWheels(int wheelsAmount, double wheelDiameter) {
        int realWheelsAmount=4;
        if (wheelsAmount > 3 && wheelsAmount < 18 && wheelsAmount%2==0)
            realWheelsAmount=wheelsAmount;
        this.wheels = new ArrayList<Wheel>(realWheelsAmount);
        for (int i = 0; i < realWheelsAmount; i++) {
            this.wheels.add(new Wheel(wheelDiameter));
        }
    }

    public void go(double miles) {
        if (miles <= 0.) {
            return;
        }
        double fuelPerMile = this.engine.getFuelPerMile();
        double fuelNeeded = miles * fuelPerMile;

        if (fuelNeeded > fuelAmount)
            throw new IllegalArgumentException("Refuel is necessary!");
        //else

        this.fuelAmount -= fuelNeeded;
    }

    /**
     * add fuel to automobile tank
     *
     * @param amount
     */
    public void refuel(double amount) {
        this.fuelAmount += amount;
        this.fuelAmount =
                this.fuelAmount > tankCapacity ?
                        tankCapacity
                        : this.fuelAmount;
    }

    public void changeWheel(int index, Wheel wheel) {
        if (wheel == null)
            throw new IllegalArgumentException();
        if(index>wheels.size())
            throw new IndexOutOfBoundsException();

        this.wheels.set(index, wheel);
    }

    public void showMark() {
        System.out.println(mark);
    }

    public double getTankCapacity() {
        return tankCapacity;
    }

    public void setTankCapacity(double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public int getWheelsAmount() {
        return wheelsAmount;
    }

    public void setWheelsAmount(int wheelsAmount) {
        this.wheelsAmount = wheelsAmount;
    }

}
