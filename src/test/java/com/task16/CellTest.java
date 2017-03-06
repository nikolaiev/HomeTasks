package com.task16;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by vlad on 06.03.17.
 */
public class CellTest {
    Cell cell;
    Ship ship;
    Field field;
    @Before
    public void init(){
        cell=new Cell();
        field=new Field(new Player("test"));
        ship=new Ship(field);
        ship.addCell(cell);
    }
    @Test
    public void setShip() throws Exception {
        cell.setShip(ship);
        assert(cell.isInShip());
    }

    @Test
    public void isInShip() throws Exception {
        cell.setShip(ship);
        assert(cell.isInShip());
    }
    
}