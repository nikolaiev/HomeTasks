package com.task19;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by vlad on 06.03.17.
 */
public class ScienceTopicTest {
    final String defaultText="Hello from Fantasy topic!";
    FantasyTopic fantasyTopic=new FantasyTopic(defaultText);
    @Test
    public void cloneTest() {
        FantasyTopic fantasyTopicClone=fantasyTopic.clone();
        System.out.println();
        assertEquals(fantasyTopicClone.getDefaultText(),defaultText);
    }

}