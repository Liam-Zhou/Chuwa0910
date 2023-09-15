package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.HashSet;
import java.util.List;

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
        HashSet<Integer> set= new HashSet<>();
        set.add(1);
        set.add(2);
        List<Integer> elementsToAdd = List.of(2,3,4,5,6);
        set.addAll(elementsToAdd);
        System.out.println(set);
        System.out.println(set.contains(1));
        System.out.println(set.contains(9));

        set.remove(1);
        set.removeIf(integer -> integer>3);
        System.out.println(set.contains(9));

        System.out.println(set.isEmpty());
        set.clear();
        System.out.println(set.isEmpty());
    }
}
