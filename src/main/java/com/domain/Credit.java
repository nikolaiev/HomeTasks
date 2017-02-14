package com.domain;

import java.util.Date;
import java.util.Map;

/**
 * Created by vlad on 14.02.17.
 */
public class Credit {
    String title;
    Date bdate;
    Date edate;
    Map<Currency,Double> percent;
    boolean isAmortizable;

    public Credit(String title, Date bdate, Date edate, Map<Currency,Double> percent,boolean isAmortizable) {
        this.title = title;
        this.bdate = bdate;
        this.edate = edate;
        this.percent = percent;
        this.isAmortizable=isAmortizable;
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

    public Map<Currency, Double> getPercent() {
        return percent;
    }

    public void setPercent(Map<Currency, Double> percent) {
        this.percent = percent;
    }
}
