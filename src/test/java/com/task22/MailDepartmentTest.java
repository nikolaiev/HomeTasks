package com.task22;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by vlad on 10.03.17.
 */
public class MailDepartmentTest {
    MailDepartment department;

    @Before
    public void init(){
        department=new MailDepartment();
    }

    @Test
    public void sendMail() throws Exception {
        department.sendMail(new Magazine(new PublishDepartment(),"name","title"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void addDepartment() throws Exception {
        department.addDepartment(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addSubscriber() throws Exception {
        department.addSubscriber(null);
    }

}