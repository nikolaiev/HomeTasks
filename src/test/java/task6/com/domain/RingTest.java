package task6.com.domain;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by vlad on 15.02.17.
 */
public class RingTest {
    Shape shape=new Ring(0,0,1);

    @Test
    public void getSquare() throws Exception {
        assertEquals(Math.PI,shape.getSquare(),0.001);
    }

}