package collection;

import org.junit.Test;

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

        list.add(1);
        list.addFirst(0);
        list.add(2, 3);

        List<Integer> anotherList = new LinkedList<>();
        anotherList.add(4);
        anotherList.add(5);
        list.addAll(anotherList); // addAll(Collection c)

        list.addAll(2, anotherList); // addAll(int index, Collection c)

        Integer firstElement = list.getFirst(); // getFirst()
        Integer lastElement = list.getLast(); // getLast()
        Integer elementAtIndex = list.get(2); // get(int index)

        System.out.println("List after inserting: " + list);
        System.out.println("First element: " + firstElement);
        System.out.println("Last element: " + lastElement);
        System.out.println("Element at index 2: " + elementAtIndex);
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

        list.add(3);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(4);

        System.out.println("Original List: " + list);

        Integer removedFirst = list.removeFirst();
        Integer removedLast = list.removeLast();
        list.remove(1);
        list.remove(Integer.valueOf(3));
        list.removeLastOccurrence(Integer.valueOf(3));

        System.out.println("List after removal: " + list);

        list.sort((a, b) -> a.compareTo(b));

        System.out.println("List after sorting: " + list);

        // Print the results
        System.out.println("Removed First: " + removedFirst);
        System.out.println("Removed Last: " + removedLast);
    }
}
