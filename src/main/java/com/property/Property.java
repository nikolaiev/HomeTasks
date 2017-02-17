package com.property;

/**
 * Created by vlad on 17.02.17.
 */
public abstract class Property {
    double price;
    int maxCount;

    public Property(double price, int maxCount) {
        this.price = price;
        this.maxCount = maxCount;
    }

    public double getPrice() {
        return price;
    }

    public int getMaxCount() {
        return maxCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Property property = (Property) o;

        if (Double.compare(property.price, price) != 0) return false;
        return maxCount == property.maxCount;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(price);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + maxCount;
        return result;
    }
}
