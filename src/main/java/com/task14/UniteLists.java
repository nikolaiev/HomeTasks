package com.task14;

import com.task13.QuickSort;


import java.util.Comparator;
import java.util.List;

/**
 * Created by vlad on 21.02.17.
 */
public final class UniteLists {
    private UniteLists(){}

    public static <T extends Comparable<? super T>> void uniteSortLists(List<T> list1, List<T> list2){
        list1.addAll(list2);
        QuickSort.sort(list1);
    }

    public  static <T> void uniteSortLists(List<T> list1, List<T> list2, Comparator<? super T> comparator){
        list1.addAll(list2);
        QuickSort.sort(list1,comparator);
    }
}
