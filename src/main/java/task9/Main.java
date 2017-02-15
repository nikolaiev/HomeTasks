package task9;

import task9.com.MyLinkedList;
import task9.com.MyLinkedListImpl;

/**
 * Created by vlad on 14.02.17.
 */
public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> myLinkedList=new MyLinkedListImpl<Integer>();

        myLinkedList.add(10);
        myLinkedList.add(20);
        myLinkedList.add(30);
        myLinkedList.add(40);
        myLinkedList.add(50);

        System.out.println(myLinkedList);;

        myLinkedList.remove(2);
        System.out.println(myLinkedList);;
    }
}
