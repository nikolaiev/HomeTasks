package com.task15;


import javax.annotation.processing.SupportedSourceVersion;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by vlad on 21.02.17.
 */

public class PriorityQueueImpl <T> implements MyPriorityQueue <T>{
    private static final int DEFAULT_INITIAL_CAPACITY = 11;
    private Object[] queue;

    private int size = 0;

    private final Comparator<? super T> comparator;

    public PriorityQueueImpl() {
        this(DEFAULT_INITIAL_CAPACITY, null);
    }

    public PriorityQueueImpl(int initialCapacity) {
        this(initialCapacity, null);
    }

    public PriorityQueueImpl(Comparator<? super T> comparator) {
        this(DEFAULT_INITIAL_CAPACITY, comparator);
    }

    public PriorityQueueImpl(int initialCapacity,
                         Comparator<? super T> comparator) {
        if (initialCapacity < 1)
            throw new IllegalArgumentException();
        this.queue = new Object[initialCapacity];
        this.comparator = comparator;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public int size() {
        return size;
    }

    public void clear() {
        for (int i = 0; i < size; i++)
            queue[i] = null;
        size = 0;
    }

    public void insert(T elem){
        if(size+1>=queue.length){
            resizeHeap();
        }
        queue[++size]=elem;
        swim(size);
    }

    @SuppressWarnings("unchecked")
    public T delMax(){
        T max=(T)queue[1];
        exch(1,size--);
        queue[size+1]=null;
        sink(1);
        return max;
    }

    /*Object key is larger than parent's*/
    private void swim(int k){
        while(k>1 && less(k/2,k)){
            exch(k/2,k);
            k/=2;
        }
    }

    /*Object key is less than child's*/
    private void sink(int k){
        //tree height
        while(2*k<=size){
            int j=2*k;
            if(j<size && less(j,j+1)) j++;
            if(!less(k,j)) break;
            exch(k,j);
            k=j;
        }
    }

    @SuppressWarnings("unchecked")
    private boolean less(int i,int j){
        if(comparator!=null){
            return (comparator.compare((T)queue[i],(T)queue[j])<0);
        }
        else{
            return (((Comparable<? super T>)queue[i]).compareTo((T)queue[j])<0);
        }
    }

    @SuppressWarnings("unchecked")
    private void exch(int i,int j){
        T temp = (T)queue[i];
        queue[i] = queue[j];
        queue[j] = temp;
    }

    private void resizeHeap() {
        int oldCapacity = queue.length;
        // Double size if small; else grow by 50%
        int newCapacity = oldCapacity + ((oldCapacity < 64) ?
                (oldCapacity + 2) :
                (oldCapacity >> 1));

        queue = Arrays.copyOf(queue, newCapacity);
    }

}
