package com.factory;

import com.domain.Credit;
import com.domain.SimpleCredit;

public class SimpleCreditFactory extends AbstractCreditFactory{
    static SimpleCreditFactory instance=new SimpleCreditFactory();

    private SimpleCreditFactory(){};

    public static SimpleCreditFactory getInstance() {
        return instance;
    }


    public Credit getCredit() {
        return new SimpleCredit();
    }
}
