package com.task23.states;

import com.task23.Grant;

/**
 * Created by Vlad on 07.03.2017.
 */
public class Created extends State {
    /**
     * Constructor
     *
     * @param grant grand object
     */
    public Created(Grant grant) {
        super(grant);
    }

    @Override
    public void consider() {
        grant.setState(new Considering(grant));
    }

    @Override
    public void postpone() {
        grant.setState(new Postponed(grant));
    }

    @Override
    public void withdraw() {
        grant.setState(new Withdraw(grant));
    }
}
