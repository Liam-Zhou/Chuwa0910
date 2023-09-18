package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
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
        int[] nums = {1,2,3,4,5,6,7,8,9,10};
        nums[0] = 10000;
        for(int num: nums) {
            System.out.println(num);
        }
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
        int[] nums = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(Arrays.binarySearch(nums,3));
        int[] nums1 = {1,4,3,2,10,6,7,5,9,8};
        Arrays.sort(nums1);
        for(int num: nums1) System.out.printf(num+" ");
        System.out.println();

        int[] nums2 = {1,4,3,2,10,6,7,5,9,8};
        Arrays.parallelSort(nums2);
        for(int num: nums2) System.out.printf(num + " ");
        System.out.println();
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
        int[] array = {1,2,3,4};
        int[] arr1 = Arrays.copyOf(array,10);
        for(int itr:arr1) System.out.printf(itr+" ");
        System.out.println();

        int[] arr2 = Arrays.copyOfRange(array,2,3);
        for(int itr: arr2) System.out.printf(itr+" ");
        System.out.println();
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
        int[] arr1 = {1,2,3};
        int[] arr2 = {1,2,3};

        List<int[]> list = Arrays.asList(arr1);
        System.out.println(Arrays.equals(arr1,arr2));


        Arrays.fill(arr1,20);
        for(int itr:arr1) System.out.printf(arr1 + " ");
        System.out.println();
    }
}
