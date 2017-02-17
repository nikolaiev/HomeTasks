package com.flower;

import java.util.Date;

/**
 * Created by vlad on 17.02.17.
 */
public class Rose extends Flower {
    public Rose(Date cutDate, double stemLength, double price) {
        super(cutDate, stemLength, price);
    }

    public Rose(double stemLength, double price) {
        super(stemLength, price);
    }
}
