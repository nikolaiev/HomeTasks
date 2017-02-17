package com;

import com.flower.Flower;
import com.property.Property;

import java.util.List;

/**
 * Created by vlad on 17.02.17.
 */
public interface Bouquet {

    void sortFlowers();
    Flower findStemRange(int sideOne,int sideTwo);
    double getPrice();
    void addFlower(Flower flower);
    void addProperty(Property property);
    void removeFlower(Flower flower);
    void removeProperty(Property property);
    List<Flower> getFlowers();
    List<Property> getProperties();
}
