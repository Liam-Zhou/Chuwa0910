package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.*;
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
        set.add(1);
        set.addAll(List.of(1,2,3));

        if(set.contains(1)){
            set.remove(1);
            set.clear();
        }

        if(set.isEmpty()) {
            System.out.println("the set is empty");
        }
    }
}
