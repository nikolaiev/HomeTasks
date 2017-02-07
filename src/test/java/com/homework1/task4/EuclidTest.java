package com.homework1.task4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.isA;
import static org.junit.Assert.*;

/**
 * Created by vlad on 04.02.17.
 */
public class EuclidTest {
    private static final String VAL_OUT_OF_RANGE="VALUE OUT OF RANGE"; //exception message
    private Euclid euclid;

    @Rule
    public ExpectedException thrown= ExpectedException.none();

    @Before
    public void init(){
        euclid = new Euclid();
    }

    /*Method getMaxCommonDivisor*/
    /*ok results expected on method*/
    @Test
    public void getMaxCommonDivisor() throws Exception {
        assertEquals(5,euclid.getMaxCommonDivisor(15,20));
        assertEquals(5,euclid.getMaxCommonDivisor(20,15));
        assertEquals(2,euclid.getMaxCommonDivisor(14,20));
        assertEquals(1,euclid.getMaxCommonDivisor(17,20));
        assertEquals(1,euclid.getMaxCommonDivisor(20,17));
    }
    /*exception expected*/
    @Test
    public void getMaxCommonDivisorExeption () throws Exception{
        thrown.expect(Exception.class);
        thrown.expectMessage(VAL_OUT_OF_RANGE);
        assertEquals(0,euclid.getMaxCommonDivisor(Integer.MIN_VALUE,1));
    }

    /*Method getPositiveRepr*/
    /*ok result expected*/
    @Test
    public void getPositiveRepr() throws Exception {
        Method method=Euclid.class.getDeclaredMethod("getPositiveRepr", int.class);
        method.setAccessible(true);

        assertEquals(10,method.invoke(euclid,-10));
        assertEquals(10,method.invoke(euclid,10));
        assertEquals(258410,method.invoke(euclid,-258410));
        assertEquals(258410,method.invoke(euclid,258410));
    }

    /*exception expected*/
    /*main exception is InvocationTargetException*/
    @Test
    public void getPositiveReprExeption() throws Exception{
        try {
           Method method = Euclid.class.getDeclaredMethod("getPositiveRepr", int.class);
           method.setAccessible(true);
           method.invoke(euclid,Integer.MIN_VALUE);
        }
        catch (InvocationTargetException e){
            Throwable cause=e.getCause();
            assertEquals(VAL_OUT_OF_RANGE,cause.getMessage());
        }

    }
}