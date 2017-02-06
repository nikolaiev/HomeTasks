package com.homework1.task3;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

/**
 * Created by vlad on 04.02.17.
 */
public class KaratsubaTest {
    Karatsuba karatsuba;

    /*exception messages*/
    private final String RESULT_OUT_OF_RANGE="MULTIPLICATION RESULT IS OUT OF RANGE";
    private final String VAL_OUT_OF_RANGE="VALUE OUT OF RANGE";

    @Rule
    public ExpectedException thrown= ExpectedException.none();

    @Before
    public void init(){
        karatsuba=new Karatsuba();
    }

    @Test
    public void multiply() throws OutOfRangeExeption {
        /*middle cases*/
        assertEquals(-10, karatsuba.multiply(-2, 5));
        assertEquals(354 * 78, karatsuba.multiply(354, 78));
        assertEquals(354 * 78, karatsuba.multiply(78, 354));
        assertEquals(-354 * 78, karatsuba.multiply(78, -354));
    }

    /*critical cases*/
    /*exception expected*/
    @Test
    public void multiplyExeptionParamExeption() throws OutOfRangeExeption {
        thrown.expect(OutOfRangeExeption.class);
        thrown.expectMessage(VAL_OUT_OF_RANGE);
        assertEquals(Long.MIN_VALUE,karatsuba.multiply(Long.MIN_VALUE,1));
    }


    /*exception expected*/
    @Test
    public void multiplyExeption() throws OutOfRangeExeption {
        thrown.expect(OutOfRangeExeption.class);
        thrown.expectMessage(RESULT_OUT_OF_RANGE);
        assertEquals(0,karatsuba.multiply(500000000000000L,100000000000000000L));
    }

    /*exception expected*/
    @Test
    public void multiplyExeptionNegative() throws OutOfRangeExeption{
        thrown.expect(OutOfRangeExeption.class);
        thrown.expectMessage(RESULT_OUT_OF_RANGE);
        assertEquals(0,karatsuba.multiply(-50000000000000L,50000000000000L));

    }

}