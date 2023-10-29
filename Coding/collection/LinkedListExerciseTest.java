package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.Collections;
import java.util.LinkedList;

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
        LinkedList<Integer> list = new LinkedList<>();
        list.add(4);
        list.add(3);
        list.addLast(1);
        System.out.println(list.getLast());
        list.addFirst(2);
        System.out.println(list.getFirst());
        list.add(1, 5);
        System.out.println(list);

        LinkedList<Integer> list2 = new LinkedList<>();
        list2.add(8);
        list2.add(7);

        list.addAll(3, list2);
        System.out.println(list);
        System.out.println(list.get(3));
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
        LinkedList<Integer> list = new LinkedList<>();
        list.add(4);
        list.add(3);
        list.addLast(1);
        System.out.println(list.getLast());
        list.addFirst(2);
        System.out.println(list.getFirst());
        list.add(1, 5);
        System.out.println(list);

        LinkedList<Integer> list2 = new LinkedList<>();
        list2.add(8);
        list2.add(7);
        list.addAll(3, list2);
        System.out.println(list);

        list.removeFirst();
        list.removeLast();
        list.remove(0);
        list.add(8);
        System.out.println(list);


        list.removeLastOccurrence(8);
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);

    }
}
