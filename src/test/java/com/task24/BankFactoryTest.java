package com.task24;

import com.task24.handlers.ControllingHandler;
import com.task24.handlers.FixationHandler;
import com.task24.handlers.WithdrawingHandler;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Vlad on 08.03.2017.
 */
public class BankFactoryTest {

    @Test
    public void getInstance() throws Exception {
        assertEquals(BankFactory.getInstance(),BankFactory.getInstance());
    }

    @Test
    public void getBank() throws Exception {
        assertNotNull(BankFactory.getInstance().getBank());
    }

    @Test(expected = IllegalArgumentException.class)
    public void getBankExceptionContrHandl() throws Exception {
        BankFactory.getInstance().getBank(null,new WithdrawingHandler(),new FixationHandler());
    }

    @Test(expected = IllegalArgumentException.class)
    public void getBankExceptionWithdrHandl() throws Exception {
        BankFactory.getInstance().getBank(new ControllingHandler(),null,new FixationHandler());
    }

    @Test(expected = IllegalArgumentException.class)
    public void getBankExceptionFixationHandl() throws Exception {
        BankFactory.getInstance().getBank(new ControllingHandler(),new WithdrawingHandler(),null);
    }

}