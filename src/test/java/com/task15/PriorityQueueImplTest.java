package com.task15;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by vlad on 24.02.17.
 */
public class PriorityQueueImplTest {
    MyPriorityQueue<String> pq;
    @Before
    public void init(){
        pq=new PriorityQueueImpl<>((o1,o2)->{return o2.length()-o1.length();});
        pq.insert("Apple");
        pq.insert("App");
        pq.insert("App2222222222222222222");
        pq.insert("PineApple");
        pq.insert("Custard Apple");
        pq.insert("new Apple");
        pq.insert("new Apple123");
    }
    @Test
    public void isEmpty() throws Exception {
        pq=new PriorityQueueImpl<>((o1,o2)->{return o2.length()-o1.length();});
        assert (pq.isEmpty());

    }

    @Test
    public void sizeZero() throws Exception {
        pq=new PriorityQueueImpl<>((o1,o2)->{return o2.length()-o1.length();});
        assert (pq.size()==0);
    }

    @Test
    public void size() throws Exception {
        //pq=new PriorityQueueImpl<>((o1,o2)->{return o2.length()-o1.length();});
        assertEquals (pq.size(),7);
    }

    @Test
    public void clear() throws Exception {
        pq.clear();
        assertEquals(pq.size(),0);
    }

    @Test
    public void insert() throws Exception {
        int initSize=pq.size();
        pq.insert("test element");
        assertEquals (pq.size(),initSize+1);
    }

    @Test
    public void delMax() throws Exception {
        String shortest="1";
        pq.insert(shortest);//shortest string in queue
        assertEquals(shortest,pq.delMax());
    }

}