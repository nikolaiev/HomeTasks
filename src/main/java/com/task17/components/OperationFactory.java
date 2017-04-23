package com.task17.components;

/**
 * Created by vlad on 06.03.17.
 * Returns Operation - Component objects
 */
public final class OperationFactory {

    public static Component getOperationComponent(char c,Component c1,Component c2){
        switch (c){
            case '+': return new OperationPlus(c1,c2);
            case '-': return new OperationSub(c1,c2);
            case '*': return new OperationMult(c1,c2);
            case '^': return new OperationPow(c1,c2);
            default: throw new RuntimeException("Not supported operation!");
        }
    }
}
