package task8.com;

import java.util.LinkedList;

/**
 * OneWayLinkedList
 * Created by vlad on 14.02.17.
 */

public class MyListImpl<T> implements MyList<T>{
    Node<T> first;
    Node<T> last;
    int size = 0;


    public MyListImpl() {
    }

    public void add(T elem) {
        final Node<T> l = last;
        final Node<T> newNode = new Node<T>(elem, null);
        last = newNode;

        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }

        size++;
    }

    public void add(T elem, int index) {
        checkPositionIndex(index);
        if(index==size)
            add(elem);
        else {
            int i = 0;
            Node<T> currNode = first;
            while (i != index) {
                currNode = currNode.next;
                i++;
            }
            /*insert new Node*/
            currNode.next = new Node<T>(elem, currNode.next);
            size++;
        }
    }


    public void remove(int index) {
        checkPositionIndex(index);

        int i=0;
        Node<T> prevNode=first;

        while (i!=index-1){
            prevNode=prevNode.next;
        }

        Node<T> removableNode=prevNode.next;
        prevNode.next=removableNode.next;
        size--;
    }

    public void remove(T elem) {
        int index=0;
        Node<T> currNode=first;
        while(currNode.next!=null){
            if(currNode.next.item.equals(elem)){
                currNode.next=currNode.next.next;
                size--;
                break;
            }
        }
    }

    public T get(int index) {
        checkPositionIndex(index);
        Node<T> x = first;
        for (int i = 0; i < index; i++)
            x = x.next;
        return x.item;

    }

    public void set(int index, T elem) {
        checkPositionIndex(index);

        Node<T> x = first;

        for (int i = 0; i < index; i++)
            x = x.next;
        x.item=elem;
    }

    /**
     * Check if Index is availiable in list
     * @param index
     */
    private void checkPositionIndex(int index) {
        if(index<0||index>size-1)
            throw new IndexOutOfBoundsException();
    }

    /*non deep clone*/
    public MyList<T> clone() {
        MyList<T> copy=new MyListImpl<T>();
        Node<T> currNode=first;
        for(int i=0;i<size;i++){
            copy.add(currNode.item);
            currNode=currNode.next;
        }
        return copy;
    }

    private static class Node<T> {
        T item;
        Node<T> next;

        Node(T elem, Node<T> next) {
            this.item = elem;
            this.next = next;
        }
    }
}
