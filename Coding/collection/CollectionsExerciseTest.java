package com.chuwa.exercise.collection;

import com.chuwa.tutorial.t08_multithreading.c03_syncronized.SynchronizedThreads;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(99);
        int min = Collections.min(list);
        System.out.println(min);

        int max = Collections.max(list);
        System.out.println(max);

        int fre = Collections.frequency(list, 2);
        System.out.println(fre);
    }

    /**
     * synchronizedList()
     */

    @Test
    public void learn_thread_safe_ArrayList() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(99);

        List<Integer> sl = Collections.synchronizedList(list);
        System.out.println(sl);

    }
}
