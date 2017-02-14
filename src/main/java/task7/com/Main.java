package task7.com;

import task7.com.domain.Automobile;
import task7.com.domain.Engine;

/**
 * Created by vlad on 14.02.17.
 */
public class Main {
    private Main(){}
    public static void main(String[] args) {
        Engine engine=new Engine(1.6,100,0.08);

        Automobile automobile=new Automobile(35,0,
                4,13,"Mercedes",engine);
        automobile.showMark();
        automobile.refuel(35);
        automobile.go(10);
    }
}
