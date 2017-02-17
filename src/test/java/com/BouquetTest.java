package com;

import com.flower.Flower;
import com.flower.FlowerFactory;
import com.flower.FlowerType;
import com.property.PropertyFactory;
import com.property.PropertyType;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.Assert.*;

/**
 * Created by vlad on 17.02.17.
 */
public class BouquetTest {
    FlowerFactory flowerFactory=new FlowerFactory();
    PropertyFactory propertyFactory=new PropertyFactory();
    Bouquet bouquet=new MyBouquet();
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/DD");
    {
        /*adding properties*/
        bouquet.addProperty(propertyFactory.createProperty(PropertyType.TAPE));
        bouquet.addProperty(propertyFactory.createProperty(PropertyType.HERB));
        bouquet.addProperty(propertyFactory.createProperty(PropertyType.TAPE));

        /*adding fowers*/
        try {
            bouquet.addFlower(flowerFactory.createFlower(FlowerType.CHAMOMILE,10,sdf.parse("2015/02/04")));
            bouquet.addFlower(flowerFactory.createFlower(FlowerType.ROSE,25,sdf.parse("2016/02/05")));
            bouquet.addFlower(flowerFactory.createFlower(FlowerType.TULIP,20,sdf.parse("2016/02/04")));
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
    @Test
    public void sortFlowers() throws Exception {
        bouquet.sortFlowers();
        for(int i=0;i<bouquet.getFlowers().size()-1;i++){
            if(bouquet.getFlowers().get(i)
                    .getCutDate()
                    .compareTo(bouquet.getFlowers().get(i+1).getCutDate())>0){
                assert (false);
            }
        }
    }

    @Test
    public void findStemRange() throws Exception {
        double stemLength=44.;
        bouquet.addFlower(flowerFactory.createFlower(FlowerType.CHAMOMILE,stemLength));
        Flower flower=bouquet.findStemRange(43,45);
        assertEquals(stemLength,flower.getStemLength(),0.001);
    }

    @Test
    public void getPrice() throws Exception {
        double price=98.5;
        bouquet.addFlower(flowerFactory.createFlower(FlowerType.CHAMOMILE,2,price));
        assertEquals(153.0,bouquet.getPrice(),0.001);
    }

    @Test
    public void addFlower() throws Exception {
        int initSize=bouquet.getFlowers().size();
        bouquet.addFlower(flowerFactory.createFlower(FlowerType.CHAMOMILE,10));
        assertEquals(initSize+1,bouquet.getFlowers().size());
    }

    @Test
    public void addPropertyNotReachedTop() throws Exception {
        Bouquet bouquet=new MyBouquet();
        int initSize=bouquet.getProperties().size();
        bouquet.addProperty(propertyFactory.createProperty(PropertyType.TAPE));

        assertEquals(initSize+1,bouquet.getProperties().size());
    }

    @Test
    public void addPropertyReachedNonOneTop() throws Exception {
        Bouquet bouquet=new MyBouquet();
        int initSize=bouquet.getProperties().size();

        int maxTapeCount=propertyFactory.createProperty(PropertyType.TAPE).getMaxCount();

        /*max top reached*/
        for(int i=0;i<maxTapeCount+2;i++){
            bouquet.addProperty(propertyFactory.createProperty(PropertyType.TAPE));
        }
        assertEquals(maxTapeCount,bouquet.getProperties().size());
    }

    @Test
    public void addPropertyReachedOneTop() throws Exception {
        Bouquet bouquet=new MyBouquet();
        int initSize=bouquet.getProperties().size();

        int maxTapeCount=propertyFactory.createProperty(PropertyType.WRAPPER).getMaxCount();
        System.out.println(maxTapeCount);
        /*max top reached*/
        for(int i=0;i<maxTapeCount+100;i++){
            bouquet.addProperty(propertyFactory.createProperty(PropertyType.WRAPPER));
        }
        assertEquals(maxTapeCount,bouquet.getProperties().size());
    }



    @Test
    public void removeFlower() throws Exception {
        Bouquet bouquet=new MyBouquet();

        bouquet.addFlower(flowerFactory.createFlower(FlowerType.CHAMOMILE,2));
        bouquet.addFlower(flowerFactory.createFlower(FlowerType.CHAMOMILE,1));
        bouquet.addFlower(flowerFactory.createFlower(FlowerType.CHAMOMILE,3));
        bouquet.addFlower(flowerFactory.createFlower(FlowerType.ROSE,3));
        bouquet.addFlower(flowerFactory.createFlower(FlowerType.ROSE,3));
        int flowerAmount=bouquet.getFlowers().size();
        bouquet.removeFlower(flowerFactory.createFlower(FlowerType.CHAMOMILE,2));
        assertEquals(flowerAmount-1,bouquet.getFlowers().size());

    }

    @Test
    public void removeProperty() throws Exception {
        Bouquet bouquet=new MyBouquet();

        bouquet.addProperty(propertyFactory.createProperty(PropertyType.TAPE));
        bouquet.addProperty(propertyFactory.createProperty(PropertyType.TAPE));
        bouquet.addProperty(propertyFactory.createProperty(PropertyType.TAPE));
        int propertyAmount=bouquet.getProperties().size();
        bouquet.removeProperty(propertyFactory.createProperty(PropertyType.TAPE));
        assertEquals(propertyAmount,bouquet.getProperties().size()+1);

    }
}