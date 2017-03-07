package com.task20.figures;

/**
 * Created by Vlad on 07.03.2017.
 */
public class Line extends Figure {
    private static final int DEF_CELL_COUNT=4;

    public Line(){
        super(DEF_CELL_COUNT);
    }

    public Line(int cellCount) {
        super(cellCount);
    }
}
