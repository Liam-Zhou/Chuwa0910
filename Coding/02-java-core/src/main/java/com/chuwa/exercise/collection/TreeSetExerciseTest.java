package com.chuwa.exercise.collection;

import org.junit.Test;
import java.util.*;

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
        TreeSet<Integer> set = new TreeSet<>();
        set.add(1);
        set.add(3);

        set.contains(1);
        Integer firstElement = set.first();
        Integer lastElement = set.last();
        Set<Integer> subSet = set.subSet(1, 3);
        Set<Integer> headSet = set.headSet(5);
        Set<Integer> tailSet = set.tailSet(5);

        set.remove(3);
        set.size();
        set.isEmpty();
    }
}
