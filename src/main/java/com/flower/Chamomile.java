package com.flower;

import java.util.Date;

/**
 * Created by vlad on 17.02.17.
 */
public class Chamomile extends Flower {
    /**
     * Constructor
     *
     * @param cutDate
     * @param stemLength flower's stem length (sm)
     */
    public Chamomile(Date cutDate, double stemLength ,double price) {
        super(cutDate, stemLength,price);
    }

    public Chamomile(double stemLength ,double price) {
        super(stemLength,price);
    }
}
