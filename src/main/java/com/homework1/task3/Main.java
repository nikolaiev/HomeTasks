package com.homework1.task3;

public class Main {
    private Main(){}
    public static void main(String[] args) throws Exception{
        Karatsuba karatsuba=new Karatsuba();
        long result=karatsuba.multiply(-1,6);
        System.out.println(result);
    }
}
