
import org.junit.Test;

import java.util.ArrayList;
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
        LinkedList<Integer> list = new LinkedList<>(); //List<Integer> list cannot resolve addLast() function.
        list.add(1);
        list.add(99);
        list.addLast(109);
        list.addFirst(-1);
        list.add(3, 3);
        List<Integer> list2 = new LinkedList<>();
        list2.add(1000);
        list2.add(2000);
        list.addAll(list2);
        System.out.println(list); // insert at the end; [-1, 1, 99, 3, 109, 1000, 2000]
        list.addAll(2, list2); // index means insert all element of list2 into list at specific position.
        System.out.println(list); // [-1, 1, 1000, 2000, 99, 3, 109, 1000, 2000]

        //retrieving
        System.out.println(list.getFirst());
        System.out.println(list.getLast());
        System.out.println(list.get(4));
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
        LinkedList<Integer> list = new LinkedList<>(); //List<Integer> list cannot resolve addLast() function.
        list.add(1);
        list.add(99);
        list.addLast(109);
        list.addFirst(-1);
        list.add(3, 3);

        list.removeFirst();
        list.removeLast();
        list.remove(0);

        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
        //[99, 3]
        //[3, 99]
    }
}
