package com.task24.handlers;

import com.task24.Payment;
import com.task24.PaymentType;

/**
 * Created by Vlad on 08.03.2017.
 */
public class WithdrawingHandler extends Handler{
    /*commissions in percents*/
    private final int STANDARD_PAYMENT_COMMISSION=2;
    private final int STATE_PAYMENT_COMMISSION=1;

    public WithdrawingHandler(){}

    /**
     * Default constructor
     *
     * @param handler next handler
     */
    public WithdrawingHandler(Handler handler) {
        super(handler);
    }

    @Override
    public void execute(Payment payment) {
        /*payment type*/
        PaymentType type=payment.getType();

        /*getting withdraw*/
        if(type== PaymentType.STANDARD){
            payment.setSum(payment.getSum()*(100-STANDARD_PAYMENT_COMMISSION)/100);
        }

        /*getting withdraw*/
        if(type==PaymentType.STATE){
            payment.setSum(payment.getSum()*(100-STATE_PAYMENT_COMMISSION)/100);
        }

        if(handler!=null)
            handler.execute(payment);
    }
}
