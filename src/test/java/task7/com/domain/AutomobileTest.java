package task7.com.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by vlad on 15.02.17.
 */
public class AutomobileTest {
    Automobile automobile;

    @Before
    public void init(){
        automobile=new Automobile(35,35,4,
                13,"Mercedes",new Engine(1.6,100,0.08));
    }
    @Test
    public void go() throws Exception {
            automobile.go(10);
            assertEquals(34.2,automobile.getFuelAmount(),0.01);
    }

    @Test
    public void refuel() throws Exception {
        if(automobile.getFuelAmount()==automobile.getTankCapacity()){
            automobile.go(100);
        }
        double initFuel =automobile.getFuelAmount();
        automobile.refuel(2);
        assertEquals(initFuel+2  ,automobile.getFuelAmount(),0.001);

    }

    @Test
    public void changeWheel() throws Exception {

    }

    @Test(expected = IllegalArgumentException.class)
    public void changeWheelException() throws Exception {
        automobile.changeWheel(4,null);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void wheelIndexException(){
        automobile.changeWheel(5,new Wheel(1));
    }

}