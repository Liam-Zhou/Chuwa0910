package kechen;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class ArraysExerciseTest {

    @Test
    public void learn_Inserting_And_Retrieving() {
        /**
         * e.g.
         * int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
         * numbers[?]
         */
        int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        System.out.println(numbers[0]);       // 1

        /**
         * numbers[?] = #
         */
        numbers[0] = 80;
        System.out.println(Arrays.toString(numbers));  // [80, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    }


    @Test
    public void learn_search_and_sort() {
        /**
         * binarySearch()
         * e.g.
         * Arrays.binarySearch(numbers, 4);
         */
        int[] numbers = {1, 6, 3, 8, 2, 9, 4, 7, 5, 10};
        int index = Arrays.binarySearch(numbers, 4); // Searches for the index of value 4
        System.out.println("Index of value 4: " + index);      // Index of value 4: -6

        /**
         * sort(array)
         * sort(array, fromIndex, toIndex)
         * e.g.
         * Arrays.sort(numbers);
         */
        Arrays.sort(numbers);
        System.out.println(Arrays.toString(numbers));    // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

        int[] numbers1 = {1, 6, 3, 8, 2, 9, 4, 7, 5, 10};
        Arrays.sort(numbers1, 2, 7);
        System.out.println(Arrays.toString(numbers1));   // [1, 6, 2, 3, 4, 8, 9, 7, 5, 10]

        /**
         * Arrays.parallelSort(numbers);
         */
        int[] numbers2 = {1, 6, 3, 8, 2, 9, 4, 7, 5, 10};
        Arrays.parallelSort(numbers2, 5, 7);
        System.out.println(Arrays.toString(numbers2));   // [1, 6, 3, 8, 2, 4, 9, 7, 5, 10]

    }

    @Test
    public void learn_copy_of_array() {
        /**
         * copyOf()
         * e.g.
         * Arrays.copyOf(numbers, numbers.length);
         */
        int[] numbers = {1, 6, 3, 8, 2, 9, 4, 7, 5, 10};

        int[] copyNumbers1 = Arrays.copyOf(numbers, numbers.length);
        System.out.println(Arrays.toString(copyNumbers1));

        /**
         * copyOfRange()
         * e.g.
         * Arrays.copyOfRange(numbers, 0, 5);
         */
        int[] copyNumbers2 = Arrays.copyOfRange(numbers, 0,3);
        System.out.println(Arrays.toString(copyNumbers2));

    }


    @Test
    public void learn_common_operations() {
        /**
         * asList()
         * e.g.
         * List<Integer> list = Arrays.asList(numbers);
         */
        Integer[] numbers = {1, 6, 3, 8, 2, 9, 4, 7, 5, 10};
        List<Integer> list = Arrays.asList(numbers);
        System.out.println(list);    // [1, 6, 3, 8, 2, 9, 4, 7, 5, 10]

        /**
         * equals()
         * e.g.
         * Arrays.equals(numbers1, numbers2);
         */
        int[] numbers1 = {1, 6, 3, 8, 2, 9, 4, 7, 5, 10};
        int[] numbers2 = {1, 2, 3};
        System.out.println(Arrays.equals(numbers1, numbers2));   // false
        /**
         * fill()
         * e.g.
         * Arrays.fill(numbers, 20);
         * Fill an array with a specific value
         */
        Arrays.fill(numbers2, 20);
        System.out.println(Arrays.toString(numbers2));   // [20, 20, 20]

    }
}
