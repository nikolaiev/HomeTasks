package com;

import com.flower.Flower;
import com.flower.FlowerFactory;
import com.flower.FlowerType;

/**
 * Created by vlad on 17.02.17.
 */
public class Florist {
    public static void main(String[] args) {
        Flavor flavor=new MyFlavor();
        FlowerFactory flowerFactory=new FlowerFactory();
        Flower flower=flowerFactory.createFlower(FlowerType.CHAMOMILE,10.);
        flavor.addFlower(flower);
        Flower flowerToRemove=flowerFactory.createFlower(FlowerType.LILAC,2.,11.);
        flavor.addFlower(flowerToRemove);
        flavor.addFlower(flower);
        System.out.println(flavor.getPrice());
        flavor.removeFlower(flowerToRemove);
        flavor.removeFlower(flowerToRemove);
        System.out.println(flavor.getPrice());
    }
}
