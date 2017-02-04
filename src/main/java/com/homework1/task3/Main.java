package com.homework1.task3;

import com.homework1.task1.BitLengthGetter;

import static java.lang.Math.log10;

/**
 * Created by vlad on 03.02.17.
 *
 * Class design to provide Karatsuba fast numbers multiplying functions
 */
class Karatsuba{
    private final byte BASE=10; //numeric system base

    /*exception messages*/
    private final String RESULT_OUT_OF_RANGE="MULTIPLICATION RESULT IS OUT OF RANGE";
    private final String VAL_OUT_OF_RANGE="VALUE OUT OF RANGE";

    /**
     * Multiplying 2 integer numbers
     * @param num1  multiplier
     * @param num2  multiplier
     * @return  multiplication result
     * @throws OutOfRangeExeption
     */
    public long multiply(long num1,long num2) throws OutOfRangeExeption{
        int halfLength= BitLengthGetter.getLongLength()/2;

        /*flag if multiplication result is negative*/
        boolean isResultNegative=false;

        /*check value sign*/
        if(num1<0){
            if(num1!=Long.MIN_VALUE){
                num1=-num1;
                isResultNegative=true;
            }
            else{
                throw new OutOfRangeExeption(VAL_OUT_OF_RANGE);
            }
        }

        /*check value sign*/
        if(num2<0){
            if(num2!=Long.MIN_VALUE){
                num2=-num2;
                isResultNegative=!isResultNegative;
            }
            else
                throw new OutOfRangeExeption(VAL_OUT_OF_RANGE);
        }

        /*one more check*/
        int num1Length=(int)Math.ceil(log10(num1));     //number1 length
        int num2Length=(int)Math.ceil(log10(num2));     //number2 length

        /*check if result will overflow Long max value*/
        if(num1Length + num2Length >= Math.ceil(log10(Long.MAX_VALUE))){
            throw new OutOfRangeExeption(RESULT_OUT_OF_RANGE);
        }

        /*get numbers parts*/
        long a0=num1<<halfLength>>halfLength;
        long b0=num2<<halfLength>>halfLength;

        long a1=num1>>halfLength<<halfLength;
        long b1=num2>>halfLength<<halfLength;

        /*karatsuba formula*/
        long result=a0 * b0 + (( a0 + a1 ) * ( b0 + b1 ) - a0 * b0 - a1 * b1 ) *
                (long)Math.pow(BASE,halfLength) + a1 * b1 * (long)Math.pow(BASE,halfLength*2);

        return isResultNegative?-result:result;
    }

}
public class Main {
    public static void main(String[] args) throws Exception{
        Karatsuba karatsuba=new Karatsuba();
        long result=karatsuba.multiply(-1,6);
        System.out.println(result);
    }
}
