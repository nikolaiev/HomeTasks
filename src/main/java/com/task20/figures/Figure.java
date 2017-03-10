package com.task20.figures;

/**
 * Created by Vlad on 07.03.2017.
 */
public class Figure{
    /*figure's cells' amount*/
    private int cellCount;

    /**
     * Empty constructor
     */
    public Figure(){}

    /**
     * Creates new figure object
     * @param cellCount
     */
    public Figure(int cellCount){
        //cell count must be >0
        if(cellCount<1)
            throw new IllegalArgumentException();
        this.cellCount=cellCount;
    }

    /**
     * Get cell count field
     * @return cellCount
     */
    public int getCellCount() {
        return cellCount;
    }

    /*Factory methods*/

    /**
     * Factory method
     * Method creates default figure objects
     * @param figureType    figure type
     * @return              new figure object
     */
    public Figure getFigure(FigureType figureType){
        if(figureType==null)
            throw new IllegalArgumentException();
        switch (figureType){
            case CUBE:return new Cube();
            case LINE:return new Line();
            case ZIGZAG:return new ZigZag();
            case HOOK:return new Hook();
            default: return new Figure();
        }
    }

    /**
     * Factory method
     * Method creates figure objects with set cell count
     * @param figureType    figure type
     * @param cellCount     new cell amount
     * @return              new figure
     */
    public Figure getFigure(FigureType figureType,int cellCount){
        if(figureType==null)
            throw new IllegalArgumentException();
        switch (figureType){
            case CUBE:return new Cube(cellCount);
            case LINE:return new Line(cellCount);
            case ZIGZAG:return new ZigZag(cellCount);
            case HOOK:return new Hook(cellCount);
            default: return new Figure(cellCount);
        }
    }
}
