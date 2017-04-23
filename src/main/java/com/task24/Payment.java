package com.task24;

/**
 * Created by Vlad on 08.03.2017.
 */
public class Payment {
    /*payment title*/
    private String title;

    /*payment sum*/
    private double sum;

    /*payment currency*/
    private Currency currency;

    /*payment type*/
    private PaymentType type;

    /**
     * Constructor
     * @param title
     * @param sum
     * @param currency
     * @param type
     */
    public Payment(String title, double sum, Currency currency, PaymentType type) {
        this.title = title;
        this.sum = sum;
        this.currency = currency;
        this.type = type;
    }

    /*Getters and setters*/
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public PaymentType getType() {
        return type;
    }

    public void setType(PaymentType type) {
        this.type = type;
    }
}
