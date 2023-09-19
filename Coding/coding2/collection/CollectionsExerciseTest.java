package com.chuwa.exercise.collection;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
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
        list.add(3);
        list.add(1);
        list.add(4);
        list.add(2);
        list.add(5);
        list.add(6);
        list.add(2);
        System.out.println(Collections.max(list));
        System.out.println(Collections.min(list));
        int frequency = Collections.frequency(list, 2);
        System.out.println(frequency);
    }

    /**
     * synchronizedList()
     */

    @Test
    public void learn_thread_safe_ArrayList() {
        List<String> arrayList = Arrays.asList("2","3","4");
        List<String> synchronizedList = Collections.synchronizedList(arrayList);
        System.out.println(synchronizedList);
    }
}
