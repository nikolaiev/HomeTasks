package com.factory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import com.domain.LetterSymbol;
import com.domain.Symbol;
import com.domain.Word;

/**
 * Created by vlad on 19.02.17.
 * Implements FlyWeight pattern
 */


public class WordFactory{
    private static WordFactory instance = new WordFactory();
    public static WordFactory getInstance(){return instance;}

    private static List<Word> wordsDB=new LinkedList<>();


    public static Word getWord(String word){

        List<LetterSymbol> myWordSymbols = new ArrayList<>();

        for(char ch : word.toCharArray()){
            Symbol symbol=SymbolFactory.getSymbol(ch);
            myWordSymbols.add((LetterSymbol) symbol);
        }

        Word myWord=new Word(myWordSymbols);

        if(wordsDB.contains(myWord)){
            return wordsDB.get(wordsDB.indexOf(myWord));
        }
        else {
            wordsDB.add(myWord);
            return myWord;
        }
    }
}