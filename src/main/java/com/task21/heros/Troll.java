package com.task21.heros;

import com.task21.strategies.FootStrategy;
import com.task21.strategies.Strategy;

/**
 * Created by Vlad on 08.03.2017.
 */
public class Troll extends Hero {
    /**
     * Constructor
     * @param name         name
     */
    public Troll(String name) {
        super(name, new FootStrategy());
    }
}
