package com.task23.states;

import com.task23.Grant;

/**
 * Created by Vlad on 07.03.2017.
 */
public class Postponed extends State {
    /**
     * Constructor
     *
     * @param grant grand object
     */
    public Postponed(Grant grant) {
        super(grant);
    }

    @Override
    public void consider() {
        grant.setState(new Considering(grant));
    }
}
