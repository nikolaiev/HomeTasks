package com.domain;

import com.factory.SessionIdentifierGenerator;
import com.factory.WordFactory;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.NoSuchFileException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by vlad on 19.02.17.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TextTest {
    WordFactory wordFactory=WordFactory.getInstance();

    @Test
    public void aFindMaxSentenceWordsNull() throws Exception {

        Text text=new Text("test.txt");

        Map<Word,Integer> words=wordFactory.getSortedWords();

        Map.Entry<Word,Integer> entry=text.findMaxSentenceWords(words);

        assertEquals(entry.getKey(),null);
    }

    @Test
    public void bFindMaxSentenceWords() throws Exception {

        Text text=new Text("test2.txt");

        Map<Word,Integer> words=wordFactory.getSortedWords();

        Map.Entry<Word,Integer> entry=text.findMaxSentenceWords(words);

        assertEquals(entry.getKey(),wordFactory.getWord("Привет"));
    }

    /*No such file exception*/
    @Test(expected = NoSuchFileException.class)
    public void cFindMaxSentenceWordsException() throws IOException {
        Text text=new Text("NoSuchFile.txt");
    }

}