package com.chuwa.exercise.collection;

import java.util.Arrays;

import org.junit.Test;

import java.util.*;

/**
 * @author b1go
 * @date 6/12/22 4:48 PM
 */
public class CollectionsExerciseTest {

    /**
     * Collections.min(list))
     * min(Collection c, Comparator comp)
     *
     * Collections.max(list)
     * max(Collection c, Comparator comp)
     *
     * frequency(Collection c, object o)
     */

    @Test
    public void learn_common_collections_operations() {

        List <Integer> lst = Arrays.asList(1,3,5,7,4,4);

        int Min = Collections.min(lst);
        System.out.println(Min);

        int Max = Collections.max(lst);
        System.out.println(Max);

        int count = Collections.frequency(lst, 4);
        System.out.println(count);





    }

    /**
     * synchronizedList()
     */

    @Test
    public void learn_thread_safe_ArrayList() {

        List<Integer> lst = new ArrayList<>(Arrays.asList(1,2,4,5,8));

        List<Integer> safe_lst = Collections.synchronizedList(lst);

        safe_lst.add(2,3);

        safe_lst.remove(new Integer (8));

        System.out.println(safe_lst);


    }
}
