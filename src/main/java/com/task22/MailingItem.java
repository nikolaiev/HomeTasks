package com.task22;

/**
 * Created by vlad on 06.03.17.
 */
public abstract class MailingItem {
    /*publish department for this mailing item*/
    PublishDepartment department;
    /*person's name is addressed to*/
    String address;
    String title;

    /**
     * Constructor
     * @param department publish department
     * @param name item's name
     */
    public MailingItem(PublishDepartment department, String name, String title){
        this.department=department;
        this.address=name;
        this.title=title;
    }

    /**
     * Send this mailing to address
     */
    public void send(){
        department.sendMail(this);
    }

    /**
     * Get address
     * @return address
     */
    public String getAddress() {
        return address;
    }

    public String getTitle() {
        return title;
    }
}
