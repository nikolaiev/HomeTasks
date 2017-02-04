package com.homework1.task2;

import com.homework1.task1.BitLengthGetter;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.Assert.*;

/**
 * Created by vlad on 04.02.17.
 */
public class BitChangerTest {
    BitChanger bitChanger;
    @Before
    public void init(){
        bitChanger=new BitChanger();
    }
    @Test
    public void changeBitToOne() throws Exception {
        assertEquals(16,bitChanger.changeBitToOne(0,4));
        assertEquals(-1,bitChanger.changeBitToOne(Integer.MAX_VALUE,
                BitLengthGetter.getIntLength()-1));
    }

    @Test
    public void changeBitToZero() throws Exception {
        /*boundary cases*/
        assertEquals(0,bitChanger.changeBitToZero(1,0));
        assertEquals(0,bitChanger.changeBitToZero(Integer.MIN_VALUE,
                BitLengthGetter.getIntLength()-1));

        /*middle case*/
        assertEquals(4,bitChanger.changeBitToZero(6,1));

    }

    @Test
    public void getMask() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = BitChanger.class.getDeclaredMethod("getMask", int.class);
        method.setAccessible(true);

        /*middle case*/
        assertEquals(16,method.invoke(bitChanger,4));

        /*boundary cases*/
        assertEquals(Integer.MIN_VALUE,method.invoke(bitChanger,BitLengthGetter.getIntLength()-1));
        assertEquals(1,method.invoke(bitChanger,0));
    }

}