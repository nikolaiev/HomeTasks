package com.task24;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by Vlad on 08.03.2017.
 */
public class BankTest {
    Bank bank;
    @Before
    public void init(){
        bank=BankFactory.getInstance().getBank();
    }
    @Test
    public void makePayment() throws Exception {
        Payment payment=PaymentFactory.getInstance()
                .getPayment("test payment",100,
                        Currency.EUR,PaymentType.STANDARD);
        bank.makePayment(payment);
    }

}