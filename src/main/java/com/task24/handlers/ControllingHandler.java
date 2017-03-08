package com.task24.handlers;

import com.task24.Payment;
import com.task24.PaymentType;

/**
 * Created by Vlad on 08.03.2017.
 */
public class ControllingHandler extends Handler {
    private final int MAX_PREF_PAYMENT_SUM=1000;
    public ControllingHandler(){}

    /**
     * Default constructor
     *
     * @param handler next handler
     */
    public ControllingHandler(Handler handler) {
        super(handler);
    }

    @Override
    public void execute(Payment payment) {
        /*payment type*/
        PaymentType type=payment.getType();

        /*checking payment sum*/
        if(type==PaymentType.PREFERENTIAL && payment.getSum()>MAX_PREF_PAYMENT_SUM){
            System.out.println("Payment sum must not be greater than "+MAX_PREF_PAYMENT_SUM);
            return;
        }
        //handle payment further
        if(handler!=null)
            handler.execute(payment);
    }
}
