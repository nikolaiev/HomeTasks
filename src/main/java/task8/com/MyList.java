package task8.com;

import java.util.LinkedList;

/**
 * Created by vlad on 14.02.17.
 */

public class   MyList <T>{
    Node<T> first;

    public MyList(){
    }

    public T add(T elem){

    }

    private static class Node<T>{
        T item;
        Node<T> next;

        Node(T elem, Node<T> next){
            this.item=elem;
            this.next=next;
        }
    }
}
