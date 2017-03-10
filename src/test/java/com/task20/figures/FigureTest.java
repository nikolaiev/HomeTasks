package com.task20.figures;

import com.task16.Field;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.ThreadLocalRandom;

import static org.junit.Assert.*;

/**
 * Created by vlad on 10.03.17.
 */
public class FigureTest {
    Figure figure;
    @Before
    public void init(){
        figure=new Figure();
    }


    @Test(expected = IllegalArgumentException.class)
    public void FigureConstException(){
        Figure figure=new Figure(0);
    }

    @Test
    public void getCellCount() throws Exception {
        int randomNum = ThreadLocalRandom.current().nextInt(1, 100 + 1);
        Figure figure=new Figure(randomNum);
    }



    @Test
    public void getFigure() throws Exception {
        Figure figureNew=figure.getFigure(FigureType.CUBE);
        assertNotNull(figureNew);
    }


    @Test(expected = IllegalArgumentException.class)
    public void getFigureException() throws Exception {
        Figure figureNew=figure.getFigure(null);
    }

    @Test
    public void getFigureCellAmount() throws Exception {
        Figure figureNew=figure.getFigure(FigureType.CUBE,1);
        assertNotNull(figureNew);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getFigureCellAmountException() throws Exception {
        Figure figureNew=figure.getFigure(FigureType.CUBE,0);
        assertNotNull(figureNew);
    }
}