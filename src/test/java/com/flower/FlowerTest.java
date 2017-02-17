package com.flower;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Created by vlad on 17.02.17.
 */
public class FlowerTest {
    FlowerFactory flowerFactory=new FlowerFactory();
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");

    @Test
    public void compareTo() throws Exception {
        Flower flower=flowerFactory.createFlower(FlowerType.CHAMOMILE,10,45);
        Flower flower2=flowerFactory.createFlower(FlowerType.CHAMOMILE,10,45);
        assertEquals(flower,flower2);
    }

    @Test
    public void getCutDate() throws Exception {
        Date date=sdf.parse("2012/02/15");
        Flower flower=flowerFactory.createFlower(FlowerType.CHAMOMILE,10,45,date);
        assertEquals(date,flower.getCutDate());

    }

    @Test
    public void getStemLength() throws Exception {
        double stemLength=45.12;
        Flower flower=flowerFactory.createFlower(FlowerType.CHAMOMILE,stemLength);
        assertEquals(stemLength,flower.getStemLength(),0.001);
    }

    @Test
    public void getPrice() throws Exception {
        double price=132.2;
        Flower flower=flowerFactory.createFlower(FlowerType.CHAMOMILE,45.12,price);
        assertEquals(price,flower.getPrice(),0.001);
    }


}