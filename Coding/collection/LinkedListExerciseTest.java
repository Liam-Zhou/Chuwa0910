package com.chuwa.exercise.collection;

import org.junit.Test;

import com.fasterxml.jackson.databind.type.ArrayType;

import java.util.*;

/**
 * @author b1go
 * @date 6/12/22 4:45 PM
 */
public class LinkedListExerciseTest {

    /**
     * e.g.
     * List<Integer> list = new LinkedList<Integer>();
     * Inserting:
     * add(E e) or addLast(E e)
     * addFirst(E e)
     * add(int index, E element)
     * addAll(Collection c)
     * addAll(int index, Collection c)
     *
     * Retrieving:
     * getFirst()
     * getLast()
     * get(int index)
     *
     */
    @Test
    public void learn_Inserting_And_Retrieving() {
        LinkedList <Integer> lst = new LinkedList<>();
        lst.add(1);
        lst.add(2);
        System.out.print(lst);


        lst.addFirst(0);
        System.out.print(lst);

        lst.add(3, 4);
        System.out.print(lst);

        Collection <Integer> lst2 = new LinkedList<>(Arrays.asList(5,6,7));
        lst.addAll(lst2);
        System.out.print(lst);

       Collection <Integer> lst3  = new LinkedList<>(Arrays.asList(8,9));
       lst.addAll(2, lst3);
       System.out.println(lst);

       int a = lst.getFirst();
       System.out.println(a);

       int b = lst.getLast();
       System.out.println(b);


       System.out.println("Value at idx 3 is:"+lst.get(3));



    }

    /**
     * removeFirst()
     * removeLast()
     * remove(int index)
     * remove(Object o)
     * removeLastOccurrence()
     *
     * sort()
     */

    @Test
    public void learn_Remove_Sort() {

        LinkedList <Integer> lst = new LinkedList<>(Arrays.asList(2,3,4,5));
        lst.removeFirst();
        System.out.println(lst);

        lst.removeLast();
        System.out.println(lst);

        lst.remove(0);
        System.out.println(lst);

        lst.remove(new Integer (4));
        System.out.println(lst);

        lst.add(5);
        lst.add(7);
        lst.add(1);
        lst.add(12);
        lst.sort(null);
        System.out.println(lst);




    }
}
