package com.chuwa.exercise.collection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;

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
        // Create a list of integers
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(1);
        list.add(5);
        list.add(2);
        list.add(4);

        // Find the minimum element in the list
        int min = Collections.min(list);
        assertEquals(1, min);

        // Find the maximum element in the list
        int max = Collections.max(list);
        assertEquals(5, max);

        // Count the frequency of an element in the list
        int frequency = Collections.frequency(list, 2);
        assertEquals(1, frequency);
    }

    /**
     * synchronizedList()
     */

    @Test
    public void learn_thread_safe_ArrayList() {
        // Create an ArrayList
        List<String> arrayList = new ArrayList<>();

        // Make the ArrayList thread-safe using synchronizedList
        List<String> synchronizedList = Collections.synchronizedList(arrayList);
    }
}
