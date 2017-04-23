package com.task22;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by vlad on 10.03.17.
 */
public class SubscriberTest {
    @Test
    public void getMailing() throws Exception {
        Subscriber subscriber=new Subscriber("name");
        subscriber.getMailing(new Magazine(new PublishDepartment(),"name","title"));
    }

}