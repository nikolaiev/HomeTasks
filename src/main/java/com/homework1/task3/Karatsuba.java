package com.homework1.task3;

import com.homework1.task1.BitLengthGetter;

import java.math.BigInteger;

import static java.lang.Math.log10;

/**
 * Created by vlad on 03.02.17.
 *
 * Class design to provide Karatsuba fast numbers multiplying functions
 */
public class Karatsuba{
    //private final String VAL_OUT_OF_RANGE="VALUE OUT OF RANGE";
    //private static final byte BASE=2; //numeric system base

    /**
     * Multiplying 2 long numbers
     * @param num1  multiplier
     * @param num2  multiplier
     * @return  multiplication result
     */
    public BigInteger multiply(long num1,long num2){
        return multiply(BigInteger.valueOf(num1),BigInteger.valueOf(num2));
    }

    /**
     * Multiplying 2 bigInteger numbers
     * @param num1
     * @param num2
     * @return multiplication result
     */
    public BigInteger multiply(BigInteger num1, BigInteger num2) {
        int halfLength= Math.max(num1.bitLength(),num2.bitLength())/2;

        /*flag if multiplication result is negative*/
        boolean isResultNegative=false;

        /*check value sign*/
        if(num1.signum()==-1){
            num1=BigInteger.ZERO.subtract(num1);
            isResultNegative=true;
        }

        /*check value sign*/
        if(num2.signum()==-1){
            num2=BigInteger.ZERO.subtract(num2);
            isResultNegative=!isResultNegative;
        }

        /*get numbers parts*/
        BigInteger a0=num1.xor(num1.shiftRight(halfLength).shiftLeft(halfLength));
        BigInteger b0=num2.xor(num2.shiftRight(halfLength).shiftLeft(halfLength));

        BigInteger a1=num1.shiftRight(halfLength);
        BigInteger b1=num2.shiftRight(halfLength);

        /*karatsuba formula*/
        BigInteger result =
                a0.multiply(b0).add(
                        (
                            (a0.add(a1)).multiply(b0.add(b1))
                            .subtract(a0.multiply(b0)).subtract(a1.multiply(b1))
                        )
                        .shiftLeft(halfLength)
                        /*.multiply(
                                BigInteger.valueOf((long)Math.pow(BASE,halfLength))
                        )*/
                ).add(
                        a1.multiply(b1).shiftLeft(halfLength*2)//.multiply(BigInteger.valueOf((long)Math.pow(BASE,halfLength*2.)))
                );

        return isResultNegative?
                /*-result*/
                BigInteger.ZERO.subtract(result):
                result;
    }
}
