package com.task17.components;

/**
 * Plus operation Component
 */
public class OperationPlus extends Component {
    Component left;
    Component right;

    /**
     * Constructor
     * @param leftCompoennt left operand
     * @param rightCompoment right operand
     */
    public OperationPlus(Component leftCompoennt, Component rightCompoment) {
        this.left = leftCompoennt;
        this.right = rightCompoment;
    }


    @Override
    public int calculate() {
        return left.calculate() + right.calculate();
    }
}
