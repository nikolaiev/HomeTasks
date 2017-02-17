package com.flower;

import java.util.Date;

/**
 * Created by vlad on 17.02.17.
 */
public class Tulip extends Flower {
    public Tulip(Date cutDate, double stemLength, double price) {
        super(cutDate, stemLength, price);
    }

    public Tulip(double stemLength, double price) {
        super(stemLength, price);
    }
}
