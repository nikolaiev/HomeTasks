package com;

import com.flower.Flower;
import com.flower.FlowerFactory;
import com.flower.FlowerType;
import com.property.PropertyFactory;
import com.property.PropertyType;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by vlad on 17.02.17.
 */

public class Florist {
    public static void main(String[] args) throws ParseException {
        Bouquet bouquet =new MyBouquet();
        FlowerFactory flowerFactory=new FlowerFactory();
        PropertyFactory propertyFactory=new PropertyFactory();

        SimpleDateFormat simpleDateFormat= new SimpleDateFormat("yyyy/MM/dd");

        bouquet.addFlower(flowerFactory.createFlower(FlowerType.LILAC,2));
        bouquet.addFlower(flowerFactory.createFlower(FlowerType.TULIP,5,2,simpleDateFormat.parse("2010/02/12")));
        bouquet.addFlower(flowerFactory.createFlower(FlowerType.ROSE,10));

        bouquet.addProperty(propertyFactory.createProperty(PropertyType.HERB));
        bouquet.addProperty(propertyFactory.createProperty(PropertyType.HERB,20));
        bouquet.addProperty(propertyFactory.createProperty(PropertyType.TAPE,40));
        bouquet.addProperty(propertyFactory.createProperty(PropertyType.TAPE,40));
        bouquet.addProperty(propertyFactory.createProperty(PropertyType.WRAPPER,40));
        bouquet.addProperty(propertyFactory.createProperty(PropertyType.WRAPPER,40));

        System.out.println(bouquet.getPrice());
        System.out.println(bouquet.getFlowers());
        bouquet.sortFlowers();
        System.out.println(bouquet.getFlowers());
        System.out.println(bouquet.findStemRange(0,10));


    }
}
