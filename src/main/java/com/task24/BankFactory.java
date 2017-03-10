package com.task24;

import com.task24.handlers.ControllingHandler;
import com.task24.handlers.FixationHandler;
import com.task24.handlers.Handler;
import com.task24.handlers.WithdrawingHandler;
import com.task26.BacteriumFactory;

/**
 * Created by Vlad on 08.03.2017.
 */
public class BankFactory {
    public static BankFactory instance=new BankFactory();
    public static BankFactory getInstance(){return instance;}

    private BankFactory(){}

    /**
     * Return new Bank
     * @param controllingHandler
     * @param withdrawingHandler
     * @param fixationHandler
     * @return
     */
    public Bank getBank(Handler controllingHandler,
                   Handler withdrawingHandler, Handler fixationHandler){

        if(controllingHandler==null)
            throw new IllegalArgumentException();

        if(withdrawingHandler==null)
            throw new IllegalArgumentException();

        if(fixationHandler==null)
            throw new IllegalArgumentException();

        controllingHandler.setHandler(withdrawingHandler);
        withdrawingHandler.setHandler(fixationHandler);

        return new Bank(controllingHandler);
    }

    /**
     * Return new Bank
     * @return
     */
    public Bank getBank(){
        ControllingHandler controllingHandler=new ControllingHandler();
        WithdrawingHandler withdrawingHandler=new WithdrawingHandler();
        FixationHandler fixationHandler=new FixationHandler();

        return getBank(controllingHandler,withdrawingHandler,fixationHandler);
    }
}
