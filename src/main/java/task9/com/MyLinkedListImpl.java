package task9.com;

import java.util.Iterator;

/**
 * Created by vlad on 15.02.17.
 */
public class MyLinkedListImpl<T> implements MyLinkedList<T>{
    int size=0;
    Node<T> first=null;
    Node<T> last=null;

    public MyLinkedListImpl(){
    }

    public T get(int index) {
        Node<T> tempNode=first;
        for(int i=0;i<index;i++){
            tempNode=tempNode.next;
        }
        return tempNode.item;
    }

    public T getFirst() {
        if(first==null)
            return null;

        return first.item;
    }

    public T getLast() {
        if(last==null)
            return null;

        return last.item;
    }

    public void set(int index, T elem) {
        checkPositionIndex(index);

        Node<T> tempNode=first;
        for(int i=0;i<index;i++){
            tempNode=tempNode.next;
        }
        tempNode.item=elem;
    }

    public void setFirst(T elem) {
        if(first==null){
            first=new Node<T>(null,elem,null);
        }
        else{
            first.item=elem;
        }
    }

    public void setLast(T elem) {
        if(last==null){
            last=new Node<T>(null,elem,null);
        }
        else{
            last.item=elem;
        }
    }

    public void add(T elem) {
        if(first==null){
            first=new Node<T>(null,elem,null);
            last=first;
            return;
        }

        Node<T> newNode=new Node<T>(last,elem,null);
        last.next=newNode;
        last=newNode;
        size++;
    }

    public void add(int index, T elem) {
        checkPositionIndex(index);

        if(index==size-1){
            add(elem);
            return;
        }

        Node<T> tempNode=first;
        for(int i=0;i<index-1;i++){
            tempNode=tempNode.next;
        }

        tempNode.next=new Node<T>(tempNode,elem,tempNode.next);
        size++;
    }

    public boolean remove(int index) {
        checkPositionIndex(index);
        if(index==0){
            return removeFirst();
        }
        if(index==size-1){
            return removeLast();
        }

        Node<T> tempNode=first;
        for(int i=0;i<index;i++){
            tempNode=tempNode.next;
        }

        unlink(tempNode);
        return true;
    }

    public boolean removeLast() {
        if(last==null)
            return false;
        unlink(last);
        return true;
    }

    public boolean removeFirst() {
        if(first==null)
            return false;
        unlink(first);
        return true;
    }

    public boolean remove(T elem) {

        if(elem==null){
            for(Node<T> x=first;x!=null;x=x.next) {
                if (x.item==null){
                    unlink(x);
                    return true;
                }
            }
        }
        else {
            for(Node<T> x=first;x!=null;x=x.next) {
                if (x.item.equals(elem)){
                    unlink(x);
                    return true;
                }
            }
        }
        return false;
    }

    private void unlink(Node<T> x) {
        final T element = x.item;
        final Node<T> next = x.next;
        final Node<T> prev = x.prev;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.item = null;
        size--;
    }

    public Iterator<T> iterator()
    {
        return new IteratorTest();
    }

    /**
     * Check if Index is availiable in list
     * @param index
     */
    private void checkPositionIndex(int index) {
        if(index<0||index>size-1)
            throw new IndexOutOfBoundsException();
    }


    private class IteratorTest implements Iterator<T>
    {
        int index=0;

        public boolean hasNext(){return size>index;}

        public T next(){
            return get(index++);
        }

        public void remove(){
            MyLinkedListImpl.this.remove(index);
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

    private static class Node<T>{
        Node<T> next;
        Node<T> prev;
        T item;

        /*constructor*/
        Node(Node<T> prev,T elem,Node<T> next){
            this.next=next;
            this.prev=prev;
            item=elem;
        }
    }
}
