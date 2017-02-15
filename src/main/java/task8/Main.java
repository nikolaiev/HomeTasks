package task8;

import task8.com.MyList;
import task8.com.MyListImpl;

/**
 * Created by vlad on 14.02.17.
 */
public class Main {
    public static void main(String[] args) {
        MyList<Integer> myList=new MyListImpl<Integer>();
        myList.add(10);
        myList.add(20);
        myList.add(30);
        System.out.println(myList);
        //myList.remove(1);
        System.out.println(new Integer(10).equals(new Integer(10)));
        //myList.remove(Integer.valueOf(10));
        System.out.println(myList);

        myList.set(0,21);
        System.out.println(myList);
    }
}
