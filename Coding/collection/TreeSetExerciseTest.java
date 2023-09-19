package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

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

        // add(E e)
        set.add(5);
        set.add(3);
        set.add(8);
        set.add(1);
        System.out.println("After adding elements: " + set);

        // addAll(Collection<> c)
        set.addAll(Arrays.asList(10, 2, 6));
        System.out.println("After adding more elements: " + set);

        // contains(Object o)
        System.out.println("Does set contain 3? " + set.contains(3));

        // first()
        System.out.println("First element: " + set.first());

        // last()
        System.out.println("Last element: " + set.last());

        // subSet(E fromElement, E toElement)
        System.out.println("Subset from 2 to 8: " + set.subSet(2, 8));

        // headSet(E toElement)
        System.out.println("HeadSet up to 5: " + set.headSet(5));

        // tailSet(E fromElement)
        System.out.println("TailSet from 5 onwards: " + set.tailSet(5));

        // remove(Object o)
        set.remove(5);
        System.out.println("After removing 5: " + set);

        // size()
        System.out.println("Size of set: " + set.size());

        // isEmpty()
        System.out.println("Is set empty? " + set.isEmpty());
    }
}
