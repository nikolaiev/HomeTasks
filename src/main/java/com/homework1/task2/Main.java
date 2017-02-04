package com.homework1.task2;

/**
 * Created by vlad on 03.02.17.
 *
 * Class designed to set special bits (by position)
 * in integer primitive types
 */
class BitChanger{
    /**
     * Set special bit to one
     * @param num input number
     * @param pos bit position (starts from 0)
     * @return updated number
     * */
    public int changeBitToOne(int num,int pos){
        int mask=getMask(pos);  //bitwise mask
        return num^mask;        //update number
    }

    /**
     * Set special bit to zero
     * @param num input number
     * @param pos bit position (starts from 0)
     * @return updated number
     */
    public int changeBitToZero(int num, int pos){
        int mask=getMask(pos);  //bitwise mask
        mask=~mask;             //11110...1111
        return num&mask;        //update number
    }

    /**
     * Creates bitwise mask
     * @param pos position of 1 in mask
     * @return mask in integer representation
     */
    private int getMask(int pos){
        int mask=1;//0000..01

        while(pos>0){
            mask<<=1;       //shifting 1
            --pos;
        }
        return mask;
    }

}
public class Main {
    public static void main(String[] args) {
        BitChanger bitChanger=new BitChanger();
        System.out.println(bitChanger.changeBitToOne(0,0));
        System.out.println(bitChanger.changeBitToZero(-1,31));
    }
}
