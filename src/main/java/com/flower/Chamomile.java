package com.flower;

import java.util.Date;

/**
 * Created by vlad on 17.02.17.
 */
public class Chamomile extends Flower {

    boolean isCleaned=false;

    public Chamomile(Date cutDate, double stemLength ,double price) {
        super(cutDate, stemLength,price);
    }

    public Chamomile(double stemLength ,double price) {
        super(stemLength,price);
    }

    public boolean isCleaned() {
        return isCleaned;
    }

    public void cleaned() {
        isCleaned = true;
    }
}
