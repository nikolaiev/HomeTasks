package com.task24;

import com.task24.handlers.ControllingHandler;
import com.task24.handlers.FixationHandler;
import com.task24.handlers.Handler;
import com.task24.handlers.WithdrawingHandler;

/**
 * Created by Vlad on 08.03.2017.
 */
public class Bank {
    /*root bank handler*/
    private Handler handler;

    public Bank(Handler controllingHandler){
       this.handler=controllingHandler;
    }

    public void makePayment(Payment payment){
        handler.execute(payment);
    }
}
