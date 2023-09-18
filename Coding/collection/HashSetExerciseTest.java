package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * @author b1go
 * @date 6/12/22 4:46 PM
 */
public class HashSetExerciseTest {
    /**
     * e.g.
     * Set<Integer> set= new HashSet<>();
     *
     * add(E e)
     * addAll(Collection<> c)
     *
     * get()
     * contains()
     *
     * remove(Object o)
     * clear()
     *
     * isEmpty()
     *
     *
     */

    @Test
    public void learn_Inserting_And_Retrieving_Removing() {
        Set<Integer> set = new HashSet<>();

        set.add(1);
        set.add(2);
        set.add(3);
        System.out.println(set);

        Collection<Integer> collection = new HashSet<>();
        collection.add(4);
        collection.add(5);
        set.addAll(collection);
        System.out.println(set);

        System.out.println(set.contains(2));

        set.remove(3);
        System.out.println(set);

        set.clear();
        System.out.println(set.isEmpty());
    }
}
