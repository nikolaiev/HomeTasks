package com.task16;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by vlad on 06.03.17.
 */
public class FieldTest {
    Field field=new Field(new Player("test"));
    Cell cell=new Cell();
    Ship ship=new Ship(field);

    @Before
    public void init(){
        cell.setShip(ship);
    }
    @Test
    public void killCell() throws Exception {
        cell.kill();
        assert(ship.isShipDestroyed());
    }

    @Test
    public void initShips() throws Exception {
        field.initShips();
    }
}