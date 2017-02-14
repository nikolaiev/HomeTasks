package com.service;

import com.domain.Bank;
import com.domain.Credit;
import com.domain.Debitor;
import com.factory.AbstractCreditFactory;
import com.factory.BankFactory;
import com.factory.CreditFactory;
import com.factory.CreditType;

import java.io.*;
import java.util.List;

/**
 * Created by vlad on 14.02.17.
 */
public class Manager {
    CreditsFilter creditsFilter;

    public Manager(CreditsFilter creditsFilter) {
        this.creditsFilter = creditsFilter;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        /*AbstractCreditFactory creditFactory=CreditFactory.getInstance(CreditType.CREDIT);
        AbstractCreditFactory creditlineFactory=CreditFactory.getInstance(CreditType.CREDIT_LINE);
        BankFactory bankFactory=BankFactory.getInstance();

        Bank bank=bankFactory.getBank();
        Credit creditSimple=creditFactory.getCredit();
        Credit creditLine=creditlineFactory.getCredit();
        bank.setTitle("testBankTitle");

        ObjectOutputStream objectOutputStream=new ObjectOutputStream(new FileOutputStream("test.txt"));
        objectOutputStream.writeObject(bank);*/

        ObjectInputStream objectInputStream=new ObjectInputStream(new FileInputStream("test.txt"));

        Bank bank=(Bank) objectInputStream.readObject();
        System.out.println(bank.getTitle());
    }
}
