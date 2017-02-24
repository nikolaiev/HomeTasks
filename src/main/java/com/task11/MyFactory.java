package com.task11;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

/**
 * Created by vlad on 21.02.17.
 */
//TODO Используя PhantomReference написать Factory,
// которsй контролирует  создание объекта некоторого класса A
// (количество созданных в памяти объектов не должно превышать определенного количества,
// которое задается через конструктор Factory)

public class  MyFactory{

    private int OBJ_MAX_LIMIT = 10;         //max objects in memory
    private int count = 0;                  //objects in memory
    private final ReferenceQueue<MyObject> queue =
            new ReferenceQueue<>();

    @SuppressWarnings("unchecked")
    private PhantomReference<MyObject> [] refs=
            (PhantomReference<MyObject>[])new PhantomReference[OBJ_MAX_LIMIT];

    /**
     * Empty constructor
     */
    public MyFactory(){}

    /**
     * Set max objects amount in memory
     * @param limit max obj amount
     */
    public MyFactory(int limit){
        if(limit<1)
            throw new IllegalArgumentException();
        this.OBJ_MAX_LIMIT=limit;
    }

    /**
     * Retrive new Object
     * @return new MyObject
     * @throws InterruptedException
     */
    public synchronized MyObject getObject() throws InterruptedException {
        //do until object not returned
        while (true) {
            if (count < OBJ_MAX_LIMIT) {
                return wrapObject();
            } else {//max object amount is reached

                //System.out.println("not enough memory");
                System.gc();//try to call gc

                /*wait 150 milisecs to retrieve Phantom ref*/
                Reference ref = queue.remove(150);

                /* if obj was destroyed*/
                if (ref != null) {
                    //System.out.println("Memory released");
                    count--;
                }
            }
        }
    }

    /**
     * Wraps object link into PhantomReference
     * @return new MyObject
     */
    private MyObject wrapObject(){
        //System.out.println("Object created");
        MyObject obj=new MyObject();
        refs[count++]=new PhantomReference<>(obj, queue);
        return obj;
    }
}


class MyObject{}
