package com.task25;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Vlad on 08.03.2017.
 */
public class FieldTest {


    Field field;
    @Before
    public void init(){
        field=new Field();
        field.initDefaultField();
    }
    @Test
    public void initDefaultField() throws Exception {

    }

    @Test
    public void setCell() throws Exception {

    }

    @Test
    public void getCellMark() throws Exception {

    }

    @Test
    public void setCellMark() throws Exception {

    }

    @Test
    public void checkHasWon() throws Exception {
        java.lang.reflect.Field cells=Field.class.getDeclaredField("cells");
        cells.setAccessible(true);
        Cell[][] cellsCheck=field.getCells();


        cells.set(field,cellsCheck);

        assertFalse(field.checkHasWon(CellMarkType.CROSS));
        cellsCheck[1][0].setCellMarkType(CellMarkType.CROSS);
        cellsCheck[2][2].setCellMarkType(CellMarkType.CROSS);
        cellsCheck[0][0].setCellMarkType(CellMarkType.CROSS);

        assertFalse(field.checkHasWon(CellMarkType.CROSS));

    }

    @Test
    public void restoreState() throws Exception {

    }

    @Test
    public void getCells() throws Exception {

    }

    @Test
    public void saveState() throws Exception {
        java.lang.reflect.Field cells=Field.class.getDeclaredField("cells");
        cells.setAccessible(true);
        Cell[][] cellsCheck=field.getCells();


        cells.set(field,cellsCheck);

        assertFalse(field.checkHasWon(CellMarkType.CROSS));

        cellsCheck[1][0].setCellMarkType(CellMarkType.CROSS);
        cellsCheck[2][2].setCellMarkType(CellMarkType.CIRCLE);
        cellsCheck[0][0].setCellMarkType(CellMarkType.CROSS);

        Memento m=field.saveState();

        cellsCheck[0][2].setCellMarkType(CellMarkType.CIRCLE);
        cellsCheck[1][2].setCellMarkType(CellMarkType.CIRCLE);

        field.restoreState(m);

        assertEquals(field.getCellMark(0,2),CellMarkType.EMPTY);
        assertEquals(field.getCellMark(1,2),CellMarkType.EMPTY);
        assertEquals(field.getCellMark(1,0),CellMarkType.CROSS);




    }

    @Test
    public void checkDraw() throws Exception {

    }

}