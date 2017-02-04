package com.homework1.task3;

import com.homework1.task1.BitLengthGetter;

import static java.lang.Math.log10;

public class Main {
    private Main(){}
    public static void main(String[] args) throws Exception{
        Karatsuba karatsuba=new Karatsuba();
        long result=karatsuba.multiply(-1,6);
        System.out.println(result);
    }
}
