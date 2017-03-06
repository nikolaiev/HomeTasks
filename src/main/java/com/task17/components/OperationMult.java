package com.task17.components;

/**
 * Multiply operation Component
 */
public class OperationMult extends Component {
    Component left;
    Component right;

    /**
     * Constructor
     * @param leftCompoennt left multiplier
     * @param rightCompoment right multiplier
     */
    public OperationMult(Component leftCompoennt, Component rightCompoment) {
        this.left = leftCompoennt;
        this.right = rightCompoment;
    }


    @Override
    public int calculate() {
        return left.calculate() * right.calculate();
    }
}

