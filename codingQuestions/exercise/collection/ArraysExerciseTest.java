package com.chuwa.exercise.collection;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * @author b1go
 * @date 6/12/22 4:48 PM
 */
public class ArraysExerciseTest {

    /**
     * e.g.
     * int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
     * numbers[?]
     *
     * numbers[?] = #
     */

    @Test
    public void learn_Inserting_And_Retrieving() {
        int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int element = numbers[3];
        assertEquals(4, element);

        //insert
        numbers[8] = 12;
        assertEquals(12, numbers[8]);
    }

    /**
     * binarySearch()
     * e.g.
     * Arrays.binarySearch(numbers, 4);
     *
     * sort(array)
     * sort(array, fromIndex, toIndex)
     * e.g.
     * Arrays.sort(numbers);
     *
     * Arrays.parallelSort(numbers);
     */
    @Test
    public void learn_search_and_sort() {
        int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        Arrays.sort(numbers);
        int index = Arrays.binarySearch(numbers, 4);
        assertEquals(3, index);

        // sort in ascending order
        Arrays.sort(numbers);

        // sort a specific range
        Arrays.sort(numbers, 2, 8);

        // Parallel sort
        Arrays.parallelSort(numbers);

    }

    /**
     * copyOf()
     * e.g.
     * Arrays.copyOf(numbers, numbers.length);
     *
     * copyOfRange()
     * e.g.
     * Arrays.copyOfRange(numbers, 0, 5);
     */
    @Test
    public void learn_copy_of_array() {
        int[] numbers = {1, 2, 3, 4, 5};
        int[] copy = Arrays.copyOf(numbers, numbers.length);
        assertArrayEquals(numbers, copy);

        // copy a specific range
        int[] copyRange = Arrays.copyOfRange(numbers, 0, 3);
        assertEquals(new int[]{1,2,3}, copyRange);
    }

    /**
     * asList()
     * e.g.
     * List<Integer> list = Arrays.asList(numbers);
     *
     * equals()
     * e.g.
     * Arrays.equals(numbers1, numbers2);
     *
     * fill()
     * e.g.
     * Arrays.fill(numbers, 20);
     *
     */

    @Test
    public void learn_common_operations() {
        int[] numbers1 = { 1, 2, 3 };
        int[] numbers2 = { 1, 2, 3 };
        int[] numbers = { 1, 2, 3, 4, 5 };

        // Convert an array to a List
        List<Integer> list = Arrays.asList(1, 2, 3);

        assertTrue(Arrays.equals(numbers1, numbers2));

        // Fill the array with a specific value
        Arrays.fill(numbers, 20);
        assertArrayEquals(new int[]{20, 20, 20, 20, 20}, numbers);
    }
}
