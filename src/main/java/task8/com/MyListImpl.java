package task8.com;

import java.io.ObjectInputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * OneWayLinkedList
 * Created by vlad on 14.02.17.
 */

public class MyListImpl<T> implements MyList<T>,Iterable<T>{
    Node<T> first;
    Node<T> last;
    int size = 0;

    /**
     * Empty constructor
     */
    public MyListImpl() {}

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
            while (i != index-1) {
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

        if(index==0){
            first=first.next;
            size--;
            return;
        }

        int i=0;
        Node<T> prevNode=first;

        while (i<index-1){
            prevNode=prevNode.next;
            i++;
        }

        Node<T> removableNode=prevNode.next;
        prevNode.next=removableNode.next;
        size--;
    }


    public T get(int index) {
        checkPositionIndex(index);
        Node<T> x = first;
        for (int i = 0; i < index; i++)
            x = x.next;
        return x.item;

    }

    public T getFirst(){
        if(first!=null)
            return first.item;
        else
            return null;
    }

    public T getLast(){
        if(last!=null)
            return last.item;
        else
            return null;
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

    public int getSize() {
        return size;
    }

    public Iterator<T> iterator()
    {
        return new IteratorTest();
    }

    private class IteratorTest implements Iterator<T>
    {
        int index=0;

        public boolean hasNext(){return size>index;}

        public T next(){
            if(!hasNext())
                throw new NoSuchElementException();
            return get(index++);
        }

        public void remove(){
            MyListImpl.this.remove(index);
        }
    }

    @Override
    public String toString(){
        Iterator<T> it = iterator();
        if (! it.hasNext())
            return "[]";

        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (;;) {
            T e = it.next();
            sb.append(e == this ? "(this Collection)" : e);
            if (! it.hasNext())
                return sb.append(']').toString();
            sb.append(',').append(' ');
        }
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
