package com;

import com.flower.Flower;
import com.property.Property;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by vlad on 17.02.17.
 */
public class MyBouquet implements Bouquet {
    List<Flower> flowers=new ArrayList<Flower>();;
    List<Property> properties=new ArrayList<Property>();;

    /**
     * Empty constructor
     */
    public MyBouquet() {
    }

    /**
     * Sorts flowers in List flowers
     */
    public void sortFlowers() {
        Collections.sort(flowers);
    }

    /**
     * Get flower with stem length in diapason
     * @param sideOne one side
     * @param sideTwo second side
     * @return first founded flower or null
     */
    public Flower findStemRange(int sideOne, int sideTwo) {
        int maxLength=sideOne>=sideTwo?sideOne:sideTwo;
        int minLength=sideOne<sideTwo?sideOne:sideTwo;

        for(Flower flower:flowers){
            if(flower.getStemLength()<=maxLength &&flower.getStemLength()>=minLength){
                return flower;
            }
        }
        return null;
    }

    /**
     * Get total price of Bouquet
     * @return
     */
    public double getPrice() {
        double totalPrice=0;

        for(Flower flower:flowers){
            totalPrice+=flower.getPrice();
        }

        for(Property property:properties){
            totalPrice+=property.getPrice();
        }

        return totalPrice;
    }

    public void addFlower(Flower flower) {
        if(flower==null)
            throw new IllegalArgumentException();
        this.flowers.add(flower);
    }

    public void addProperty(Property property) {
        if(property==null)
            throw new IllegalArgumentException();

        int counter=0;

        for(Property property1:properties){
            if(property1.getClass()==property.getClass()){
                counter++;
            }
        }
        //if max limit reached
        if(counter==property.getMaxCount()){
            return;
        }
        this.properties.add(property);
    }

    public void removeFlower(Flower flower) {
        if(flower==null)
            throw new IllegalArgumentException();
        this.flowers.remove(flower);
    }

    public void removeProperty(Property property) {
        if(property==null)
            throw new IllegalArgumentException();
        this.properties.remove(property);
    }

    public List<Flower> getFlowers() {
        return flowers;
    }

    public List<Property> getProperties() {
        return properties;
    }

}
