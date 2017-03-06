package com.task22;

/**
 * Created by vlad on 06.03.17.
 */
public class PunishmentDepartment {
    private MailDepartment mailDepartment;

    public void setMailDepartment(MailDepartment mailDepartment) {
        this.mailDepartment = mailDepartment;
    }

    public void sendMail(Mailing mailing) {
        mailDepartment.sendMail(mailing);
    }
}
