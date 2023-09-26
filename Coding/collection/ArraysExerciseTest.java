package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.ArrayList;
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
        int[] nums = {1,2,3,4};
        System.out.println(nums[1]);
        nums[1] = 5;
        System.out.println(nums[1]);

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
        int[] nums = {4,2,1,3};
        System.out.println(Arrays.binarySearch(nums, 2));// return index number
        Arrays.sort(nums);
        //ArrayList<Integer> list = new ArrayList<>();
        for(int num: nums) {
            //list.add(num);
            System.out.println(num);
        }
        //System.out.println(list);

        int[] nums2 = {4,2,1,3};
        Arrays.sort(nums2, 1, 3);
        for(int num: nums2) {
            //list.add(num);
            System.out.println(num);
        }

        int[] nums3 = {4,2,1,3};
        Arrays.parallelSort(nums3);
        Arrays.stream(nums3).forEach(n -> System.out.println(n));
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
        int[] nums = {4,2,1,3};
        int[] nums2 = Arrays.copyOf(nums, nums.length);
        Arrays.stream(nums2).forEach(n -> System.out.println(n));

        int[] nums3 = Arrays.copyOfRange(nums,0, 2); //don't include [2]
        System.out.println("nums3");
        Arrays.stream(nums3).forEach(n -> System.out.println(n));
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
        Integer[] nums = {4,2,3,1};
        List<Integer> list = Arrays.asList(nums);//Arrays.asList expects an array of reference types (objects)
                                                // not primitive types
        Integer[] nums2 = {2,4,1,3};
        List<Integer> list2 = Arrays.asList(nums);
        System.out.println(Arrays.equals(nums, nums2));

        int[] nums3 = {4,2,3,1};
        Arrays.fill(nums3, 8);
        Arrays.stream(nums3).forEach(n -> System.out.println(n));

    }
}
