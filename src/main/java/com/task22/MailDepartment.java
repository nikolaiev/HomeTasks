package com.task22;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by vlad on 06.03.17.
 */
public class MailDepartment {
    Set<PunishmentDepartment> departmentList;
    Set<Subscriber> subscribers;

    public MailDepartment() {
        this.departmentList = new HashSet<>();
    }

    public void addDepartment(PunishmentDepartment department){
        departmentList.add(department);
        department.setMailDepartment(this);
    }

    public void addSubscriber(Subscriber subscriber){
        subscribers.add(subscriber);
    }

    public void sendMail(Mailing mailing) {
        for(Subscriber subscriber:subscribers){
            if(subscriber.getName()==mailing.getAdresserName()){
                subscriber.getMailing(mailing);
            }
        }
    }
}
