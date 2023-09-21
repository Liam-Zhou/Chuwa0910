package com.chuwa.exercise.collection;
import java.util.Set;
import java.util.TreeSet;
import org.junit.Test;

/**
 * @author b1go
 * @date 6/12/22 4:46 PM
 */
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
        //create a TreeSet
        TreeSet<Integer> set = new TreeSet<>();
        set.add(3);
        set.add(5);
        set.add(8);

        boolean contains = set.contains(3);

        // get the first and last elements
        Integer firstElement = set.first();
        Integer lastElement = set.last();

        // get a subset of elements
        Set<Integer> subSet = set.subSet(3, 8); // should contain 3,5

        // get elements less than a specified element
        Set<Integer> headSet = set.headSet(5); // should contain [3]

        // get elements greater than or equal to a specified element
        Set<Integer> tailSet = set.tailSet(5); // should contains [5, 8]

        // remove an element
        set.remove(5);

        // get the size of the TreeSet
        int size = set.size();

        // check if the TreeSet is empty
        boolean isEmpty = set.isEmpty();

    }
}
