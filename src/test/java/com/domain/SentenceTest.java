package com.domain;

import com.factory.SessionIdentifierGenerator;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by vlad on 19.02.17.
 */
public class SentenceTest {
    WordFactory wordFactory=WordFactory.getInstance();
    SymbolFactory symbolFactory=SymbolFactory.getInstance();
    @Test
    public void getWordIteration() throws Exception {
        List<SentenceItem> itemList=new LinkedList<>();
        String str1=SessionIdentifierGenerator.getRandomString();
        String str2=SessionIdentifierGenerator.getRandomString();

        Word word1= wordFactory.getWord(str1);
        Word word2= wordFactory.getWord(str2);

        Random r=new Random();

        int iterWord1=r.nextInt(100);
        for(int i=0;i<iterWord1;i++){
            itemList.add(word1);
        }

        int iterWord2=r.nextInt(100);
        for(int i=0;i<iterWord2;i++){
            itemList.add(word2);
        }

        PunctuationSymbol point=(PunctuationSymbol)symbolFactory.getSymbol('.');
        itemList.add(point);

        Sentence sentence=new Sentence(itemList);

        assertEquals(iterWord1,sentence.getWordIteration(word1));
        assertEquals(iterWord2,sentence.getWordIteration(word2));
    }

}