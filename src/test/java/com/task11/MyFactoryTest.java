package com.task11;

import org.junit.Before;
import org.junit.Test;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.reflect.Field;

import static org.junit.Assert.*;

/**
 * Created by vlad on 24.02.17.
 */
public class MyFactoryTest {
    final int OBJ_MAX_COUNT=3;
    Field refs;
    Field queue;

    MyFactory myFactory;
    @Before
    public void init() throws NoSuchFieldException, InterruptedException, IllegalAccessException {

        refs=MyFactory.class.getDeclaredField("refs");
        queue=MyFactory.class.getDeclaredField("queue");

        refs.setAccessible(true);
        queue.setAccessible(true);

        myFactory=new MyFactory(OBJ_MAX_COUNT);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorException(){
        new MyFactory(-1);
    }
    @Test
    public void refNotNull() throws Exception {
        @SuppressWarnings("unchecked")
        PhantomReference<MyObject> []refsFromObj=(PhantomReference<MyObject> []) refs.get(myFactory);
        assertNotNull(refsFromObj[OBJ_MAX_COUNT-1]);
    }

    @Test
    public void queueIsEmpty() throws Exception {
        @SuppressWarnings("unchecked")
        //PhantomReference<MyObject> []refsFromObj=(PhantomReference<MyObject> []) refs.get(myFactory);
        ReferenceQueue<MyObject> qFromObj=(ReferenceQueue<MyObject>) queue.get(myFactory);
        assertNull(qFromObj.poll());
    }

    @Test
    public void queueIsNotEmpty() throws InterruptedException, IllegalAccessException {

        ReferenceQueue<MyObject> qFromObj=(ReferenceQueue<MyObject>) queue.get(myFactory);

        MyObject myObject1= myFactory.getObject();
        MyObject myObject2= myFactory.getObject();
        MyObject myObject3= myFactory.getObject();

        myObject3=null;
        while (true){
            System.gc();
            if(qFromObj.poll()!=null){
                return;
            }
        }
    }

}