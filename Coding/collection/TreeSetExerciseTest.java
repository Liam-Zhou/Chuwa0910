package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.Collection;
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

        set.add(3);
        set.add(1);
        set.add(2);
        System.out.println(set);

        Collection<Integer> collection = new TreeSet<>();
        collection.add(4);
        collection.add(5);
        set.addAll(collection);
        System.out.println(set);

        System.out.println(set.contains(2));

        System.out.println(((TreeSet<Integer>) set).first());

        System.out.println(((TreeSet<Integer>) set).last());

        System.out.println(((TreeSet<Integer>) set).subSet(2, 4));

        System.out.println(((TreeSet<Integer>) set).headSet(3));

        System.out.println(((TreeSet<Integer>) set).tailSet(3));

        set.remove(3);
        System.out.println(set);

        System.out.println(set.size());

        System.out.println(set.isEmpty());
    }
}
