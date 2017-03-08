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

    }

}