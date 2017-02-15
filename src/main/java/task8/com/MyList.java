package task8.com;

/**
 * Created by vlad on 14.02.17.
 */
public interface MyList<T> {
    void add(T elem);

    void add(T elem, int index);

    void remove(int index);

    //void remove(T elem);

    T get(int index);

    T getFirst();

    T getLast();

    void set(int index, T elem);

    int getSize();
}
