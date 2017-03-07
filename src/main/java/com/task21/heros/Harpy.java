package com.task21.heros;

import com.task21.strategies.MixStrategy;
import com.task21.strategies.Strategy;

/**
 * Created by Vlad on 08.03.2017.
 */
public class Harpy extends Hero {
    /**
     * Constructor
     * @param name         name
     */
    public Harpy(String name) {
        super(name, new MixStrategy());
    }
}
