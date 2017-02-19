package com.factory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import com.domain.LetterSymbol;

/**
 * Created by vlad on 19.02.17.
 * Implements FlyWeight pattern
 */


public class WordFactory{
    private static WordFactory instance = new WordFactory();
    public static WordFactory getInstance(){return instance;}
    private static List<LetterSymbol> symbols=new LinkedList<>();

    public List<LetterSymbol> getWord(String word){

        List<LetterSymbol> myCharacters = new ArrayList<>();

        for(char ch : word.toCharArray()){

            LetterSymbol symbol = null;

            for(LetterSymbol mc : symbols){

                if(mc.getSymbol() == ch){
                    symbol = mc;
                    break;
                }
            }

            if(symbol == null){
                LetterSymbol newLetter=new LetterSymbol(ch);

                symbols.add(newLetter);//adding to factory DB

                myCharacters.add(newLetter);

            } else {
                myCharacters.add(symbol);
            }
        }

        return myCharacters;
    }
}