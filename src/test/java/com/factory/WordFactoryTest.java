package com.factory;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by vlad on 19.02.17.
 */
public class WordFactoryTest {
    @Test
    public void getWord() throws Exception {
        WordFactory.getWord("Test");
        WordFactory.getWord("Test");
        assertEquals(1,WordFactory.wordsDB.size());
    }

}