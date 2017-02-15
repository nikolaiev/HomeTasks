package task9.com;

/**
 * Created by vlad on 15.02.17.
 */
public interface MyLinkedList<T> {
    T get(int index);
    T getFirst();
    T getLast();

    void set(int index,T elem);
    void setFirst(T elem);
    void setLast(T i);

    void add(T elem);
    void add(int index,T elem);


    boolean remove(int index);
    boolean removeLast();
    boolean removeFirst();
    boolean remove(T elem);

    int getSize();
}
