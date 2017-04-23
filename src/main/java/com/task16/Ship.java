package com.task16;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vlad on 05.03.17.
 */
public class Ship {
    private Field field;                    //Owner field
    private List<Cell> cells;               //Ship's cells list
    private boolean isShipDestroyed=false;  //Flag "if ship is still swimming"

    /**
     * Constructor
     * @param field owner field
     */
    public Ship(Field field){
        this.field=field;
        cells=new ArrayList<>();
    }

    /**
     * Adds cell into the ship's cell list
     * @param cell Cell object
     */
    public void addCell(Cell cell){
        cells.add(cell);
    }

    /**
     * Observer method
     * Called by recently shot cell
     * Checks if ship is still swimming
     */
    public void killCell() {
        isShipDestroyed=true;

        /*check if all cells are destroyed*/
        for(Cell cell:cells){
            if(!cell.isShot()){
                isShipDestroyed=false;
                return;
            }
        }
        /*
        * ship is destroyed
        * say it to all cells
        */
        for(Cell cell:cells){
            cell.shipDestroyed();
        }

        /*say field that ship was destroyed*/
        field.shipDestroyed();
    }

    /**
     * Getter for isShipDestroyed flag
     * @return isShipDestroyed flag
     */
    public boolean isShipDestroyed(){
        return isShipDestroyed;
    }
}
