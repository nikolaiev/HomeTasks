package com.task13;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by vlad on 21.02.17.
 */

public final class QuickSort {

    private QuickSort() {
    }

    public static <T extends Comparable<? super T>> void sort(List<T> list) {
        sort(list, Comparator.naturalOrder());
    }

    public static <T> void sort(List<T> list, Comparator<? super T> comparator) {
        if (list == null || list.size() <= 1)
            return;
        quickSort(list, 0, list.size() - 1, comparator);
    }


    private static <T> void quickSort(List<T> array, int left, int right, Comparator<? super T> comparator) {
        if (left >= right) {
            return;
        }

        int q = partition(array, left, right, comparator);
        quickSort(array, left, q - 1, comparator);
        quickSort(array, q + 1, right, comparator);
    }

    private static <T> int partition(
            List<T> array, int first, int last,
            Comparator<? super T> comparator) {
        T key = array.get(last);
        int smaller = first - 1;
        for (int test = first; test < last; test++) {
            if (comparator.compare(array.get(test), key) <= 0) {
                smaller++;
                Collections.swap(array, smaller, test);
            }
        }
        smaller++;
        Collections.swap(array, smaller, last);
        return smaller;
    }

}
