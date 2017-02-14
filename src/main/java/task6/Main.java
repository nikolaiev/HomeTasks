package task6;

import task6.com.domain.Ring;
import task6.com.domain.Trapezium;

/**
 * Created by vlad on 14.02.17.
 */
public class Main {
    public static void main(String[] args) {
        Trapezium trapezium=new Trapezium(0,0,10,20,3,1);
        Ring ring=new Ring(0,0,1);
        System.out.println(trapezium.getSquare());
        System.out.println(ring.getSquare());
        System.out.println(ring.summ(trapezium));
    }
}
