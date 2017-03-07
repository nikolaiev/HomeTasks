package com.task21.strategies;

/**
 * Created by Vlad on 08.03.2017.
 */
public class FootStrategy implements Strategy {
    @Override
    public void move() {
        System.out.println("Go by foot");
    }

    @Override
    public void flyWithMagic() {
        System.out.println("Fly with magic");
    }
}
