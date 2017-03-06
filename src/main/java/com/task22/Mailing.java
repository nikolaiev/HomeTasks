package com.task22;

/**
 * Created by vlad on 06.03.17.
 */
public abstract class Mailing {
    PunishmentDepartment department;
    String address;

    public Mailing(PunishmentDepartment department, String name){
        this.department=department;
        this.address=name;
    }

    void send(){
        department.sendMail(this);
    }

    public String getAdresserName() {
        return address;
    }
}
