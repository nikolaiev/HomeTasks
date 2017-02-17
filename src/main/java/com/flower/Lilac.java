package com.flower;

import java.util.Date;

/**
 * Created by vlad on 17.02.17.
 */
public class Lilac extends Flower {
    public Lilac(Date cutDate, double stemLength, double price) {
        super(cutDate, stemLength, price);
    }

    public Lilac(double stemLength, double price) {
        super(stemLength, price);
    }
}
