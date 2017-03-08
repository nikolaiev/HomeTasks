package com.task25;

/**
 * Created by Vlad on 08.03.2017.
 */
public class Cell {
    /*Mark type*/
    private CellMarkType cellMarkType;

    /**
     * Default Constructor
     */
    public Cell(){
        this(null);
    }

    /**
     * Constructor
     * @param cellMarkType cell mark type
     */
    public Cell(CellMarkType cellMarkType) {
        if(cellMarkType==null)
            this.cellMarkType=CellMarkType.EMPTY;
        else
            this.cellMarkType = cellMarkType;
    }

    /*Getter for cellMarkType field*/
    public CellMarkType getCellMarkType() {
        return cellMarkType;
    }

    /*Setter for cellMarkType field*/
    public void setCellMarkType(CellMarkType cellMarkType) {
        if(cellMarkType==null)
            this.cellMarkType = CellMarkType.EMPTY;
        else
            this.cellMarkType = cellMarkType;
    }
}
