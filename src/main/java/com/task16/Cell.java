package com.task16;

/**
 * Created by vlad on 05.03.17.
 */
public class Cell {
    private boolean isShot =false;              //was cell shot
    private boolean isShipDestroyed =false;     //is ship-owner is destroyed
    private Ship ship;                          //ship owner (can be null)

    /**
     * Empty constructor
     */
    public Cell(){}

    /**
     * Constructor
     * @param ship Ship- owner
     */
    public Cell(Ship ship) {
        this.ship=ship;
    }

    /**
     * set ship cell owns to
     * @param ship
     */
    public void setShip(Ship ship) {
        this.ship = ship;
    }

    /**
     * Shows is cell belongs to some ship
     * @return true if belongs
     */
    public boolean isInShip(){
        return ship!=null;
    }

    /*
    * shot in cell
    * */
    public boolean kill(){
        isShot =true;

        if(ship!=null) {
            ship.killCell();
            return true;
        }
        return false;
    }

    /**
     * check cell is shot
     * @return
     */
    public boolean isShot(){
        return isShot;
    }

    /**
     * Check if owner- ship is destroyed
     * @return isShipDestroyed
     */
    public boolean isShipDestroyed(){
        return isShipDestroyed;
    }

    /**
     * ship is destroyed
     * mark param as true
     */
    public void shipDestroyed() {
        isShipDestroyed = true;
    }
}
