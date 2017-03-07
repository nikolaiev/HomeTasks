package com.task23.states;

import com.task23.Grant;

/**
 * Created by Vlad on 07.03.2017.
 */
public class Considering extends State {
    /**
     * Constructor
     *
     * @param grant grand object
     */
    public Considering(Grant grant) {
        super(grant);
    }

    @Override
    public void postpone() {
        grant.setState(new Postponed(grant));
    }

    @Override
    public void deny() {
        grant.setState(new Denyed(grant));
    }

    @Override
    public void accept() {
        grant.setState(new Accepted(grant));
    }
}
