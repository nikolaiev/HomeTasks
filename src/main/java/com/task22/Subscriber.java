package com.task22;

/**
 * Created by vlad on 06.03.17.
 */
public class Subscriber {
    /*subscriber's name*/
    String name;

    /**
     * Constructor
     * @param name subscriber name
     */
    public Subscriber(String name) {
        this.name = name;
    }

    /**
     * Get name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Observable method
     * @param mailing received item
     */
    public void getMailing(MailingItem mailing) {
        System.out.println("Subscriber "+ name+
        "has received mailing "+mailing.getTitle());
    }
}
