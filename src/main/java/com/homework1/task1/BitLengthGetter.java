package com.homework1.task1;

/**
 * Created by vlad on 03.02.17.
 *
 * Class designed to get bit-length of integer primitive types
 */
public class BitLengthGetter {

    private BitLengthGetter(){}

    /**
     * @return bit length of int type
     * */
    public static byte getIntLength(){
        byte result=1;
        int testVal=1;      //value used in bit shifting
        do{
            testVal<<=1;
            ++result;
        }while(testVal>0);  //until testVal become negative
        return result;
    }

    /**
     * @return bit length of byte type
     * */
    public static byte getByteLength(){
        byte result=1;
        byte testVal=1;     //value used in bit shifting

        do{
            testVal<<=1;
            ++result;
        }while(testVal>0);  //until testVal become negative

        return result;
    }

    /**
     * @return bit length of long type
     * */
    public static byte getLongLength(){
        byte result=1;
        long testVal=1;     //value used in bit shifting

        do{
            testVal<<=1;
            ++result;
        }while(testVal>0);  //until testVal become negative

        return result;
    }

    /**
     * @return bit length of short type
     * */
    public static byte getShortLength(){
        byte result=1;
        short testVal=1;    //value used in bit shifting
        do{
            testVal<<=1;
            ++result;
        }while(testVal>0);  //until testVal become negative

        return result;
    }
}
