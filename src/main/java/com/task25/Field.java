package com.task25;

import java.util.Map;

/**
 * Created by Vlad on 08.03.2017.
 */
public class Field {
    /*default size*/
    private final int SIZE=3;

    /*field cells*/
    private Cell[][] cells=new Cell[SIZE][SIZE];

    /**
     * Default constructor
     */
    public Field() {}

    /**
     * Initialization of default field
     */
    public void initDefaultField(){
        for(int i=0;i<SIZE;i++){
            for(int j=0;j<SIZE;j++){
                this.cells[i][j]=new Cell();
            }
        }
    }


    /**
     * Change cell
     * @param x x coordinate
     * @param y y coordinate
     * @param cell  Cell object
     */
    public void setCell(int x,int y,Cell cell){
        if(cell==null)
            throw new IllegalArgumentException();

        cells[x][y]=cell;
    }


    public Cell[][] getCells() {
        return cells;
    }

    /**
     * Get cell's CellMarkType
     * @param x x coordinate
     * @param y y coordinate
     * @return cell's CellMarkType
     */
    public CellMarkType getCellMark(int x,int y){
       return cells[x][y].getCellMarkType();
    }

    /**
     * Change cell
     * @param x x coordinate
     * @param y y coordinate
     * @param cellMarkType  CellMarkType object
     */
    public void setCellMark(int x,int y,CellMarkType cellMarkType){
        cells[x][y].setCellMarkType(cellMarkType);
    }

    /**
     * Check if game is over for concrete mark type
     * @param cellMarkType mark type
     * @return true if game is over
     */
    public boolean checkHasWon(CellMarkType cellMarkType){
        if(cellMarkType==CellMarkType.EMPTY)
            return false;
        else{
            boolean vertLineWon=true;
            boolean horizLineWon=true;
            boolean diagoalMainWon=true;
            boolean diagoalNonMainWon=true;

            /*vertical lines*/
            for(int i=0;i<SIZE;i++){
                vertLineWon=true;
                horizLineWon=true;

                //checks diagonals
                if(diagoalMainWon && cells[i][i].getCellMarkType()!=cellMarkType)
                    diagoalMainWon=false;
                if(diagoalNonMainWon && cells[i][SIZE-i-1].getCellMarkType()!=cellMarkType)
                    diagoalNonMainWon=false;

                //straight lines check
                for(int j=0;j<SIZE;j++){
                    //horizontal
                    if(cells[i][j].getCellMarkType()!=cellMarkType){
                        horizLineWon=false;
                    }
                    //vertical
                    if(cells[j][i].getCellMarkType()!=cellMarkType){
                        vertLineWon=false;
                    }

                    if(!horizLineWon && !vertLineWon)
                        break;
                }//for j

                if(horizLineWon || vertLineWon)
                    return true;

            }//for i

            return vertLineWon || horizLineWon ||
                    diagoalMainWon || diagoalNonMainWon;
        }
    }

    /**
     * Restore state from Memento Object
     * @param memento Memento Object
     */
    public void restoreState(Memento memento){
        CellMarkType[][] fieldLightCopy=memento.getFieldLightCopy();
        /*restoring info*/
        for(int i=0;i<SIZE;i++){
            for(int j=0;j<SIZE;j++){
                cells[i][j].setCellMarkType(fieldLightCopy[i][j]);
            }
        }
    }

    /**
     * Save field's state
     * @return Memento object
     */
    public Memento saveState(){
        CellMarkType[][] fieldLightCopy=new CellMarkType[SIZE][SIZE];
        /*copy cell info*/
        for(int i=0;i<SIZE;i++){
            for(int j=0;j<SIZE;j++){
                fieldLightCopy[i][j]=cells[i][j].getCellMarkType();
            }
        }
        return new Memento(fieldLightCopy);
    }

    /**
     * Check is game is draw
     * @return true if draw
     */
    public boolean checkDraw() {
        for(int i=0;i<SIZE;i++){
            for(int j=0;j<SIZE;j++){
                if(cells[i][j].getCellMarkType()==CellMarkType.EMPTY)
                    return false;
            }
        }
        return true;
    }
}
