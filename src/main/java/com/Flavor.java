package com;

import com.flower.Flower;
import com.property.Property;

/**
 * Created by vlad on 17.02.17.
 */
public interface Flavor {
    void sortFlowers();
    Flower findStemRange(int sideOne,int sideTwo);
    double getPrice();
    void addFlower(Flower flower);
    void addProperty(Property property);
    void removeFlower(Flower flower);
    void removeProperty(Property property);
}
