package com.task26;

/**
 * Created by Vlad on 08.03.2017.
 */
public abstract class Bacterium {
    protected String title;

    public Bacterium(String title) {
        this.title = title;
    }

    /*getter*/
    public String getTitle() {
        return title;
    }
}
