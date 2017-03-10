package com.task22;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by vlad on 10.03.17.
 */
public class NewsPaperTest {
    @Test(expected = IllegalArgumentException.class)
    public void setPublishDate() throws Exception {
        NewsPaper paper=new NewsPaper(new PublishDepartment(),"name","title");
        paper.setPublishDate(null);
    }

}