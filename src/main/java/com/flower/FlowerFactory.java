package com.flower;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by vlad on 17.02.17.
 */
public class FlowerFactory {
    //standard prices
    Map<FlowerType,Double> prices=new HashMap<FlowerType, Double>();

    //standard prices
    {
        prices.put(FlowerType.CHAMOMILE,10.);
        prices.put(FlowerType.LILAC,25.);
        prices.put(FlowerType.LILY,15.);
        prices.put(FlowerType.ROSE,30.);
        prices.put(FlowerType.TULIP,12.);
    }

    /**
     * Empty constructor
     */
    public FlowerFactory() {}


    /**
     * Constructor
     * set specific prises
     * @param prices
     */
    public FlowerFactory(Map<FlowerType,Double> prices){
        for(Map.Entry<FlowerType,Double> entry:prices.entrySet()){
            if(entry.getValue()>0){
                //update price
                this.prices.put(entry.getKey(),entry.getValue());
            }
        }
    }

    /**
     * User creates specific flower
     * @param flowerType
     * @param stemLength
     * @param price
     * @param date
     * @return
     */
    public Flower createFlower(FlowerType flowerType, double stemLength, double price,Date date){
        /*throw IllegalArgumentException if stem has incorrect length*/
        if(stemLength<1||stemLength>100){
            throw new IllegalArgumentException();
        }

        /*throw IllegalArgumentException if price is less then 0*/
        if(price<0){
            throw new IllegalArgumentException();
        }

        switch (flowerType){
            case CHAMOMILE:return new Chamomile(date,stemLength,price);
            case LILAC:return  new Lilac(date,stemLength,price);
            case LILY: return new Lily(date,stemLength,price);
            case TULIP: return new Tulip(date,stemLength,price);
            case ROSE: return new Rose(date,stemLength,price);
        }
        return null;
    }

    /**
     * User wants create fresh flower
     * @param flowerType
     * @param stemLength
     * @param price
     * @return
     */
    public Flower createFlower(FlowerType flowerType, double stemLength, double price){
        return createFlower(flowerType,stemLength,price,new Date());
    }

    public Flower createFlower(FlowerType flowerType, double stemLength, Date date){
        double price;

        if(prices.containsKey(flowerType))
            price=prices.get(flowerType);
        else
            throw new IllegalArgumentException();

        return createFlower(flowerType,stemLength,price,date);
    }

    /**
     * User wants to use standart price
     * @param flowerType
     * @param stemLength
     * @return
     */
    public Flower createFlower(FlowerType flowerType, double stemLength){

        return createFlower(flowerType,stemLength,new Date());
    }
}
