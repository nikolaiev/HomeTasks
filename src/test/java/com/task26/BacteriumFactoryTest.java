package com.task26;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Vlad on 08.03.2017.
 */
public class BacteriumFactoryTest {
    BacteriumFactory factory;
    MultiCellBacterium myBacterium;
    MultiCellBacterium myBacteriumFromFactroy;

    SingleCellBacterium mySingleBacterium;
    SingleCellBacterium mySingleBacteriumFromFactroy;
    @Before
    public void init(){
        factory=BacteriumFactory.getInstance();
        myBacterium=new MultiCellBacterium("test",2);
        myBacteriumFromFactroy=factory.getMultyCellBacterium("test",2);

        mySingleBacterium=new SingleCellBacterium("test_single_init",3);
        mySingleBacteriumFromFactroy=factory.getSingleCellBacterium("test_single_init",3);
    }

    @Test
    public void getInstance() throws Exception {
        BacteriumFactory factory=BacteriumFactory.getInstance();
        BacteriumFactory factory2=BacteriumFactory.getInstance();
        assertEquals(factory,factory2);
    }

    /*Multi cell bacterium*/
    @Test
    public void getMultiCellBacteriumEquals() throws Exception {
        assert (myBacterium.equals(myBacteriumFromFactroy));
    }
    @Test
    public void getMultiCellBacteriumLinkDiff() throws Exception {
        assert (myBacterium!=myBacteriumFromFactroy);
    }

    @Test
    public void getMultiCellBacteriumLinkSame() throws Exception {
        MultiCellBacterium myBacteriumFromFactroy2=factory.getMultyCellBacterium(myBacteriumFromFactroy.getTitle(),
                myBacteriumFromFactroy.getCellCount());
        assert(myBacteriumFromFactroy2==myBacteriumFromFactroy);
    }

    @Test
    public void getMultiCellBacteriumLinkSameDiff() throws Exception {
        MultiCellBacterium myBacteriumFromFactroy2=factory.getMultyCellBacterium("!"+myBacteriumFromFactroy.getTitle(),
                myBacteriumFromFactroy.getCellCount());
        assert (myBacteriumFromFactroy2!=myBacteriumFromFactroy);
    }

    /*Single cell bacterium*/

    @Test
    public void getSingleCellBacteriumEquals() throws Exception {
        assert (mySingleBacterium.equals(mySingleBacteriumFromFactroy));
    }
    @Test
    public void getSingleCellBacteriumLinkDiff() throws Exception {
        assert (mySingleBacterium!=mySingleBacteriumFromFactroy);
    }

    @Test
    public void getSingleCellBacteriumLinkSame() throws Exception {
        SingleCellBacterium mySingleBacteriumFromFactroy2=factory.getSingleCellBacterium(mySingleBacteriumFromFactroy.getTitle()
                ,mySingleBacteriumFromFactroy.getCellDiameter());
        System.out.println(mySingleBacteriumFromFactroy2.getTitle());
        assertEquals (mySingleBacteriumFromFactroy2,mySingleBacteriumFromFactroy);
    }

    @Test
    public void getSingleCellBacteriumLinkSameDiff() throws Exception {
        SingleCellBacterium mySingleBacteriumFromFactroy2=factory.getSingleCellBacterium("!"+mySingleBacteriumFromFactroy.getTitle()
                ,mySingleBacteriumFromFactroy.getCellDiameter());
        System.out.println(mySingleBacteriumFromFactroy2.getTitle());
        assertNotEquals(mySingleBacteriumFromFactroy2,mySingleBacteriumFromFactroy);
    }

    /*Exceptions*/

    /*Multi Cell bacterium*/
    @Test(expected = IllegalArgumentException.class)
    public void multiCellBacteriumTitleException(){
        BacteriumFactory.getInstance().getMultyCellBacterium(null,1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void multiCellBacteriumCellCountException(){
        BacteriumFactory.getInstance().getMultyCellBacterium("title",1);
    }

    /*Single Cell bacterium*/
    @Test(expected = IllegalArgumentException.class)
    public void singleCellBacteriumTitleException(){
        BacteriumFactory.getInstance().getSingleCellBacterium(null,1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void singleCellBacteriumCellDiameterException(){
        BacteriumFactory.getInstance().getMultyCellBacterium("title",0);
    }


}