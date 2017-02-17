package com.flower;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Created by vlad on 17.02.17.
 */
public class FlowerFactoryTest {
    FlowerFactory flowerFactory=new FlowerFactory();
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");

    /*non standard price constructor test*/
    @Test
    public void constructorTest(){
        final double nonStandardPrice=22.3;
        FlowerFactory flowerFactory=new FlowerFactory(new HashMap<FlowerType, Double>(){{
            put(FlowerType.CHAMOMILE,nonStandardPrice);
        }});

        Flower flower=flowerFactory.createFlower(FlowerType.CHAMOMILE,22);
        assertEquals(nonStandardPrice,flower.getPrice(),0.001);
    }

    /*null flower expected*/
    @Test
    public void createFlowerNull() throws Exception {
        Flower flower=flowerFactory.createFlower(null,100);
        assertEquals(flower,null);
    }

    @Test
    public void createFlowerNormal() throws Exception {
        Flower flower=flowerFactory.createFlower(FlowerType.LILAC,100);
        assertEquals(Lilac.class,flower.getClass());
    }

    @Test
    public void createFlowerNormalLength() throws Exception {
        Flower flower=flowerFactory.createFlower(FlowerType.LILAC,100);
        assertEquals(100,flower.getStemLength(),0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createFlowerExceptionSmallLength() throws Exception {
        Flower flower=flowerFactory.createFlower(FlowerType.LILAC,-1);
    }
    @Test(expected = IllegalArgumentException.class)
    public void createFlowerExceptionLargeLength() throws Exception {
        Flower flower=flowerFactory.createFlower(FlowerType.LILAC,101);
    }


    @Test
    public void createFlowerDate() throws Exception {
        Flower flower=flowerFactory.createFlower(FlowerType.LILAC,10,sdf.parse("2012/05/12"));
        assertEquals(sdf.parse("2012/05/12"),flower.cutDate);
    }

}