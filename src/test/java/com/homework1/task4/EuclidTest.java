package com.homework1.task4;

import com.homework1.task3.OutOfRangeExeption;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.hamcrest.CoreMatchers.isA;
import static org.junit.Assert.*;

/**
 * Created by vlad on 04.02.17.
 */
public class EuclidTest {
    Euclid euclid;

    @Rule
    public ExpectedException thrown= ExpectedException.none();


    @Before
    public void init(){
        euclid = new Euclid();
    }

    /*ok results expected*/
    @Test
    public void getMaxCommonDivisor() throws Exception {
        assertEquals(5,euclid.getMaxCommonDivisor(15,20));
        assertEquals(5,euclid.getMaxCommonDivisor(20,15));
        assertEquals(5,euclid.getMaxCommonDivisor(5,20));
        assertEquals(5,euclid.getMaxCommonDivisor(20,5));
        assertEquals(2,euclid.getMaxCommonDivisor(20,14));
        assertEquals(2,euclid.getMaxCommonDivisor(14,20));
        assertEquals(1,euclid.getMaxCommonDivisor(17,20));
        assertEquals(1,euclid.getMaxCommonDivisor(20,17));
    }

    @Test
    public void getPositiveRepr() throws Exception {
        Method method=Euclid.class.getDeclaredMethod("getPositiveRepr", int.class);
        method.setAccessible(true);

        assertEquals(10,method.invoke(euclid,-10));
        assertEquals(10,method.invoke(euclid,10));
        assertEquals(258410,method.invoke(euclid,-258410));
        assertEquals(258410,method.invoke(euclid,258410));
    }

    /*critical*/
    /*exception expected*/
    @Test
    public void getPositiveReprExeption() throws OutOfRangeExeption, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method=Euclid.class.getDeclaredMethod("getPositiveRepr", int.class);
        method.setAccessible(true);

        thrown.expectCause(isA(OutOfRangeExeption.class));
        assertEquals(0,method.invoke(euclid,Integer.MIN_VALUE));
    }
}