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
        TreeSet<Integer> set= new TreeSet<>();
        set.add(3);
        List<Integer> elementsToAdd = List.of(3,5,4,2,6);
        set.addAll(elementsToAdd);
        System.out.println(set);
        System.out.println(set.contains(3));
        System.out.println(set.contains(7));
        System.out.println(set.first());
        System.out.println(set.last());

        Set<Integer> subset = set.subSet(0,4);
        Set<Integer> headset = set.headSet(3);
        Set<Integer> tailset = set.tailSet(3);

        set.remove(5);
        System.out.println(set.size());
        System.out.println(set.isEmpty());

    }
}
