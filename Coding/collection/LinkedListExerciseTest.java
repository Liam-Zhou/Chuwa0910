package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
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

        // Inserting elements:

        // add(E e) or addLast(E e)
        list.add(5); // [5]
        list.addLast(6); // [5, 6]

        // addFirst(E e)
        list.addFirst(4); // [4, 5, 6]

        // add(int index, E element)
        list.add(2, 8); // [4, 5, 8, 6]
        // addAll(Collection c)
        List<Integer> anotherList = Arrays.asList(1, 2, 3);
        list.addAll(anotherList); // [4, 5, 8, 6, 1, 2, 3]

        // addAll(int index, Collection c)
        list.addAll(0, anotherList); // [1, 2, 3, 4, 5, 8, 6, 1, 2, 3]

        // Printing the list after insertion operations
        System.out.println(list);

        int firstElement = ((LinkedList<Integer>) list).getFirst();
        System.out.println(firstElement); // Outputs: 1

        // getLast()
        int lastElement = ((LinkedList<Integer>) list).getLast();
        System.out.println(lastElement); // Outputs: 3

        // get(int index)
        int elementAtIndex2 = list.get(2);
        System.out.println(elementAtIndex2);
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
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 3, 7, 8, 9));
        // removeFirst()
        list.removeFirst();
        System.out.println(list);

        // removeLast()
        list.removeLast();
        System.out.println(list);

        // remove(int index)
        list.remove(4);
        System.out.println( list);

        // remove(Object o)
        list.remove(new Integer(5));
        System.out.println(list);

        // removeLastOccurrence()
        list.removeLastOccurrence(3);
        System.out.println(list);

        // sort()
        list.sort(Comparator.reverseOrder());
        System.out.println(list);
    }
}
