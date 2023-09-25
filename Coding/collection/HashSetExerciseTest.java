package com.chuwa.exercise.collection;

import org.junit.Test;

import java.sql.Array;
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
        HashSet <Integer> set = new HashSet<>();

        set.add(3);

        Collection <Integer> col= new ArrayList<>(Arrays.asList(5,9));

        set.addAll(col);
        System.out.println(set);

        
        System.out.println(set.contains(9));

        set.remove(5);
        System.out.println(set);

        set.clear();
        System.out.println(set);

        
        System.out.println(set.isEmpty());


        
        



            
        };

    }

