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
        int[] nums = {1,2,3};
        System.out.println(nums[0]);

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
        int[] nums = {9, 5, 1, 7, 3, 6, 2, 4, 8};
        Arrays.sort(nums);
        System.out.println(nums);
        int[] nums2 = {9, 5, 1, 7, 3, 6, 2, 4, 8};
        // Test sort(array, fromIndex, toIndex)
        Arrays.sort(nums2, 2, 6); // This will sort elements from index 2 (inclusive) to 6 (exclusive)
        System.out.println(Arrays.toString(nums2));

        int index = Arrays.binarySearch(nums, 4);
        if(index >= 0) {
            System.out.println("Found 4 at index: " + index);
        } else {
            System.out.println("4 not found in numbers array.");
        }

        int[] nums3 = {45, 24, 12, 78, 54, 39, 67, 32};
        Arrays.parallelSort(nums3);
        System.out.println(Arrays.toString(nums3));
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
        int[] nums = {1,2,3};
        int[] tem = Arrays.copyOf(nums,3);
        System.out.println(Arrays.toString(tem));
        System.out.println(Arrays.toString(Arrays.copyOfRange(nums,0,2)));
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
        Integer[] nums = {1,2,3};
        int[] nums2 = {1,2};
        int[] nums3 = {1,2};
        List<Integer> list = Arrays.asList(nums);
        System.out.println(list);
        System.out.println(Arrays.equals(nums2,nums3));
        Arrays.fill(nums2,20);
        System.out.println(Arrays.toString(nums2));
    }
}
