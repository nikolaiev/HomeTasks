package com.task17;

import com.task17.components.Component;
import com.task17.components.Number;
import com.task17.components.OperationFactory;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by vlad on 06.03.17.
 */
public class Composite {
    private Component component;
    private final String expression;

    /**
     * Constructor
     * @param expression expresion to calculate
     */
    public Composite(String expression){
        expression=expression.replace(" ","");
        this.expression=expression;
    }

    /**
     * calculates expression
     * @return component tree calculation result
     */
    public int calculate(){
        if(component!=null)
            return component.calculate();
        //else
        this.createTree();
        return component.calculate();
    }

    /**
     * Creates component tree from expression
     */
    private void createTree(){
        LinkedList<Component> components=new LinkedList<>();        //components stack
        String tempComponent="";                                    //temp component string representation value
        Stack<Character> operStack=new Stack<>();                   //operations stack

        /*for each character in expression*/
        for(int i=0;i<expression.length();i++){
            char tempChar=expression.charAt(i);

            //if a digit
            if(Character.isDigit(tempChar)){
                //read all number
                while(!isOperator(tempChar) && i+1<=expression.length()){
                    tempComponent+=tempChar;
                    i++;

                    if(i!=expression.length())
                        tempChar=expression.charAt(i); //go to next symbol
                }

                //add Number component to component stack
                components.add(new Number(Integer.parseInt(tempComponent))); //add new Component to stack

                //clean temp value
                tempComponent = "";

                //if end of expression is not reached
                if(i!=expression.length())
                    tempChar = expression.charAt(--i);// return to previous symbol
            }

            /*if the operator*/
            if(isOperator(tempChar)){

                if(tempChar=='(')               //if symbol is open bracket
                    operStack.push(tempChar);
                else {
                    if (tempChar == ')') {           //if symbol is close bracket
                        char s = operStack.pop();

                        while (s != '(') {
                            char operation = s;
                            makeComponentFromStack(operation, components);   //create component from stack
                            s = operStack.pop();
                        }
                    } else {                          //if any another operator
                        if (operStack.size() > 0)      //if stack contains elements
                            if (getPriority(tempChar) <= getPriority(operStack.peek())) {
                                char operation = operStack.pop();
                                makeComponentFromStack(operation, components);
                            }
                        operStack.push(tempChar);

                    }// if temp char
                }

            } // if isOperator

        }// for each cycle

        /*if operation stack is nto empty*/
        while (!operStack.isEmpty()){
            char operation=operStack.pop();
            makeComponentFromStack(operation,components);   //create new component
        }
        component=components.getFirst(); //set component value
    }

    /**
     * Replace old Components with new Component obj from component stack and operation type
     * @param tempChar  operation type
     * @param components    components' stack
     */
    private void makeComponentFromStack(char tempChar,LinkedList<Component> components){
        Component rightComp=components.getLast();
        components.removeLast();
        Component leftComp=components.getLast();
        components.removeLast();

        Component component=
                OperationFactory.getOperationComponent(tempChar,leftComp,rightComp);
        components.add(component);
    }

    /**
     * Gives the priority of operation
     * @param s operation char representation
     * @return priority of operation
     */
    private byte getPriority(char s){
        switch (s)
        {
            case '(': return 0;
            case ')': return 1;
            case '+': return 2;
            case '-': return 3;
            case '*': return 4;
            //case '/': return 4;
            case '^': return 5;
            default: return 6;
        }
    }

    /**
     * Check if character is operator char representation
     * @param c character to check
     * @return  true if c is operator
     */
    private boolean isOperator(char c){
        if (("+-/*^()".indexOf(c) != -1))
            return true;
        return false;
    }
}
