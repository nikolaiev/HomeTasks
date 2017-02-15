package task7.com.domain;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by vlad on 14.02.17.
 */
public class WheelTest {

    @Test
    public void getTest(){
        Wheel wheel=new Wheel(150);
        assertEquals(13.,wheel.getDiameter(),0.001);
    }

    @Test
    public void setTest(){
        Wheel wheel=new Wheel(20);
        wheel.setDiameter(15);
        assertEquals(15.,wheel.getDiameter(),0.001);
    }


}