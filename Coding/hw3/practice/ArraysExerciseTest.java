import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class ArraysExerciseTest {

    private int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 99 };
    /**
     * e.g.
     * int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
     * numbers[?]
     *
     * numbers[?] = #
     */

    @Test
    public void learn_Inserting_And_Retrieving() {
        System.out.println(nums[3]);
        nums[3] = 99;
        System.out.println(nums[3]);
        System.out.println(nums[4]);

    }

    /**
     * binarySearch()
     * e.g.
     * Arrays.binarySearch(numbers, 4);
     *s
     * sort(array)
     * sort(array, fromIndex, toIndex)
     * e.g.
     * Arrays.sort(numbers);
     *
     * Arrays.parallelSort(numbers);
     */
    @Test
    public void learn_search_and_sort() {
        int index = Arrays.binarySearch(nums, 99);
        System.out.println(index);  // 10
        Arrays.sort(nums, 1,3);
        Arrays.sort(nums);  // faster when size is small. Speed degrades when size is large.
        Arrays.parallelSort(nums); // NEW in java 8.
        // When size is large (>8192), it uses multi thread that split array into sub-array and do sorting

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
        int[] copyArray = Arrays.copyOf(nums, nums.length);
        System.out.println(copyArray.length);
        for(int a:copyArray){
            System.out.print(a+" ");
        }
        System.out.println();

        int[] copy2 = Arrays.copyOf(nums, nums.length+10);
        System.out.println(copy2.length);
        for(int a:copy2){
            System.out.print(a+" ");
        }
        System.out.println();   // 1 2 3 4 5 6 7 8 9 10 99 0 0 0 0 0 0 0 0 0 0
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
        System.out.println(Arrays.asList(nums).size());

        //List<Integer> list = Arrays.asList(nums); error.  why?
        //or
        List<int[]> list = Arrays.asList(nums);

        int[] a1 = new int[]{1,2,3,4,5,5,6,7,8,8,9,10};
        int[] a2 = new int[]{1,2,3,4,5,5,8,8,6,7,9,10};
        Boolean equal = Arrays.equals(a1,a2);
        System.out.println(equal); // false
        Arrays.parallelSort(a1);
        Arrays.sort(a2);
        System.out.println(Arrays.equals(a1,a2)); // true, equals() 会比较顺序

        //fill() means fill the spot with a number
        //range available [l,r)
        Arrays.fill(nums, 10);
        for(int a:nums){
            System.out.print(a+" ");
        } //10 10 10 10 10 10 10 10 10 10 10
        System.out.println();
        Arrays.fill(nums, 3,4, 999);
        for(int a:nums){
            System.out.print(a+" ");
        } //10 10 10 999 10 10 10 10 10 10 10
        System.out.println();

    }
}
