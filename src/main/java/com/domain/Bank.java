package com;

import java.util.List;

/**
 * Created by vlad on 07.02.17.
 */
public class Bank {
    String title;
    List<Credit> creditList;
    List<CreditLine> creditLineList;

    public Bank(String title, List<Credit> creditList, List<CreditLine> creditLineList) {
        this.title = title;
        this.creditList = creditList;
        this.creditLineList = creditLineList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Credit> getCreditList() {
        return creditList;
    }

    public void setCreditList(List<Credit> creditList) {
        this.creditList = creditList;
    }

    public List<CreditLine> getCreditLineList() {
        return creditLineList;
    }

    public void setCreditLineList(List<CreditLine> creditLineList) {
        this.creditLineList = creditLineList;
    }
}
