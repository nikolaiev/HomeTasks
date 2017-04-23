package task7.com.domain;

/**
 * Created by vlad on 14.02.17.
 */
public class Engine {
    private double volume;
    private int horsePower;
    private double fuelPerMile;

    public Engine(double volume, int horsePower, double fuelPerMile) {
        this.volume = volume;
        this.horsePower = horsePower;
        this.fuelPerMile = fuelPerMile;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public double getFuelPerMile() {
        return fuelPerMile;
    }

    public void setFuelPerMile(double fuelPerMile) {
        this.fuelPerMile = fuelPerMile;
    }
}
