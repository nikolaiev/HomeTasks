package com.task23.states;

import com.task23.Grant;

/**
 * Created by Vlad on 07.03.2017.
 */
public class Denyed extends State {
    /**
     * Constructor
     *
     * @param grant grand object
     */
    public Denyed(Grant grant) {
        super(grant);
    }
}
