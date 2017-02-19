package com.domain;

/**
 * Created by vlad on 19.02.17.
 */
public class Symbol{
    private char symbol;

    public Symbol(char symbol){
        this.symbol=symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    @Override
    public String toString() {
        return Character.toString(symbol);
    }
}
