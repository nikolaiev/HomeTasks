package com.homework1.task4;

import com.homework1.task3.OutOfRangeExeption;

/**
 * Created by vlad on 03.02.17.
 *
 * Class designed to provide Euclid's
 * "max common divisor" algorithms for 2 integer numbers
 */
public class Euclid {
    private static final String VAL_OUT_OF_RANGE="VALUE OUT OF RANGE"; //exception message
    /**
     * Getting max common divisor method
     * @param num1  integer number
     * @param num2  integer number
     * @return      max common divisor
     * @throws OutOfRangeExeption
     */
    public int getMaxCommonDivisor(int num1,int num2) throws OutOfRangeExeption{
        /*get absolute values if possible*/
        num1=getPositiveRepr(num1);
        num2=getPositiveRepr(num2);

        return findComDiv(num1,num2);
    }

    /**
     * Base method of Euclid algorithm
     * @param a integer number
     * @param b integer number
     * @return  max common divisor
     */
    private int findComDiv(int a, int b) {
        if(a==0)
            return b;
        else if(b==0 || a==b)
            return a;
        else if(a==1 || b==1)
            return 1;
        /*check odd*/
        else if ((a&1 | b&1)== 0)
            return findComDiv(a >>1, b >>1)<<1;
        /*check a is even and b is odd*/
        else if ((a&1)==0 && (b&1)==1)
            return findComDiv(a >>1, b);

        else if ((b&1)==0 && (a&1)==1)
            return findComDiv(a, b >>1);

        else if (a < b)
            return findComDiv((b - a) >>1, a);
        else
            return findComDiv((a - b) >>1, b);
    }

    /**
     * Returns absolute number value if possible,
     * if not - throws OutOfRangeExeption
     * @param num   integer number
     * @return      absolute number value
     * @throws OutOfRangeExeption
     */
    private int getPositiveRepr(int num) throws OutOfRangeExeption{
        if(num<0){
            if(num!=Integer.MIN_VALUE)
                return -num;
            else
                throw new OutOfRangeExeption(VAL_OUT_OF_RANGE);
        }
        return num;
    }
}
