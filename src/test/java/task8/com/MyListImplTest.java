package task8.com;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

/**
 * Created by vlad on 15.02.17.
 */
public class MyListImplTest {
    MyList<Integer> myList=new MyListImpl<Integer>();

    @Test
    public void add() throws Exception {
        myList.add(1);
        myList.add(2);
        myList.add(4);
        assertEquals(2,myList.get(1).intValue());
    }

    @Test
    public void addIndex() throws Exception {
        myList.add(1);
        myList.add(2);
        myList.add(4);
        myList.add(3,2);

        assertEquals(3,myList.get(2).intValue());
    }

    @Test
    public void remove() throws Exception {
        myList.add(1);
        myList.add(2);
        myList.add(4);
        myList.add(3);

        System.out.println(myList);
        myList.remove(0);
        System.out.println(myList);
        assertEquals(2,myList.get(0).intValue());
    }

    @Test
    public void removeMiddle() throws Exception {
        myList.add(1);
        myList.add(2);
        myList.add(4);
        myList.add(3);

        System.out.println(myList);
        myList.remove(2);
        System.out.println(myList);
        assertEquals(3,myList.get(2).intValue());
    }

    @Test
    public void removeTop() throws Exception {
        myList.add(1);
        myList.add(2);
        myList.add(4);
        myList.add(3);

        myList.remove(myList.getSize()-1);
        assertEquals(4,myList.get(myList.getSize()-1).intValue());
    }

    @Test
    public void get() throws Exception {
        myList.add(1);
        myList.add(2);
        myList.add(4);
        myList.add(3);

        //assertEquals(1,myList.get(0).intValue());
        //assertEquals(3,myList.get(myList.getSize()-1).intValue());
        assertEquals(2,myList.get(1).intValue());
    }

    @Test
    public void getFirst() throws Exception {
        //assertEquals(null,myList.getFirst());
        myList.add(1);
        //assertEquals(1,myList.getFirst().intValue());
        myList.add(2);
        myList.add(4);
        myList.add(3);

        assertEquals(1,myList.getFirst().intValue());
    }

    @Test
    public void getLast() throws Exception {
        //assertEquals(null,myList.getLast());
        myList.add(1);
        //assertEquals(1,myList.getLast().intValue());
        myList.add(2);
        myList.add(4);
        myList.add(3);

        assertEquals(3,myList.getLast().intValue());

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void setException() throws Exception {
        myList.set(0,2);
        myList.set(1,2);
    }

    @Test
    public void set() throws Exception {
        myList.add(1);
        myList.set(0, 2);
        //assertEquals(2, myList.get(0).intValue());
        myList.add(3);
        myList.add(4);
        myList.add(5);
        myList.set(2, 10);
        //assertEquals(10, myList.get(2).intValue());
        myList.set(myList.getSize()-1,12 );
        assertEquals(12, myList.getLast().intValue());

    }

    @Test(expected = NoSuchElementException.class)
    public void iteratorException() throws Exception {
        myList.add(1);
        myList.add(2);
        Iterator<Integer> myListIterator=myList.iterator();
        while (true){
            myListIterator.next();
        }
    }

    /*concurrent modification exception test*/
    @Test
    public void concurrentModExceptionNotThrown(){
        myList.add(2);
        myList.add(1);
        myList.add(5);
        myList.add(3);

        Iterator<Integer> iterator=myList.iterator();

        Integer element;

        while (iterator.hasNext()){
            element=iterator.next();
            System.out.println(element);
            iterator.remove();
        }
    }
    @Test(expected = ConcurrentModificationException.class)
    public void concurrentModException(){
        myList.add(2);
        myList.add(1);
        myList.add(5);
        myList.add(3);

        Iterator<Integer> iterator=myList.iterator();

        Integer element;

        while (iterator.hasNext()){
            element=iterator.next();
            myList.add(123);
            System.out.println(element);
        }
    }
}