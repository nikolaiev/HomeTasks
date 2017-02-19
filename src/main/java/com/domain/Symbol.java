package com.domain;

/**
 * Created by vlad on 19.02.17.
 */
public abstract class Symbol{
    private char symbol;

    public Symbol(char symbol){
        this.symbol=symbol;
    }

    public void showSymbol(){
        System.out.println(this.symbol);
    }

    @Override
    public String toString() {
        return ""+symbol;
    }

    public char getSymbol() {
        return symbol;
    }
}
