package com.chuwa.exercise.collection;
import java.util.LinkedList;
import java.util.List;
import org.junit.Test;

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
        list.add(1);
        list.addFirst(0);
        list.add(2);
        list.add(1, 1);
        list.addAll(List.of(3, 4, 5));
        list.addAll(3, List.of(6, 7));

        // Retrieve elements
        int firstElement = list.getFirst(); // Retrieves the first element
        int lastElement = list.getLast(); // Retrieves the last element
        int elementAtIndex = list.get(2); // Retrieves element at index 2

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
        // Create a LinkedList
        LinkedList<Integer> list = new LinkedList<>(List.of(3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5));

        // Removing elements
        list.removeFirst(); // Removes the first element
        list.removeLast(); // Removes the last element
        list.remove(3); // Removes element at index 3
        list.remove((Integer) 5); // Removes the first occurrence of value 5
        list.removeLastOccurrence((Integer) 5); // Removes the last occurrence of value 5

        // Sorting elements
        list.sort(null); // Sorts the list in natural order (ascending)
    }
}
