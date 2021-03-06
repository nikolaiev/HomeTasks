package com.homework1.task2;

import com.homework1.task1.BitLengthGetter;

/**
 * Created by vlad on 03.02.17.
 *
 * Class designed to set special bits (by position)
 * in integer primitive types
 */
public class BitChanger{
    private final static String UNAVAILABLE_BIT_POS="UNAVAILABLE BIT POSITION";

    /**
     * Set special bit to one
     * @param num input number
     * @param pos bit position (starts from 0)
     * @return updated number
     * */
    public int changeBitToOne(int num,int pos) throws IllegalArgumentException {
        int mask=getMask(pos);  //bitwise mask
        return num^mask;        //update number
    }

    /**
     * Set special bit to zero
     * @param num input number
     * @param pos bit position (starts from 0)
     * @return updated number
     */
    public int changeBitToZero(int num, int pos) throws IllegalArgumentException {
        int mask=getMask(pos);  //bitwise mask
        mask=~mask;             //11110...1111
        return num&mask;        //update number
    }

    /**
     * Creates bitwise mask
     * @param pos position of 1 in mask
     * @return mask in integer representation
     * @throws Exception if we cannot create mask for concrete position
     */
    private int getMask(int pos) throws IllegalArgumentException {
        if(pos<0 || pos> BitLengthGetter.getIntLength()-1){
            throw new IllegalArgumentException(UNAVAILABLE_BIT_POS);
        }
        int mask=1;//0000..01

        while(pos>0){
            mask<<=1;       //shifting 1
            --pos;
        }
        return mask;
    }
}
