package com.task22;

import java.util.Date;

/**
 * Created by vlad on 06.03.17.
 */
public class NewsPaper extends MailingItem {
    /*item publish date*/
    private Date publishDate;

    /**
     * Constructor
     * @param department publish department
     * @param name       addresses' name
     * @param title      item's title
     */
    public NewsPaper(PunishmentDepartment department, String name,String title) {
        super(department, name,title);
        this.publishDate=new Date();
    }

    /**
     * Constructor
     * @param department publish department
     * @param name       addresses' name
     * @param title      item's title
     * @param publishDate publish date
     */
    public NewsPaper(PunishmentDepartment department,
                     String name,String title,Date publishDate) {
        super(department, name,title);
        this.publishDate=publishDate;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }
}
