package com.factory;

import java.util.*;
import java.util.stream.Collectors;

import com.domain.Symbol;
import com.domain.Word;

/**
 * Created by vlad on 19.02.17.
 * Implements FlyWeight pattern
 */


public class WordFactory{
    private SymbolFactory symbolFactory=SymbolFactory.getInstance();
    private static WordFactory instance = new WordFactory();
    private static Map<Word,Integer> wordsDB=new HashMap<>();

    private WordFactory(){}

    public static WordFactory getInstance(){return instance;}

    public Word getWord(String word){

        List<Symbol> myWordSymbols = new ArrayList<>();

        for(char ch : word.toCharArray()){
            Symbol symbol=symbolFactory.getSymbol(ch);
            myWordSymbols.add(symbol);
        }

        Word myWord=new Word(myWordSymbols);

        if(wordsDB.containsKey(myWord)){
            wordsDB.put(myWord,wordsDB.get(myWord)+1);//update counter

            for(Word keyWord:wordsDB.keySet()){
                if(keyWord.equals(myWord)){
                    return keyWord;
                }
            }
            //must not be here
            return null;
        }
        else {
            wordsDB.put(myWord,1);
            return myWord;
        }
    }


    public Map <Word,Integer>  getSortedWords(){
        return getSortedMap(wordsDB);
    }

    private <K,V extends Comparable<? super V>> Map<K, V> getSortedMap(Map<K,V> map) {
        return map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }

}