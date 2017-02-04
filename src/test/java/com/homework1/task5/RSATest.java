package com.homework1.task5;

import com.homework1.task4.Euclid;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.math.BigInteger;

import static org.junit.Assert.*;

/**
 * Created by vlad on 04.02.17.
 */
public class RSATest {
    RSA rsa;
    String input="i remember that september" +
            "Hello World! RSA encryption!!!";
    final String MESSAGE="FUNCTION INVOKATION IS NOT AVAILABLE";
    @Before
    public void init(){
        rsa=new RSA();
    }

    @Rule
    public ExpectedException thrown= ExpectedException.none();

    @Test
    public void encryptDecrypt() throws Exception {
        String test=rsa.encrypt(input);
        assertEquals(input,rsa.decrypt(test));
    }

    @Test
    public void decrypt() throws Exception {

        /*create encrypt only RSA object*/
        RSA rsaConfigured=new RSA(rsa.getOpenExponent(),rsa.getModule());

        String test=rsaConfigured.encrypt(input);
        /*decrypt with another RSA object*/
        assertEquals(input,rsa.decrypt(test));
    }

    @Test
    public void  decryptError() throws UnavailableFunctionalityException {

        /*create encrypt only RSA object*/
        RSA rsaConfigured=new RSA(rsa.getOpenExponent(),rsa.getModule());

        /*waiting for exeption*/
        thrown.expect(UnavailableFunctionalityException.class);
        thrown.expectMessage(MESSAGE);
        String test=rsaConfigured.decrypt(input);
    }

}