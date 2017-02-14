package com.factory;

import com.domain.Credit;
import com.domain.CreditLine;

/**
 * Created by vlad on 14.02.17.
 */
public class CreditLineFactory extends AbstractCreditFactory {
    static CreditLineFactory instance =new CreditLineFactory();

    private CreditLineFactory(){}

    public static CreditLineFactory getInstance(){
        return instance;
    }
    public Credit getCredit() {
        return new CreditLine();
    }
}
