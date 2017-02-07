package com.homework1.task4;

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
     * @throws IllegalArgumentException thrown if on or more number == Integer.MIN_VALUE
     */
    public int getMaxCommonDivisor(int num1,int num2) throws IllegalArgumentException  {
        /*get absolute values if possible*/
        num1=getPositiveRepr(num1);
        num2=getPositiveRepr(num2);

        return findComDiv(num1,num2);
    }

    /**
     * Base method of Euclid algorithm
     * @param num1 integer number
     * @param num2 integer number
     * @return  max common divisor
     */
    private int findComDiv(int num1, int num2) {
        if(num1==0)
            return num2;
        if(num2==0 || num1==num2)
            return num1;
        if(num1==1 || num2==1)
            return 1;
        /*check odd*/
        if ((num1&1 | num2&1)== 0)
            return findComDiv(num1 >>1, num2 >>1)<<1;
        /*check a is even and b is odd*/
        if ((num1&1)==0 && (num2&1)==1)
            return findComDiv(num1 >>1, num2);

        if ((num2&1)==0 && (num1&1)==1)
            return findComDiv(num1, num2 >>1);

        if (num1 < num2)
            return findComDiv((num2 - num1) >>1, num1);

        return findComDiv((num1 - num2) >>1, num2);
    }

    /**
     * Returns absolute number value if possible,
     * if not - throws OutOfRangeExeption
     * @param num   integer number
     * @return      absolute number value
     * @throws IllegalArgumentException thrown if on or more number == Integer.MIN_VALUE
     */
    private int getPositiveRepr(int num) throws IllegalArgumentException{
        if(num<0){
            if(num!=Integer.MIN_VALUE)
                return -num;
            else
                throw new IllegalArgumentException(VAL_OUT_OF_RANGE);
        }
        return num;
    }
}
