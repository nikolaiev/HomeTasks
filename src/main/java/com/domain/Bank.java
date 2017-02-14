package com.domain;

import java.io.Serializable;
import java.util.List;

/**
 * Created by vlad on 07.02.17.
 */
public class Bank implements Serializable{
    String title;
    List<SimpleCredit> simpleCreditList;
    List<CreditLine> creditLineList;

    public Bank() {
    }

    public Bank(String title, List<SimpleCredit> simpleCreditList, List<CreditLine> creditLineList) {

        this.title = title;
        this.simpleCreditList = simpleCreditList;
        this.creditLineList = creditLineList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<SimpleCredit> getSimpleCreditList() {
        return simpleCreditList;
    }

    public void setSimpleCreditList(List<SimpleCredit> simpleCreditList) {
        this.simpleCreditList = simpleCreditList;
    }

    public List<CreditLine> getCreditLineList() {
        return creditLineList;
    }

    public void setCreditLineList(List<CreditLine> creditLineList) {
        this.creditLineList = creditLineList;
    }
}
