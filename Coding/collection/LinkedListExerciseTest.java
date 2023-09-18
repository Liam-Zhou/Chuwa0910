package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


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

        System.out.println(list);

        list.add(1);
        System.out.println(list);

        list.addLast(2);
        System.out.println(list);

        list.addFirst(0);
        System.out.println(list);

        list.add(2, 3);
        System.out.println(list);

        List<Integer> anotherList = new LinkedList<>();
        anotherList.add(4);
        anotherList.add(5);
        list.addAll(anotherList);
        System.out.println(list);

        list.addAll(1, anotherList);
        System.out.println(list);

        System.out.println(list.getFirst());
        System.out.println(list.getLast());
        System.out.println(list.get(2));
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

        list.add(1);
        list.add(2);
        list.add(5);
        list.add(4);
        list.add(4);
        list.add(5);
        list.add(2);

        System.out.println(list);

        list.removeFirst();
        System.out.println(list);

        list.removeLast();
        System.out.println(list);

        list.remove(2);
        System.out.println(list);

        list.remove(Integer.valueOf(2));
        System.out.println(list);

        list.removeLastOccurrence(5);
        System.out.println(list);

        Collections.sort(list);
        System.out.println(list);
    }
}
