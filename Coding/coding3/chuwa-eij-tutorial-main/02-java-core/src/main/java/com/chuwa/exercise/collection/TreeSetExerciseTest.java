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
        Set<Integer> set = new TreeSet<>();

        // add elements
        set.add(10);
        set.add(20);
        set.add(30);
        set.add(40);
        System.out.println("TreeSet after adding individual elements: " + set);

        // addAll elements
        set.addAll(Arrays.asList(50, 60, 70));
        System.out.println("TreeSet after adding a collection: " + set);

        // contains
        System.out.println("Does the set contain 30? " + set.contains(30));
        System.out.println("Does the set contain 100? " + set.contains(100));

        // first
        System.out.println("First element in the set: " + ((TreeSet<Integer>) set).first());

        // last
        System.out.println("Last element in the set: " + ((TreeSet<Integer>) set).last());

        // subSet
        System.out.println("Subset from 20 to 60: " + ((TreeSet<Integer>) set).subSet(20, 60));

        // headSet
        System.out.println("HeadSet up to 40: " + ((TreeSet<Integer>) set).headSet(40));

        // tailSet
        System.out.println("TailSet from 40: " + ((TreeSet<Integer>) set).tailSet(40));

        // remove
        set.remove(50);
        System.out.println("TreeSet after removing 50: " + set);

        // size
        System.out.println("Size of the set: " + set.size());

        // isEmpty
        System.out.println("Is the set empty? " + set.isEmpty());
    }
}
