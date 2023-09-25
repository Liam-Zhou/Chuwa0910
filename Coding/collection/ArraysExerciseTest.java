package com.chuwa.exercise.collection;

import org.junit.Test;

import com.fasterxml.jackson.databind.type.ArrayType;

import java.util.*;

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

        int [] nums = {1,2,3,4,5,6,7,8,9,10};


        int a = nums[5];
        System.out.println(a);



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

        int [] nums = {4,7,11,2,9,5};
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));

        int a = Arrays.binarySearch(nums,11);
        System.out.println(a);

        int [] new_nums = {3,7,1,9,11,2};
        Arrays.parallelSort(new_nums);
        System.out.println(Arrays.toString(new_nums));

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

        int [] nums = {1,2,3,4,5,6,7};
        
        int[] arr = Arrays.copyOf(nums,5);
        System.out.println(Arrays.toString(arr));

        int[] new_arr = Arrays.copyOfRange(arr, 2, 4);
        System.out.println(Arrays.toString(new_arr));



    }

    /**
     * asList(c
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

        Integer []num = {2,4,6,5,1};
        List<Integer> list = Arrays.asList(num);
        System.out.println(list);

        int []nums1 = {1,3,5};
        int []nums2 = {1,3,5};
        System.out.println(Arrays.equals(nums1, nums2));

        int[] nums = new int[3];
        Arrays.fill(nums, 1, 3, 2);
        System.out.println(Arrays.toString(nums));





        


    }
}
