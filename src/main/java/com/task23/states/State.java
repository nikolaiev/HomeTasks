package com.task23.states;

import com.task23.Grant;

/**
 * Created by Vlad on 07.03.2017.
 */
public abstract class State {
    /*grand object to operate with*/
    protected Grant grant;

    /**
     * Constructor
     * @param grant grand object
     */
    public State(Grant grant){
        this.grant=grant;
    }

    /**
     * Change state to considering
     */
    public void consider(){
        System.out.println("We can't consider grant");
    }

    /**
     * Change state to postponed
     */
    public void postpone(){
        System.out.println("We can't postpone grant");
    }

    /**
     * Change state to denied
     */
    public void deny(){
        System.out.println("We can't deny grant");
    }

    /**
     * Change state to accepted
     */
    public void accept(){
        System.out.println("We can't accept grant");
    }

    /**
     * Change state to withdrawed
     */
    public void withdraw(){
        System.out.println("We can't withdraw grant");
    }

}
