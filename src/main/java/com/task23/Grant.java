package com.task23;

import com.task23.states.Created;
import com.task23.states.State;

/**
 * Created by Vlad on 07.03.2017.
 */
public class Grant {
    /*current grant state*/
    private State state;

    /**
     * Empty default constructor
     */
    public Grant() {
        this.state = new Created(this);
    }

    public void setState(State state) {
        this.state = state;
    }

    /**
     * Change state to considering
     */
    public void consider(){
        state.consider();
    }

    /**
     * Change state to postponed
     */
    public void postpone(){
        state.postpone();
    }

    /**
     * Change state to denied
     */
    public void deny(){
        state.deny();
    }

    /**
     * Change state to accepted
     */
    public void accept(){
        state.accept();
    }

    /**
     * Change state to withdraw
     */
    public void withdraw(){
        state.withdraw();
    }
}
