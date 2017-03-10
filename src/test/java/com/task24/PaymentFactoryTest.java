package com.task24;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Vlad on 08.03.2017.
 */
public class PaymentFactoryTest {
    @Test
    public void getInstance() throws Exception {
        assertEquals(PaymentFactory.getInstance(),PaymentFactory.getInstance());
    }

    @Test
    public void getPayment() throws Exception {
        Payment payment=PaymentFactory.getInstance()
                .getPayment("test",100,Currency.EUR,PaymentType.INTRABANK);

        assertNotNull(payment);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getPaymentTitleExc() throws Exception {
        Payment payment=PaymentFactory.getInstance()
                .getPayment(null,100,Currency.EUR,PaymentType.INTRABANK);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getPaymentSumException() throws Exception {
        Payment payment=PaymentFactory.getInstance()
                .getPayment("test",1,Currency.EUR,PaymentType.INTRABANK);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getPaymentCurrencyException() throws Exception {
        Payment payment=PaymentFactory.getInstance()
                .getPayment("test",100,null,PaymentType.INTRABANK);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getPaymentPaymentTypeException() throws Exception {
        Payment payment=PaymentFactory.getInstance()
                .getPayment("test",100,Currency.EUR,null);
    }
}