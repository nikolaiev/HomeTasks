package com.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/**
 * Created by vlad on 14.02.17.
 */
public abstract class Credit implements Serializable{
    String title;
    Date bdate;
    Date edate;
    Map<Currency,Double> percent;
}
