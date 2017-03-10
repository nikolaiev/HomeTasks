package com.task22;

/**
 * Created by vlad on 06.03.17.
 */
public class PublishDepartment {

    private MailDepartment mailDepartment;

    public void setMailDepartment(MailDepartment mailDepartment) {
        if(mailDepartment==null)
            throw new IllegalArgumentException();

        this.mailDepartment = mailDepartment;
    }

    public void sendMail(MailingItem mailing) {
        if(mailing==null)
            throw new IllegalArgumentException();
        mailDepartment.sendMail(mailing);
    }
}
