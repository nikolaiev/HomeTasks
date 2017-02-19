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
    List<LetterSymbol> symbols;

    public Word(List<LetterSymbol> symbols){
        this.symbols=symbols;
    }

    /**
     * Creates word from string
     * @param word
     */
    public Word(String word){
        symbols=new LinkedList<>();
        word.chars().forEach(i-> {symbols.add(new LetterSymbol((char)i));});
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        for(LetterSymbol ls: symbols){
            sb.append(ls.getSymbol());
        }
        return sb.toString();
    }
}
