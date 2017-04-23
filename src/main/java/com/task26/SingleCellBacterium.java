package com.task26;

/**
 * Created by Vlad on 08.03.2017.
 */
public class SingleCellBacterium extends Bacterium {
    private boolean isFlagellum;
    private int cellDiameter;

    public SingleCellBacterium(String title,int cellDiameter) {
        this(title, cellDiameter,false);
    }

    public SingleCellBacterium(String title, int cellDiameter, boolean isFlagellum) {
        super(title);
        this.isFlagellum = isFlagellum;
        this.cellDiameter=cellDiameter;
    }

    /*getter*/
    public int getCellDiameter() {
        return cellDiameter;
    }

    /*getter*/
    public boolean isFlagellum() {
        return isFlagellum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SingleCellBacterium bacterium = (SingleCellBacterium) o;

        if (isFlagellum != bacterium.isFlagellum) return false;
        if(!title.equals(bacterium.title)) return false;
        return cellDiameter == bacterium.cellDiameter;
    }

    @Override
    public int hashCode() {
        int result = (isFlagellum ? 1 : 0);
        result = 31 * result + cellDiameter;
        return result;
    }
}
