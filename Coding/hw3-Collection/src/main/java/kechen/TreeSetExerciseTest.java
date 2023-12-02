package kechen;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetExerciseTest {
    /**
     * e.g.
     * Set<Integer> set= new TreeSet<>();
     *
     * add(E e)
     * addAll(Collection<> c)
     *
     * contains(Object o)
     *
     * first()
     * last()
     * subSet(E fromElement, E toElement)
     * headSet(E toElement)
     * tailSet(E fromElement)
     *
     * remove(Object o)
     *
     * size()
     * isEmpty()
     *
     *
     */

    @Test
    public void learn_Inserting_And_Retrieving_Removing() {
        TreeSet<Integer> set = new TreeSet<>();

        // add(E e)
        set.add(0);
        set.add(1);
        set.add(2);
        set.add(3);
        System.out.println(set);  // [0, 1, 2, 3]

        //addAll(Collection<> c)
        HashSet<Integer> number = new HashSet<>();
        number.add(4);
        number.add(5);
        set.addAll(number);
        System.out.println(set);  // [0, 1, 2, 3, 4, 5]

        //contains()
        System.out.println(set.contains(8));   // false

        // Get the first element
        System.out.println(set.first());  // 0

        // Get the last element
        System.out.println(set.last());   // 5

        // Get a subset of elements
        System.out.println(set.subSet(0, 2));  // [0, 1]

        // Get a head set of elements
        /*
        NavigableSet<E> headSet(E toElement, boolean inclusive)
        - toElement: The upper bound element. The headSet view will include all elements less than this element.
        - inclusive: If true, the view includes the element equal to toElement.
                     If false, the view does not include the element equal to toElement.
         */
        System.out.println(set.headSet(3, true));  // [0, 1, 2, 3]

        /*
        NavigableSet<E> tailSet(E fromElement, boolean inclusive)
        - fromElement: The lower bound element. The tailSet view will include all elements greater than or equal to this element.
        - inclusive: If true, the view includes the element equal to fromElement.
                     If false, the view does not include the element equal to fromElement.
         */
        // Get a tail set of elements
        System.out.println(set.tailSet(2, true));  // [2, 3, 4, 5]

        // Remove an element
        set.remove(2);
        System.out.println(set);   // [0, 1, 3, 4, 5]

        // Get the size of the TreeSet
        System.out.println(set.size());   // 5

        // Check if the TreeSet is empty
        System.out.println(set.isEmpty());   // false


    }
}
