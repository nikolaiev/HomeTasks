package com.homework1.task1;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by vlad on 04.02.17.
 */
public class BitLengthGetterTest {
    /*getting int length*/
    @Test
    public void getIntLength() throws Exception {
        assertEquals(32, BitLengthGetter.getIntLength());
    }

    /*getting byte length*/
    @Test
    public void getByteLength() throws Exception {
        assertEquals(8, BitLengthGetter.getByteLength());
    }

    /*getting long length*/
    @Test
    public void getLongLength() throws Exception {
        assertEquals(64, BitLengthGetter.getLongLength());
    }

    /*getting short length*/
    @Test
    public void getShortLength() throws Exception {
        assertEquals(16, BitLengthGetter.getShortLength());
    }
}