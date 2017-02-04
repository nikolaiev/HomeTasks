package com.homework1.task2;

public class Main {
    private Main(){}

    public static void main(String[] args) {
        BitChanger bitChanger=new BitChanger();
        System.err.println(bitChanger.changeBitToOne(0,0));
        System.err.println(bitChanger.changeBitToZero(-1,31));
    }
}
