package com.task24;

/**
 * Created by Vlad on 08.03.2017.
 */
public class PaymentFactory {
    private static PaymentFactory instance =new PaymentFactory();
    public static PaymentFactory getInstance(){return instance;}

    /**
     * Empty constructor
     */
    private PaymentFactory(){}

    public Payment getPayment(String title,double sum,Currency currency,PaymentType type){
        if(title==null){
            throw new IllegalArgumentException("Payment title can't be null!");
        }
        if(sum<10){
            throw new IllegalArgumentException("Payment size can't be less that 10.0!");
        }
        if(currency==null){
            throw new IllegalArgumentException("Payment currency can't be null!");
        }
        if(type==null){
            throw new IllegalArgumentException("Payment type can't be null!");
        }

        /*all args are ok*/
        return new Payment(title, sum, currency, type);
    }
}
