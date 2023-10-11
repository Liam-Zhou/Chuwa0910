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
        Set<Integer> set = new HashSet<>();

        set.add(1);
        set.add(2);
        set.add(3);
        System.out.println("After adding individual elements: " + set);

        set.addAll(Arrays.asList(4, 5, 6));
        System.out.println("After adding collection: " + set);
        for (Integer number : set) {
            System.out.println(number);
        }

        set.remove(3);
        System.out.println("After removing 3: " + set);

        set.clear();

    }
}
