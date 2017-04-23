package com.task26;

/**
 * Created by Vlad on 08.03.2017.
 */
public class MultiCellBacterium extends Bacterium {
    private int cellCount=2;

    public MultiCellBacterium(String title) {
        this(title,2);
    }


    public MultiCellBacterium(String title, int cellCount) {
        super(title);
        this.cellCount = cellCount;
    }

    /*getter*/
    public int getCellCount() {
        return cellCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MultiCellBacterium that = (MultiCellBacterium) o;

        if(!title.equals(that.title)) return false;
        return cellCount == that.cellCount;
    }

    @Override
    public int hashCode() {
        return cellCount;
    }
}
