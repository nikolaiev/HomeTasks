package com.task17.components;

/**
 * Created by vlad on 06.03.17.
 * Component that represents number
 */
public class Number extends Component {
    /*number value*/
    int val;

    /**
     * Constructor
     * @param val number value
     */
    public Number(int val){
        this.val=val;
    }

    @Override
    public int calculate() {
        return val;
    }
}
