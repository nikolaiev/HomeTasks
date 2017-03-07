package com.task21.strategies;

/**
 * Created by Vlad on 08.03.2017.
 */
public class FlyingStrategy implements Strategy {
    @Override
    public void move() {
        System.out.println("Fly");
    }

    @Override
    public void flyWithMagic() {
        System.out.println("Fly with magic");
    }
}
