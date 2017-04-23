package com.task16;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by vlad on 06.03.17.
 */
public class PlayerTest {
    Player player=new Player("test");

    Field field=new Field(player);
    Cell cell=new Cell();
    Ship ship=new Ship(field);

    @Before
    public void init(){
        ship.addCell(cell);
    }
    @Test
    public void getField() throws Exception {
        player.initField();
        assertNotNull(player.getField());
    }

    @Test
    public void loseGame() throws Exception {
        player.loseGame();
        assert(player.isDestroyed());
    }
}