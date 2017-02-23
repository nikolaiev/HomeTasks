package com.task14;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by vlad on 23.02.17.
 */
public class UniteListsTest {
    private final int size1=10;
    private final int size2=20;
    @Test
    public void uniteSortListsComparable() throws Exception {
        List<Integer> list1=generateRandomNumbers(size1);
        List<Integer> list2=generateRandomNumbers(size2);
        UniteLists.uniteSortLists(list1,list2);

        if(list1.size()!=size1+size2){
            fail("Lists are not united");
        }

        if(!validate(list1)){
            fail("List is not sorted");
        }
    }

    /*Changed comparator*/
    @Test
    public void uniteSortLists() throws Exception {
        List<Integer> list1=generateRandomNumbers(size1);
        List<Integer> list2=generateRandomNumbers(size2);
        UniteLists.uniteSortLists(list1,list2,(o1,o2)->{return o2-o1;});

        if(list1.size()!=size1+size2){
            fail("Lists are not united");
        }

        if(!validateDes(list1)){
            fail("List is not sorted");
        }
    }


    private boolean validate(List<Integer> numbers) {
        for (int i = 0; i < numbers.size() - 1; i++) {
            if (numbers.get(i) > numbers.get(i+1)) {
                return false;
            }
        }
        return true;
    }

    private boolean validateDes(List<Integer> numbers) {
        for (int i = 0; i < numbers.size() - 1; i++) {
            if (numbers.get(i) < numbers.get(i+1)) {
                return false;
            }
        }
        return true;
    }

    private <T> void printResult(List<T> numbers) {
        for (T e: numbers) {
            System.out.println(e);
        }
        System.out.println();
    }
    private  List<Integer> generateRandomNumbers(int n){

        List<Integer> result=new ArrayList<Integer>(n);
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            result.add(random.nextInt(n * 10));
        }
        return result;
    }

}