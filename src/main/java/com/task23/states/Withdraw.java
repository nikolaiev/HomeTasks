package com.task23.states;

import com.task23.Grant;

/**
 * Created by Vlad on 07.03.2017.
 */
public class Withdraw extends State {
    /**
     * Constructor
     *
     * @param grant grand object
     */
    public Withdraw(Grant grant) {
        super(grant);
    }
}
