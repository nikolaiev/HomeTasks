package com.task20.figures;

/**
 * Created by Vlad on 07.03.2017.
 */
public class Cube extends Figure {
    private static final int DEF_CELL_COUNT=4;

    public Cube(){
        super(DEF_CELL_COUNT);
    }

    public Cube(int cellCount) {
        super(cellCount);
    }
}
