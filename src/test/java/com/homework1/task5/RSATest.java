package com.homework1.task5;

import com.homework1.task4.Euclid;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by vlad on 04.02.17.
 */
public class RSATest {
    RSA rsa;
    String input="i remembe123123123123123r that september" +
            "Hello World! RSA encryption!!!skdjfklasjdf";

    final String MESSAGE="FUNCTION INVOCATION IS NOT AVAILABLE. OBJECT ARE NOT FULLY FUNCTIONAL";

    @Before
    public void init(){
        rsa=new RSA();
    }

    @Rule
    public ExpectedException thrown= ExpectedException.none();

    /*Methods encrypt decrypt test*/
    @Test
    public void encryptDecrypt() throws Exception {
        String test=rsa.encrypt(input);
        assertEquals("texts must be equals",input,rsa.decrypt(test));
    }

    /*only decrypt method test*/
    @Test
    public void decrypt() throws Exception {

        /*create encrypt only RSA object*/
        RSA rsaConfigured=new RSA(rsa.getOpenExponent(),rsa.getModule());

        String test=rsaConfigured.encrypt(input);
        /*decrypt with another RSA object*/
        assertEquals(input,rsa.decrypt(test));
    }

    /*decrypt error test*/
    /*should be exception, as object was not fully-functional*/
    @Test
    public void  decryptError() throws UnsupportedOperationException {

        /*create encrypt only RSA object*/
        RSA rsaConfigured=new RSA(rsa.getOpenExponent(),rsa.getModule());

        /*waiting for exception*/
        thrown.expect(UnsupportedOperationException.class);
        thrown.expectMessage(MESSAGE);
        rsaConfigured.decrypt(input);
    }

    @Test
    public void rsaSuperPuperTest(){
        String test;
        for(int i=0;i<10;i++){
            test=new BigInteger(1<<i,new Random()).toString();
            assertEquals(test,rsa.decrypt(rsa.encrypt(test)));
        }
    }

    /*getSimpleKeyPair method test*/

    @Test
    public void getSimpleKeyPair() throws Exception {
        Method getSimpleKeyPair = RSA.class.getDeclaredMethod("getSimpleKeyPair",int.class);
        getSimpleKeyPair.setAccessible(true);
        BigInteger keys[]= (BigInteger[]) getSimpleKeyPair.invoke(rsa,1024);
        assert(keys[0].gcd(keys[1]).equals(BigInteger.ONE));
    }

    @Test
    public void setExponents() throws Exception {
        Method setExponents = RSA.class.getDeclaredMethod("setExponents",
                int.class);
        /*Method setExponents = RSA.class.getDeclaredMethod("setExponents",
                BigInteger[].class);*/
        setExponents.setAccessible(true);

        BigInteger[] testKeys=new BigInteger[]{BigInteger.valueOf(7),BigInteger.valueOf(3)};
        Object invoke = setExponents.invoke(rsa, new Object[]{testKeys});
        assertEquals(BigInteger.valueOf(21),rsa.getModule());
        assertEquals(BigInteger.valueOf(5),rsa.getOpenExponent());

    }

}