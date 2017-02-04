package com.homework1.task5;

/**
 * Created by vlad on 03.02.17.
 */
public class Main {
    private Main(){}

    public static void main(String[] args) throws UnavailableFunctionalityException {
        RSA rsa=new RSA(8);
        String test=rsa.encrypt("A");
        System.out.println(test);
        System.out.println(rsa.decrypt(test));
    }
}
