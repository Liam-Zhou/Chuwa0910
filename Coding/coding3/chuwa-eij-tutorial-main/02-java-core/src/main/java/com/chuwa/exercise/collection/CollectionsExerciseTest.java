package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.ArrayList;
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
        List<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(3);
        numbers.add(8);
        numbers.add(2);
        numbers.add(9);

        // Finding minimum value without comparator
        System.out.println("Min value without comparator: " + Collections.min(numbers));

        // Finding minimum value with comparator
        System.out.println("Min value with comparator: " + Collections.min(numbers, Comparator.reverseOrder()));

        // Finding maximum value without comparator
        System.out.println("Max value without comparator: " + Collections.max(numbers));

        // Finding maximum value with comparator
        System.out.println("Max value with comparator: " + Collections.max(numbers, Comparator.reverseOrder()));

        // Frequency of a value
        System.out.println("Frequency of 3: " + Collections.frequency(numbers, 3));
    }

    /**
     * synchronizedList()
     */

    @Test
    public void learn_thread_safe_ArrayList() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);

        // Making ArrayList thread-safe
        List<Integer> synchronizedNumbers = Collections.synchronizedList(numbers);

        System.out.println("Synchronized list: " + synchronizedNumbers);
    }
}
