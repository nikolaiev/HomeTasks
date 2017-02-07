package com.homework1.task5;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * Created by vlad on 03.02.17.
 *
 * Class designed to provide base RSA implementation
 */
public class RSA {
    private BigInteger module;          //module value
    private BigInteger openExponent;    //open exponent value
    private BigInteger closedExponent;  //closed (secret) exponent value

    /**
     * Build fully functional object with default values
     */
    public RSA(){
        this(1024);
    }

    /**
     *Constructor to build object, that allowed only to
     * decrypt text
     * @param openExponent  open exponent (public key part)
     * @param module        module value (public key part)
     */
    public RSA(BigInteger openExponent,BigInteger module){
        this.openExponent=openExponent;
        this.module=module;
    }

    /**
     * Constructor to create fully functional object
     * @param bitlen    secret primes numbers bit letgth
     */
    public RSA(int bitlen){
        SecureRandom secureRandom=new SecureRandom();

        /*secret prime numbers*/
        BigInteger primeNum1=new BigInteger(bitlen,100,secureRandom);
        BigInteger primeNum2=new BigInteger(bitlen,100,secureRandom);

        module=primeNum1.multiply(primeNum2);

        /*Euler function value*/
        BigInteger eulerVal=(primeNum1.subtract(BigInteger.ONE))
                .multiply(primeNum2.subtract(BigInteger.ONE));

        openExponent=BigInteger.valueOf(3);

        while (eulerVal.gcd(openExponent).intValue() > 1) {
            openExponent = openExponent.add(new BigInteger("2"));
        }

        closedExponent =openExponent.modInverse(eulerVal);
    }

    public BigInteger getModule() {
        return module;
    }

    public BigInteger getOpenExponent() {
        return openExponent;
    }

    /**
     * Encryption function
     * @param message   input text
     * @return          encrypted text
     */
    public String encrypt(String message) {
        return (new BigInteger(message.getBytes())).modPow(openExponent,module ).toString();
    }

    /**
     * Decryption function
     * @param message   input (encrypted) text
     * @return          encrypted text
     * @throws UnavailableFunctionalityException if object was not fully build
     */
    public String decrypt(String message) throws UnavailableFunctionalityException {
        if(closedExponent==null){
            throw new UnavailableFunctionalityException();
        }
        return new String((new BigInteger(message)).modPow(closedExponent, module).toByteArray());
    }
}
