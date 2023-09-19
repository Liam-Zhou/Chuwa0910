package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.*;
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
        TreeSet<Integer> set = new TreeSet<>();
        set.add(3);
        set.addAll(List.of(2,1,3,4,5,6,7,10,9,8));
        if(set.contains(1)) {
            System.out.println(set.first());
            System.out.println(set.last());
        }
        System.out.println(set.subSet(1,20));
        System.out.println(set.headSet(5));
        System.out.println(set.tailSet(5));

        set.remove(10);
        set.remove(11);

        if(!set.isEmpty()){
            System.out.println(set.size());
        }


        TreeSet<String> set1 = new TreeSet<String>(List.of("a", "ab", "ac", "ad"));
        System.out.println(set1.subSet("a","b"));
        System.out.println(set1.headSet("ae"));
    }
}
