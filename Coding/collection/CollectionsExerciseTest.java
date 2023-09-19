package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
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
        List<Integer> nums = Arrays.asList(9, 5, 1, 7, 3, 6, 2, 4, 8);
        System.out.println("Minimum value in numbers: " + Collections.min(nums));

        int reference = 5;
        System.out.println("Minimum value based on distance from 5: " + Collections.min(nums,
                Comparator.comparingInt(num -> Math.abs(num - reference))));

        // Test Collections.max(list)
        System.out.println("Maximum value in numbers: " + Collections.max(nums));

        // Test max(Collection c, Comparator comp)
        // Using a custom comparator to find the max based on absolute difference from 5
        System.out.println("Maximum value based on distance from 5: " + Collections.max(nums,
                Comparator.comparingInt(num -> Math.abs(num - reference))));

        // Test frequency(Collection c, object o)
        List<String> fruits = Arrays.asList("apple", "banana", "apple", "orange", "apple");
        System.out.println("Frequency of 'apple' in fruits: " + Collections.frequency(fruits, "apple"));
    }

    /**
     * synchronizedList()
     */

    @Test
    public void learn_thread_safe_ArrayList() {

    }
}
