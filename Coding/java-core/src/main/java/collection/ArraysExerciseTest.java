package collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.EnumSet;
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
        int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(numbers[2]);
        numbers[2] = 4;
        System.out.println(numbers[2]);
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
        int[] numbers = {10, 3, 7, 1, 5, 9, 2, 4, 8, 6};
        Arrays.sort(numbers);
        int elementToSearch = 4;
        int index = Arrays.binarySearch(numbers, elementToSearch);
        System.out.println(index);

        // Sorting a specific range of the array
        int[] partialArray = {5, 2, 8, 1, 7};
        Arrays.sort(partialArray, 1, 4); // Sort from index 1 (inclusive) to 4 (exclusive)
        for (int element : partialArray) {
            System.out.print(element);
        }
        System.out.println();

        int[] parallelSortArray = {3, 7, 1, 5, 9, 2, 4, 8, 6};
        Arrays.parallelSort(parallelSortArray);

        // Assertions for sorted arrays
        for (int element : numbers) {
            System.out.print(element);
        }
        System.out.println();
        for (int element : partialArray) {
            System.out.print(element);
        }
        System.out.println();
        for (int element : parallelSortArray) {
            System.out.print(element);
        }
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
        int[] originalArray = {1, 2, 3, 4, 5};
        int[] copiedArray = Arrays.copyOf(originalArray, originalArray.length);
        System.out.println("Copied Array: " + Arrays.toString(copiedArray));
        int[] partialCopyArray = Arrays.copyOfRange(originalArray, 1, 4);
        System.out.println("Partial Copy Array: " + Arrays.toString(partialCopyArray));
        originalArray[2] = 10;
        System.out.println("Modified Original Array: " + Arrays.toString(originalArray));
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
        // Create an array of integers
        int[] numbers1 = {1, 2, 3, 4, 5};
        int[] numbers2 = {1, 2, 3, 4, 5};

        List<int[]> list = Arrays.asList(numbers1);

        boolean arraysEqual = Arrays.equals(numbers1, numbers2);
        System.out.println("Arrays are equal: " + arraysEqual);

        Arrays.fill(numbers1, 20);
        System.out.println("Filled numbers1 with 20");

        System.out.println("Modified numbers1: " + Arrays.toString(numbers1));

        System.out.println("First element of the list: " + list.get(0)[0]);
    }
}
