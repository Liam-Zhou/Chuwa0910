package com.chuwa.exercise.collection;

import com.sun.source.tree.NewArrayTree;
import org.junit.Test;
import java.util.*;

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
        Set<Integer> newSet = new HashSet<>();
        newSet.add(2);
        set.addAll(newSet);

        set.contains(1);
        set.remove(1);
        set.clear();

        set.isEmpty();

    }
}
