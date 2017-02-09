package com.homework1.task3;

import com.homework1.task1.BitLengthGetter;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.math.BigInteger;

import static org.junit.Assert.*;

/**
 * Created by vlad on 04.02.17.
 */
public class KaratsubaTest {
    Karatsuba karatsuba;

    @Rule
    public ExpectedException thrown= ExpectedException.none();

    @Before
    public void init(){
        karatsuba=new Karatsuba();
    }

    /*normal cases*/
    /*long params*/
    @Test
    public void multiply() {
        assertEquals(BigInteger.valueOf(-10), karatsuba.multiply(-2, 5));
        assertEquals(BigInteger.valueOf(17179869184L * 78), karatsuba.multiply(17179869184L, 78));
        assertEquals(BigInteger.valueOf(354 * 78), karatsuba.multiply(78, 354));
        assertEquals(BigInteger.valueOf(-354 * 78), karatsuba.multiply(78, -354));
    }

    @Test(expected = NullPointerException.class)
    public void testNull(){
        assertEquals(0,karatsuba.multiply(null,null));
    }

    @Test
    public void multiplyExeption() {
        assertEquals(BigInteger.valueOf(500000000000000L).multiply(BigInteger.valueOf(100000000000000000L)),
                karatsuba.multiply(500000000000000L,100000000000000000L));
    }

    @Test
    public void multiplyExeptionNegative() {
        assertEquals(BigInteger.valueOf(-500000000000000L).multiply(BigInteger.valueOf(100000000000000000L)),
                karatsuba.multiply(-500000000000000L,100000000000000000L));

    }

    @Test
    public void multiplyBigParam() {
        assertEquals(new BigInteger("-18446744073709551614"),karatsuba.multiply(Long.MIN_VALUE+1,2));
    }

    /*BigIntegers params*/
    @Test
    public void multyBigIntegers(){
        assertEquals(new BigInteger("128734512374891283476128734")
                        .multiply(new BigInteger("328746129834632846189234192834")),
                karatsuba.multiply(new BigInteger("128734512374891283476128734"),
                        new BigInteger("328746129834632846189234192834")));
    }

    @Test
    public void multyBigIntegersNegativeBoth(){
        assertEquals(new BigInteger("128734512374891283476128734")
                        .multiply(new BigInteger("328746129834632846189234192834")),
                karatsuba.multiply(new BigInteger("-128734512374891283476128734"),
                        new BigInteger("-328746129834632846189234192834")));
    }

    @Test
    public void multyBigIntegersNegative(){
        assertEquals(new BigInteger("-128734512374891283476128734")
                        .multiply(new BigInteger("328746129834632846189234192834")),
                karatsuba.multiply(new BigInteger("-128734512374891283476128734"),
                        new BigInteger("328746129834632846189234192834")));
    }
}