package com.property;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by vlad on 17.02.17.
 */
public class PropertyFactory {
    //standard prices
    Map<PropertyType,Double> prices =new HashMap<PropertyType, Double>();;

    //standard prices
    {
        prices = new HashMap<PropertyType, Double>();
        prices.put(PropertyType.HERB, 0.5);
        prices.put(PropertyType.TAPE, 1.);
    }
    /**
     * Empty Constructor
     */
    public PropertyFactory() {
    }

    /**
     * Specific prices constructor
     * @param prices
     */
    public PropertyFactory(Map<PropertyType, Double> prices) {
        for(Map.Entry<PropertyType,Double> entry:prices.entrySet()){
            if(entry.getValue()>0){
                //update price
                this.prices.put(entry.getKey(),entry.getValue());
            }
        }
    }

    /**
     * Create specific price property
     * @param propertyType
     * @param price
     * @return
     */
    public Property createProperty(PropertyType propertyType,double price){
        if(price<0){
            throw new IllegalArgumentException();
        }

        switch (propertyType){
            case HERB: return new Herb(price);
            case TAPE: return new Tape(price);
            case WRAPPER: return new Wrapper(price);
        }
        return null;
    }

    /**
     * Create standard price property
     * @param propertyType
     * @return
     */
    public Property createProperty(PropertyType propertyType){
        double price;

        if(prices.containsKey(propertyType))
            price=prices.get(propertyType);
        else
            throw new IllegalArgumentException();

        return createProperty(propertyType,price);
    }
}
