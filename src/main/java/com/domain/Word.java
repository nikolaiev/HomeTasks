package com.domain;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by vlad on 19.02.17.
 */
public class Word implements SentenceItem{
    List<Symbol> symbols;

    Word(List<Symbol> symbols){
        this.symbols=symbols;
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        for(Symbol ls: symbols){
            sb.append(ls.getSymbol());
        }
        return sb.toString();
    }

    //used in Word Factory
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Word word = (Word) o;

        return symbols != null ? symbols.equals(word.symbols) : word.symbols == null;
    }

    @Override
    public int hashCode() {
        return symbols != null ? symbols.hashCode() : 0;
    }
}
