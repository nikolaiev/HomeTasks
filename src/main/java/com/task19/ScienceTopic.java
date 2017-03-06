package com.task19;

/**
 * Created by vlad on 06.03.17.
 */
public class ScienceTopic extends Topic {

    public ScienceTopic(String text) {
        super(text);
    }

    @Override
    public ScienceTopic clone() {
        return new ScienceTopic(this.customText);
    }
}
