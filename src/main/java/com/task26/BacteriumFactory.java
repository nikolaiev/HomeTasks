package com.task26;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Vlad on 08.03.2017.
 */
public class BacteriumFactory {
    private static BacteriumFactory instance=new BacteriumFactory();
    public static BacteriumFactory getInstance(){return instance;}

    private Set<MultiCellBacterium> multyCellBacterias;
    private Set<SingleCellBacterium> singleCellBacterias;

    /**
     * Default constructor
     */
    private BacteriumFactory(){
        multyCellBacterias=new HashSet<>();
        singleCellBacterias=new HashSet<>();
    }

    /**
     * Returns Bacteria object
     * @param title
     * @param cellCount
     * @return
     */
    public MultiCellBacterium getMultyCellBacterium(String title, int cellCount){
        if(title==null || cellCount<2)
            throw new IllegalArgumentException();
        //else

        for(MultiCellBacterium bacterium:multyCellBacterias){
            if(bacterium.getTitle().equals(title) && bacterium.getCellCount()==cellCount ){
                return bacterium;
            }
        }

        /*The bacterium is new*/
        MultiCellBacterium myBacterium=new MultiCellBacterium(title,cellCount);
        multyCellBacterias.add(myBacterium);
        return myBacterium;
    }

    /**
     * Returns Bacteria object
     * @param title
     * @param cellDiameter
     * @return
     */
    public  SingleCellBacterium getSingleCellBacterium(String title,int cellDiameter) {
        return getSingleCellBacterium(title,cellDiameter,false);
    }

    /**
     * Returns Bacteria object
     * @param title
     * @param cellDiameter
     * @param isFlagellum
     * @return
     */
    public SingleCellBacterium getSingleCellBacterium(String title,int cellDiameter,boolean isFlagellum){
        if(title==null || cellDiameter<1)
            throw new IllegalArgumentException();
        //else



            for(SingleCellBacterium bacterium:singleCellBacterias){
                if(bacterium.getTitle().equals(title) && bacterium.getCellDiameter()==cellDiameter){
                    return bacterium;
                }
            }

        /*The bacterium is new*/
        SingleCellBacterium myBacterium=new SingleCellBacterium(title,cellDiameter,isFlagellum);
        singleCellBacterias.add(myBacterium);
        return myBacterium;
    }
}
