package com.factory;

import com.domain.Symbol;
import com.domain.Word;
import org.junit.Test;

import java.lang.reflect.Method;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by vlad on 19.02.17.
 */
public class WordFactoryTest {
    WordFactory wordFactory=WordFactory.getInstance();
    @Test
    public void getWord() throws Exception {
        for(int i=0;i<100;i++){
            String randWord=SessionIdentifierGenerator.getRandomString();
            Word str1=wordFactory.getWord(randWord);
            Word str2=wordFactory.getWord(randWord);
            assert(str1==str2);
        }
    }

    @Test
    public void getSortedWords() throws Exception {

        Method method=WordFactory.class.getMethod("getSortedMap",Map.class);
        method.setAccessible(true);

        String randWord1=SessionIdentifierGenerator.getRandomString();
        String randWord2=SessionIdentifierGenerator.getRandomString();
        String randWord3=SessionIdentifierGenerator.getRandomString();

        Random r=new Random();
        @SuppressWarnings("unchecked")
        Map<Word,Integer> result= (Map<Word, Integer>) method.invoke(wordFactory,new HashMap<Word,Integer>(){{
            Word word1=wordFactory.getWord(randWord1);
            Word word2=wordFactory.getWord(randWord2);
            Word word3=wordFactory.getWord(randWord3);

            put(word1,r.nextInt(1000));
            put(word2,r.nextInt(1000));
            put(word3,r.nextInt(1000));
        }});

        Integer previous=null;
        for(Map.Entry<Word,Integer> entry:result.entrySet()){
            assertNotNull( entry.getValue() );
            if (previous != null) {
                assert(entry.getValue() <= previous);
            }
            previous = entry.getValue();
        }
    }
}

