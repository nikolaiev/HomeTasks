package com.task17.components;

/**
 * Subtraction operation Component
 */
public class OperationSub extends Component {
    Component left;
    Component right;

    /**
     * Constructor
     * @param leftCompoennt left operand
     * @param rightCompoment rigth operand
     */
    public OperationSub(Component leftCompoennt, Component rightCompoment) {
        this.left = leftCompoennt;
        this.right = rightCompoment;
    }


    @Override
    public int calculate() {
        return left.calculate() - right.calculate();
    }
}
