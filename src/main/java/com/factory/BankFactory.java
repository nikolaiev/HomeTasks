package com.factory;

import com.domain.Bank;

/**
 * Created by vlad on 14.02.17.
 */
public class BankFactory {
    static BankFactory instance =new BankFactory();
    private BankFactory(){}

    public static BankFactory getInstance(){
        return instance;
    }

    public Bank getBank(){
        return new Bank();
    }

}
