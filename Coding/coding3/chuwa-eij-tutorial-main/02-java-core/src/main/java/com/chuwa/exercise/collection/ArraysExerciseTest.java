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
        int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        // Retrieving
        System.out.println("Element at index 5: " + numbers[5]);

        // Inserting/Updating
        numbers[5] = 20;
        System.out.println("Updated element at index 5: " + numbers[5]);
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
        int[] numbers = { 10, 3, 7, 1, 8, 2, 6, 5, 9, 4 };

        // Binary Search
        int index = Arrays.binarySearch(numbers, 4);
        System.out.println("Position of 4 before sort: " + index);  // It might return a negative value due to unsorted array

        // Sort
        Arrays.sort(numbers);
        System.out.println("Sorted array: " + Arrays.toString(numbers));

        index = Arrays.binarySearch(numbers, 4);
        System.out.println("Position of 4 after sort: " + index);

        // Partial Sort
        Arrays.sort(numbers, 2, 7);
        System.out.println("Partially sorted array: " + Arrays.toString(numbers));

        // Parallel Sort
        Arrays.parallelSort(numbers);
        System.out.println("Array after parallel sort: " + Arrays.toString(numbers));
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
        int[] numbers = { 1, 2, 3, 4, 5 };

        // Copy Of
        int[] copiedNumbers = Arrays.copyOf(numbers, numbers.length);
        System.out.println("Copied array: " + Arrays.toString(copiedNumbers));

        // Copy Of Range
        int[] rangeCopied = Arrays.copyOfRange(numbers, 1, 4);
        System.out.println("Copied array of range (1 to 4): " + Arrays.toString(rangeCopied));
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
        int[] numbers = { 1, 2, 3, 4, 5 };
        int[] numbers2 = { 1, 2, 3, 4, 5 };
        int[] numbers3 = { 6, 7, 8, 9, 10 };

        // As List
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);  // Note: Don't use primitive arrays with asList
        System.out.println("List from array: " + list);

        // Equals
        System.out.println("Is numbers equal to numbers2? " + Arrays.equals(numbers, numbers2));
        System.out.println("Is numbers equal to numbers3? " + Arrays.equals(numbers, numbers3));

        // Fill
        Arrays.fill(numbers, 20);
        System.out.println("Array after filling with 20: " + Arrays.toString(numbers));
    }
}
