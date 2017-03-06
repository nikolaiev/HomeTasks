package com.task19;

/**
 * Created by vlad on 06.03.17.
 */
public abstract class Topic implements Cloneable {
    String defaultText;     //initial text of topic
    String customText;      //updated text of topic

    public Topic(String text){
        this.defaultText =text;
        this.customText=text;
    }

    public void setCustomText(String newText){
        this.customText=newText;
    }

    public String getCustomText(){
        return customText;
    }

    public String getDefaultText(){
        return defaultText;
    }
    public abstract Topic clone();
}
