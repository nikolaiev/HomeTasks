package com.task13;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

/**
 * Created by vlad on 23.02.17.
 */

public class QuickSortTest {

    private List<Integer> numbers=new ArrayList<>(SIZE);
    private final static int SIZE = 10;
    private final static int MAX = 500;

    @Before
    public void setUp() throws Exception {
        Random generator = new Random();
        for (int i = 0; i < SIZE; i++) {
            numbers.add(generator.nextInt(MAX));
        }
    }

    @Test
    public void testNull() {
        QuickSort.sort(null);
    }

    @Test
    public void testEmpty(){
        QuickSort.sort(new ArrayList<Integer>());
    }

    @Test
    public void testCustomClass() {
        class Test{
            private int val=10;

            private Test(int val) {
                this.val = val;
            }

            @Override
            public String toString(){
                return Integer.toString(val);
            }
        }
        ArrayList<Test> tests=new ArrayList<Test>(5){{
            add(new Test(9));
            add(new Test(7));
            add(new Test(15));
            add(new Test(8));
            add(new Test(10));
        }};

        QuickSort.sort(tests,(o1,o2)->{return o1.val-o2.val;});

        for(int i=0;i<tests.size()-1;i++){
            if(tests.get(i).val>tests.get(i+1).val)
                fail("Should not happen");
        }
    }

    @Test
    public void testSimpleElement() {
        QuickSort.sort(new ArrayList<Integer>(){{
            add(100);
        }});
    }

    @Test
    public void testSpecial() {
        QuickSort.sort(numbers, (o1,o2)->{ return o2-o1;});
        printResult(numbers);
        if (!validate(numbers)) {
            fail("Should not happen");
        }
        //printResult(test);
    }

    @Test
    public void testQuickSort() {
        long startTime = System.currentTimeMillis();

        QuickSort.sort(numbers);

        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("Quicksort " + elapsedTime);

        if (!validate(numbers)) {
            fail("Should not happen");
        }
        assertTrue(true);
    }

    @Test
    public void testStandardSort() {
        if(validate(numbers)){
            System.out.println("ALREADY SORTED!");
            return;
        }
        long startTime = System.currentTimeMillis();
        numbers.sort(Comparator.naturalOrder());
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("Standard Java sort " + elapsedTime);
        if (!validate(numbers)) {
            fail("Should not happen");
        }
        assertTrue(true);
    }


    private boolean validate(List<Integer> numbers) {
        for (int i = 0; i < numbers.size() - 1; i++) {
            if (numbers.get(i) > numbers.get(i+1)) {
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

