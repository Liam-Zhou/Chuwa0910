package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

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
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        System.out.println(numbers[4]);

        numbers[0] = 5;
        System.out.println(Arrays.toString(numbers));
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
        int[] numbers = {10, 5, 8, 3, 1, 7, 2, 9, 6, 4};

        System.out.println(Arrays.binarySearch(numbers, 4));

        Arrays.sort(numbers);
        System.out.println(Arrays.toString(numbers));

        Arrays.parallelSort(numbers);
        System.out.println(Arrays.toString(numbers));
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

        System.out.println(Arrays.toString(Arrays.copyOf(numbers, numbers.length)));

        System.out.println(Arrays.toString(Arrays.copyOfRange(numbers, 0, 3)));
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
        Integer[] numbers1 = {1, 2, 3, 4, 5};
        Integer[] numbers2 = {1, 2, 3, 4, 5};

        List<Integer> list = Arrays.asList(numbers1);
        System.out.println(list);

        System.out.println(Arrays.equals(numbers1, numbers2));

        Arrays.fill(numbers1, 20);
        System.out.println(Arrays.toString(numbers1));
    }
}
