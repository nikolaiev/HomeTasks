package com.task21.strategies;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by vlad on 10.03.17.
 */
public class MixStrategyTest {
    MixStrategy strategy;

    @Before
    public void init(){
        strategy=new MixStrategy();
    }


    @Test
    public void getPrefSimpleStrategyType() throws Exception {
        assertNotNull(strategy.getPrefSimpleStrategyType());
    }

    @Test
    public void setPrefSimpleStrategyType() throws Exception {
        strategy.setPrefSimpleStrategyType(SimpleStrategyType.FOOT);
        assertEquals(SimpleStrategyType.FOOT,strategy.getPrefSimpleStrategyType());
    }

    @Test(expected = IllegalArgumentException.class)
    public void setPrefSimpleStrategyTypeException() throws Exception {
        strategy.setPrefSimpleStrategyType(null);
    }


    @Test(expected = IllegalArgumentException.class)
    public void moveException() throws Exception {
        strategy.move(null);
    }
}