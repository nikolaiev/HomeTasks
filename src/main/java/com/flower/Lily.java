package com.flower;

import java.util.Date;

/**
 * Created by vlad on 17.02.17.
 */
public class Lily extends Flower{

    boolean isMoisten=false;

    public Lily(Date cutDate, double stemLength, double price) {
        super(cutDate, stemLength, price);
    }

    public Lily(double stemLength, double price) {
        super(stemLength, price);
    }

    public boolean isMoisten() {
        return isMoisten;
    }

    public void moisten() {
        isMoisten = true;
    }
}
