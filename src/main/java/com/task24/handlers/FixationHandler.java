package com.task24.handlers;

import com.task24.Payment;
import com.task24.PaymentType;

/**
 * Created by Vlad on 08.03.2017.
 */
public class FixationHandler extends Handler {

    public FixationHandler(){}

    /**
     * Default constructor
     *
     * @param handler next handler
     */
    public FixationHandler(Handler handler) {
        super(handler);
    }

    @Override
    public void execute(Payment payment) {
        System.out.println("Payment "+payment.getTitle() +
                " "+payment.getType()+ " in "+payment.getCurrency() +
                " was successfully proceed with "+payment.getSum() + " sum result!"
        );

        if(handler!=null)
            handler.execute(payment);
    }
}
