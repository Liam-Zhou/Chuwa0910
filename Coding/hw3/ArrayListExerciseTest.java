package com.chuwa.exercise.collection;

import org.hamcrest.internal.ArrayIterator;
import org.junit.Test;
import java.util.*;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author b1go
 * @date 6/12/22 4:43 PM
 */
public class ArrayListExerciseTest {
    /**
     * new ArrayList()
     * add elements
     * get element
     * get Size
     * list.addAll(anotherList)
     */
    @Test
    public void learn_Inserting_And_Retrieving() {
        List<Integer> arr = new ArrayList<>();

        for(int i=0; i < 10; i++) {
            arr.add(i);
            System.out.println(String.format("ArrayList has inserted %d",arr.get(arr.size()-1)));
        }

        List<Integer> arr2 = new ArrayList<>(List.of(1,2,3,4,5,6,7,8));
        arr.addAll(arr2);
    }

    /**
     * remove(int index)
     * remove(Object o)
     * removeRange(int fromIndex, int toIndex)
     * removeAll(Collection<?> c)
     * clear()
     *
     * Update:
     * set(int index, E e)
     * replaceAll(UnaryOperator<E> operator)
     *
     * check:
     * contains(Object o)
     * indexOf(Object o)
     * lastIndexOf(Object o)
     */
    @Test
    public void learn_Remove_Replacing_Updating() {
        ArrayList<Integer> arr = new ArrayList<>(List.of(1,2,3,4,5,6,7,8,9,10,11,13));
        ArrayList<String> arr1 = new ArrayList<>(Arrays.asList("ArrayList","String","arr1"));
        //Remove
        //remove(int index) and remove(Object o)
        System.out.printf("arr want to remove index 0 and its result is %b\n",arr.remove(0));
        System.out.printf("arr1 wants to remove ArrayList and its result is %b\n",arr1.remove("ArrayList"));
        // removeRange(int fromIndex, int toIndex) and removeAll(Collection<?> c) and clear()
        arr.forEach((Integer c) -> System.out.printf("%d ",c)); System.out.println();
        arr.subList(0,3).clear(); System.out.println("After arr.subList(0,3).clear()");
        arr.forEach((Integer c) -> System.out.printf("%d ",c)); System.out.println();
        arr.removeAll(new ArrayList<Integer>(List.of(5,6)));
        System.out.println("After removeAll [5,6]");
        arr.forEach((Integer c) -> System.out.printf("%d ",c)); System.out.println();
        System.out.println("After clear");
        arr.clear();
        System.out.printf("the size of arr is %d\n",arr.size());
        /*
         * Update:
         * set(int index, E e)
         * replaceAll(UnaryOperator<E> operator)
         */
        arr1.set(0,"arr1.set()");
        arr1.forEach((String i) -> System.out.print(i+" ")); System.out.println();
        arr1.replaceAll((String i) -> {return "Shit";});
        arr1.forEach((String i) -> System.out.print(i+" ")); System.out.println();
         /*
          * check:
          * contains(Object o)
          * indexOf(Object o)
          * lastIndexOf(Object o)
          */
        if(arr1.contains("Shit")) {
            System.out.println(arr1.indexOf("Shit"));
            System.out.println(arr1.lastIndexOf("Shit"));
        }

    }

    /**
     * iterator()
     * hasNext()
     * next()
     * remove()
     * forEachRemaining(Consumer<? super E> action) -- from Java8
     */

    @Test
    public void learn_Iterator() {
        ArrayList<Integer> arr = new ArrayList<>(List.of(1,2,3,4,5,6,7,8,9,10,11,12,13));
        Iterator<Integer> itr = arr.iterator();
        while(itr.hasNext()) {
            System.out.print(itr.next()+" ");
        }
        System.out.println();
        ListIterator<Integer> itrR = arr.listIterator(arr.size());
        while(itrR.hasPrevious()) {
            System.out.print(itrR.previous()+" ");
        }
        System.out.println();

        itr = arr.iterator();
        System.out.println(itr.next());
        System.out.println(itr.next());
        itr.remove();
        System.out.println(itr.next());
        itr = arr.iterator();
        while(itr.hasNext()) System.out.print(itr.next()+" ");
        System.out.println();

        System.out.println("For each remaining");
        itr = arr.iterator();
        itr.forEachRemaining(val -> System.out.print(val+" "));
    }

    /**
     * sort(List<T> list)
     * Collections.sort(List<T> t)
     * Comparator.reverseOrder()
     */

    @Test
    public void learn_Sorting() {

    }
}
