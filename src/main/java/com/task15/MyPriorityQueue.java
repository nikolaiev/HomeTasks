package com.task15;

/**
 * Created by vlad on 23.02.17.
 */
public interface MyPriorityQueue <T>{
   boolean isEmpty();
   int size();
   void clear();
   void insert(T element);
   T delMax();
}
