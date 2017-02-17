package com.flower;

import java.util.Date;

/**
 * Created by vlad on 17.02.17.
 * Base Flower class for inherited specific flowers' classes
 */
public abstract class Flower implements Comparable<Flower>{
    Date cutDate;
    double stemLength;
    double price;

    /**
     * Constructor
     * @param cutDate
     * @param stemLength flower's stem length (sm)
     * @param price ($)
     */
    public Flower(Date cutDate, double stemLength, double price) {
        this.cutDate = cutDate;
        this.stemLength = stemLength;
        this.price = price;
    }

    public Flower(double stemLength, double price) {
        this.cutDate = new Date();
        this.stemLength = stemLength;
        this.price = price;
    }

    /**
     * Show if flower more fresh
     * @param flower comparable flower
     * @return 0,-1,1 in accordance to Comparable interface specification
     */
    public int compareTo(Flower flower){
        return this.cutDate.compareTo(flower.cutDate);
    }

    public Date getCutDate() {
        return cutDate;
    }

    public double getStemLength() {
        return stemLength;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Flower flower = (Flower) o;

        if (Double.compare(flower.stemLength, stemLength) != 0) return false;
        if (Double.compare(flower.price, price) != 0) return false;
        return cutDate != null ? cutDate.equals(flower.cutDate) : flower.cutDate == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = cutDate != null ? cutDate.hashCode() : 0;
        temp = Double.doubleToLongBits(stemLength);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
