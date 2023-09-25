package com.chuwa.exercise.collection;

import org.junit.Test;

import apple.laf.JRSUIUtils.Tree;

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

        TreeSet <Integer> set = new TreeSet<>();

        set.add(3);
        set.add(1);

        Collection <Integer> lst = new ArrayList<>(Arrays.asList(9,5,6,7));
        set.addAll(lst);
        System.out.println(set);

        System.out.println(set.contains(5));

        int a = set.first();
        System.out.println(a);

        int b = set.last();
        System.out.println(b);

        TreeSet<Integer> subset = (TreeSet<Integer>)set.subSet(3,7);
        System.out.println(subset);

        
        TreeSet<Integer> head_set = (TreeSet<Integer>)set.headSet(7);
        System.out.println(head_set);

        TreeSet<Integer> tail = (TreeSet<Integer>) set.tailSet(5);
        System.out.println(tail);

        set.remove(5);
        System.out.println(set);

        int c = set.size();
        System.out.println(c);

        System.out.println(set.isEmpty());






    }
}
