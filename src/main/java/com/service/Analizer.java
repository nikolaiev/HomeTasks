package com.service;

import com.domain.Symbol;
import com.domain.Text;

import java.io.IOException;

import com.domain.Word;
import com.factory.*;

/**
 * Created by vlad on 19.02.17.
 */
public class Analizer {
    public static void main(String[] args) throws IOException {
        Text text=new Text("test2.txt");

        System.out.println(text);

        System.out.println(SymbolFactory.symbolsDB.size());
        for(Symbol symbol:SymbolFactory.symbolsDB){
            System.out.println(symbol);
        }

        System.out.println(WordFactory.wordsDB.size());
        for(Word word:WordFactory.wordsDB){
            System.out.print(word+" ");
        }
    }
}
