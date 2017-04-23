package com.task17.components;

/**
 * Created by vlad on 06.03.17.
 * Pow operation component
 */
public class OperationPow extends Component {

    Component leftComponent;
    Component rightComponent;

    /**
     * Constructor
     * @param c1 left component
     * @param c2 rigth component
     */
    public OperationPow(Component c1, Component c2) {
        this.leftComponent=c1;
        this.rightComponent=c2;
    }

    @Override
    public int calculate() {
        return (int) Math.pow(leftComponent.calculate(),rightComponent.calculate());
    }
}
