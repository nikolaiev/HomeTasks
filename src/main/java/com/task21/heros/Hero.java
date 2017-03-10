package com.task21.heros;

import com.task21.strategies.MixStrategy;
import com.task21.strategies.Strategy;
import com.task21.strategies.SimpleStrategyType;

/**
 * Created by Vlad on 07.03.2017.
 * Describes Hero object
 */
public abstract class Hero {

    String name;            //hero name
    Strategy moveStrategy;  //hero moving strategy

    /**
     * Constructor
     * @param name          name
     * @param moveStrategy  moving strategy
     */
    public Hero(String name, Strategy moveStrategy) {
        /*no memory leaks!*/
        if(name==null || moveStrategy==null)
            throw new IllegalArgumentException();

        this.name = name;
        this.moveStrategy = moveStrategy;
    }

    public void flyWithMagic(){
        moveStrategy.flyWithMagic();
    }

    public void move(){
        moveStrategy.move();
    }

    public void move(SimpleStrategyType simpleStrategyType){
        if(moveStrategy instanceof MixStrategy)
            ((MixStrategy)moveStrategy).move(simpleStrategyType);
        else
            System.out.println("Hero does not have ability to choose type of moving");

    }
}
