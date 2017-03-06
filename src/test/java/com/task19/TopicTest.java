package com.task19;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by vlad on 06.03.17.
 */
public class TopicTest {
    final String defaultText="Hello from Fantasy topic!";
    final String customText="Hello from Fantasy topic CUSTOM TEXT!";
    Topic topic=new FantasyTopic(defaultText);

    @Test
    public void setCustomText() throws Exception {
        topic.setCustomText(customText);
        assertEquals(topic.getCustomText(),customText);
    }


    @Test
    public void getDefaultText() throws Exception {
        assertEquals(topic.getDefaultText(),defaultText);
    }

}