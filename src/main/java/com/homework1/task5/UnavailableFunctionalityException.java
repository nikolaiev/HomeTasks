package com.homework1.task5;

/**
 * Created by vlad on 04.02.17.
 */
public class UnavailableFunctionalityException extends Exception {
    final static String MESSAGE="FUNCTION INVOCATION IS NOT AVAILABLE";

    public UnavailableFunctionalityException(){
        super(MESSAGE);
    }
}
