package com.chuwa.exercise.collection;

import org.junit.Test;

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
        set.add(2);
        set.add(8);
        set.add(4);
        set.add(6);
        Set<Integer> set2 = new HashSet<>();
        set2.add(2);
        set2.add(3);

        set.addAll(set2);
        set.remove(3);
        System.out.println(set);
        System.out.println(set.contains(3));
        set.clear();
        System.out.println(set);
        System.out.println(set.isEmpty());

    }
}
