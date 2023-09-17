package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.Arrays;
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
        List<Integer> list = new LinkedList<Integer>();

        // Inserting
        list.add(5); // or addLast
        System.out.println("After add(5): " + list);

        ((LinkedList<Integer>) list).addFirst(3);
        System.out.println("After addFirst(3): " + list);

        list.add(1, 4);
        System.out.println("After add(1, 4): " + list);

        list.addAll(Arrays.asList(6, 7, 8));
        System.out.println("After addAll([6,7,8]): " + list);

        list.addAll(0, Arrays.asList(1, 2));
        System.out.println("After addAll(0, [1,2]): " + list);

        // Retrieving
        System.out.println("First item: " + ((LinkedList<Integer>) list).getFirst());
        System.out.println("Last item: " + ((LinkedList<Integer>) list).getLast());
        System.out.println("Item at index 2: " + list.get(2));
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
        List<Integer> list = new LinkedList<>(Arrays.asList(3, 5, 2, 7, 5, 8, 5));

        // Remove
        ((LinkedList<Integer>) list).removeFirst();
        System.out.println("After removeFirst(): " + list);

        ((LinkedList<Integer>) list).removeLast();
        System.out.println("After removeLast(): " + list);

        list.remove(1);
        System.out.println("After remove(1): " + list);

        list.remove(new Integer(7));
        System.out.println("After remove(7): " + list);

        ((LinkedList<Integer>) list).removeLastOccurrence(5);
        System.out.println("After removeLastOccurrence(5): " + list);

        // Sort
        list.sort(Integer::compareTo);
        System.out.println("After sort(): " + list);
    }
}
