package task6.com.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by vlad on 15.02.17.
 */
public class TriangleTest {
    List<Point> points;
    Shape shape;

    @Before
    public void init(){
        points=new ArrayList<Point>();

        points.add(new Point(0,0));
        points.add(new Point(1,0));
        points.add(new Point(0,1));

        shape=new Triangle(points);
    }

    @Test
    public void getSquare() throws Exception {
        assertEquals(0.5,shape.getSquare(),0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getSquareException(){
        points.add(new Point(2,2));
        shape=new Triangle(points);
    }

}