package com.task22;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by vlad on 10.03.17.
 */
public class PublishDepartmentTest {
    PublishDepartment publishDepartment;
    @Before
    public void init(){
        publishDepartment=new PublishDepartment();
    }

    @Test(expected = IllegalArgumentException.class)
    public void setMailDepartmentException() throws Exception {
        publishDepartment.setMailDepartment(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void sendMail() throws Exception {
        publishDepartment.sendMail(null);
    }

}