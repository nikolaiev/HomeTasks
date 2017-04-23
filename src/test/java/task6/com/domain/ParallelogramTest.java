package task6.com.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by vlad on 15.02.17.
 */
public class ParallelogramTest {
    Shape shape=new Parallelogram(0,0,10,20,Math.PI/6);

    @Test
    public void getSquare() throws Exception {
        assertEquals(100.,shape.getSquare(),0.01);
    }

}