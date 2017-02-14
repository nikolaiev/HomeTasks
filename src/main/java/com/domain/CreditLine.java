package com.domain;

import java.util.Date;
import java.util.Map;

/**
 * Created by vlad on 14.02.17.
 */
public class CreditLine {
    String title;
    Date bdate;
    Date edate;
    Map<Currency, Double> percent;
    boolean isExpandable;

    public CreditLine(String title, Date bdate, Date edate, Map<Currency, Double> percent,boolean isExpandable) {
        this.title = title;
        this.bdate = bdate;
        this.edate = edate;
        this.isExpandable = isExpandable;
        this.percent = percent;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getBdate() {
        return bdate;
    }

    public void setBdate(Date bdate) {
        this.bdate = bdate;
    }

    public Date getEdate() {
        return edate;
    }

    public void setEdate(Date edate) {
        this.edate = edate;
    }

    public boolean isExpandable() {
        return isExpandable;
    }

    public void setExpandable(boolean expandable) {
        isExpandable = expandable;
    }


    public Map<Currency, Double> getPercent() {
        return percent;
    }

    public void setPercent(Map<Currency, Double> percent) {
        this.percent = percent;
    }
}
