package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.Arrays;
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
        Set<Integer> d = new HashSet<>();
        d.add(1);
        d.add(2);
        d.addAll(Arrays.asList(3,4));
        System.out.println(d);
        System.out.println(d.contains(1));
        System.out.println(d.remove(1));
        d.clear();
        System.out.println(d);
        System.out.println(d.isEmpty());
    }
}
