package com.task19;

/**
 * Created by vlad on 06.03.17.
 */
public class FantasyTopic extends Topic {

    public FantasyTopic(String text) {
        super(text);
    }

    @Override
    public FantasyTopic clone() {
        return new FantasyTopic(this.customText);
    }
}
