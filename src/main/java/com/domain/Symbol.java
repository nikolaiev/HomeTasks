package com.domain;

/**
 * Created by vlad on 19.02.17.
 */
public class Symbol{
    private char symbol;

    public Symbol(char symbol){
        this.symbol=symbol;
    }

    @Override
    public String toString() {
        return Character.toString(symbol);
    }

    public char getSymbol() {
        return symbol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Symbol symbol1 = (Symbol) o;

        return symbol == symbol1.symbol;
    }

    @Override
    public int hashCode() {
        return (int) symbol;
    }
}
