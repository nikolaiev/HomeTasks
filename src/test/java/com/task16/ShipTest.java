package com.task16;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by vlad on 06.03.17.
 */
public class ShipTest {
    Ship ship=new Ship(new Field(new Player("test")));

    @Test
    public void killCell() throws Exception {
        Cell cell=new Cell();
        cell.setShip(ship);
        ship.addCell(cell);
        cell.kill();
        assert(ship.isShipDestroyed());
    }
}