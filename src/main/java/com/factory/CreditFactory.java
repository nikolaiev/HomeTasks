package com.factory;

/**
 * Created by vlad on 14.02.17.
 */
public class CreditFactory {
    public static AbstractCreditFactory getInstance(CreditType creditType){
        switch (creditType){
            case CREDIT: return SimpleCreditFactory.getInstance();
            case CREDIT_LINE:return CreditLineFactory.getInstance();
        }
        return null;
    }
}
