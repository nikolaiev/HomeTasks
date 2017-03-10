package com.task21.heros;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by vlad on 10.03.17.
 */
public class HeroTest {

    Hero hero=new Harpy("harpy");

    @Test(expected = IllegalArgumentException.class)
    public void HeroConstException(){
        Hero hero=new Orc(null);
    }
    @Test
    public void flyWithMagic() throws Exception {
        hero.flyWithMagic();
    }

    @Test
    public void move() throws Exception {
        hero.move();
    }

    @Test
    public void move1() throws Exception {

    }

}