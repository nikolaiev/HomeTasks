package task6.com.domain;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by vlad on 15.02.17.
 */
public class TrapeziumTest {

    Shape shape=new Trapezium(0,0,10,20,20,Math.PI/6);
    @Test
    public void getSquare() throws Exception {
        assertEquals(150,shape.getSquare(),0.001);
    }

}