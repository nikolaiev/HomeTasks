package com.task25;

/**
 * Created by Vlad on 08.03.2017.
 */
public class Memento {
    /*field main information*/
    private CellMarkType[][] fieldLightCopy;

    /**
     * Constructor
     * @param fieldLightCopy CellMarkType[][] field's
     *                       cells' cellMarkType field copy
     */
    public Memento(CellMarkType[][] fieldLightCopy) {
        this.fieldLightCopy=fieldLightCopy;
    }

    /*getter for fieldLightCopy field*/
    public CellMarkType[][] getFieldLightCopy() {
        return fieldLightCopy;
    }
}
