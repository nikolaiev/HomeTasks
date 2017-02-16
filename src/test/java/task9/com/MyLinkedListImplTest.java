package task9.com;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

/**
 * Created by vlad on 15.02.17.
 */
public class MyLinkedListImplTest {

    MyLinkedList<Integer> myList=new MyLinkedListImpl<Integer>();
    @Test
    public void get() throws Exception {
        myList.add(1);
        myList.add(2);
        myList.add(4);
        assertEquals(2,myList.get(1).intValue());
    }

    @Test
    public void getFirst() throws Exception {
        //assertEquals(null,myList.getFirst());
        myList.add(1);
        //assertEquals(1,myList.getFirst().intValue());
        myList.add(2);
        myList.add(4);
        assertEquals(1,myList.getFirst().intValue());

    }

    @Test
    public void getLast() throws Exception {
        //assertEquals(null,myList.getLast());
        myList.add(1);
        //assertEquals(1,myList.getLast().intValue());
        myList.add(2);
        myList.add(4);
        assertEquals(4,myList.getLast().intValue());

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void setException() throws Exception {
        myList.set(0,10);
    }
    @Test
    public void set() throws Exception {
        myList.add(1);
        myList.set(0,10);
        //assertEquals(10,myList.getFirst().intValue());
        myList.add(2);
        //assertEquals(2,myList.getLast().intValue());
        myList.add(3);
        myList.add(4);
        assertEquals(3,myList.get(2).intValue());
    }

    @Test
    public void setFirst() throws Exception {
        myList.add(1);
        myList.add(2);
        myList.add(4);
        myList.setFirst(100);
        assertEquals(100,myList.getFirst().intValue());
    }

    @Test
    public void setLast() throws Exception {
        myList.add(1);
        myList.add(2);
        myList.add(4);
        myList.setLast(100);
        assertEquals(100,myList.getLast().intValue());
    }

    @Test
    public void add() throws Exception {
        //assertEquals(myList.getSize(),0);
        myList.add(1);
        //assertEquals(1,myList.getLast().intValue());
        myList.add(2);
        assertEquals(2,myList.getSize());

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addIndexException() throws Exception {
        myList.add(0,1);

    }

    @Test
    public void addIndex(){
        myList.add(2);
        myList.add(4);
        myList.add(5);
        myList.add(0,15);

        //assertEquals(15,myList.getFirst().intValue());

        myList.add(myList.getSize()-1,16);

        //assertEquals(16,myList.getLast().intValue());

        myList.add(2,17);

        assertEquals(17,myList.get(2).intValue());

    }



    @Test
    public void removeLast() throws Exception {
        myList.add(2);
        myList.add(4);
        myList.add(5);
        myList.removeLast();
        assertEquals(4,myList.getLast().intValue());
        assertEquals(2,myList.getSize());
    }

    @Test
    public void removeFirst() throws Exception {
        myList.add(2);
        myList.add(4);
        myList.add(5);
        myList.removeFirst();
        assertEquals(4,myList.getFirst().intValue());
        assertEquals(2,myList.getSize());
    }

    @Test
    public void removeIndex() throws Exception {
        myList.add(2);
        myList.add(4);
        myList.add(5);

        myList.remove(1);
        assertEquals(5,myList.get(1).intValue());
    }

    @Test
    public void removeObject() throws Exception {
        myList.add(2);
        myList.add(4);
        myList.add(5);
        myList.add(16);

        myList.remove(new Integer(5));
        assertEquals(16,myList.get(2).intValue());

        myList.remove(new Integer(2));
        assertEquals(4,myList.getFirst().intValue());

        myList.remove(new Integer(16));
        assertEquals(4,myList.getLast().intValue());
    }

    @Test(expected = NoSuchElementException.class)
    public void iteratorException() throws Exception {
        myList.add(1);
        myList.add(2);
        myList.add(4);
        Iterator<Integer> myListIterator=myList.iterator();
        while (true){
            myListIterator.next();
        }
    }

}