package com.task22;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by vlad on 06.03.17.
 */
public class MailDepartment {
    /*Publish departments list*/
    Set<PublishDepartment> departmentList;
    /*All known addresses(subscribers)*/
    Set<Subscriber> subscribers;

    /**
     * Constructor
     */
    public MailDepartment() {
        this.departmentList = new HashSet<>();
        this.subscribers=new HashSet<>();
    }

    /**
     * Add department to publish departments
     * @param department depart to add
     */
    public void addDepartment(PublishDepartment department){
        if(department==null)
            throw new IllegalArgumentException();
        departmentList.add(department);
        /*set Observer object to observable*/
        department.setMailDepartment(this);
    }

    /**
     * Add subscriber to addresses list
     * @param subscriber item to add
     */
    public void addSubscriber(Subscriber subscriber){
        if(subscriber==null)
            throw new IllegalArgumentException();
        subscribers.add(subscriber);
    }

    /**
     * Observer method
     * @param mailing observable item
     */
    public void sendMail(MailingItem mailing) {

        for(Subscriber subscriber:subscribers){
            if(subscriber.getName().equals(mailing.getAddress())){
                subscriber.getMailing(mailing);
                System.out.println("Mail "+mailing.getTitle() +
                "was sent to "+mailing.getAddress());
                return;
            }
        }

        System.out.println("Address " + mailing.getAddress() +
                " was not found from mailing "+mailing.getTitle());
    }
}
