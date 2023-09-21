package com.chuwa.exercise.collection;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/**
 * @author b1go
 * @date 6/12/22 4:43 PM
 */
public class ArrayListExerciseTest {
    /**
     * new ArrayList()
     * add elements
     * get element
     * get Size
     * list.addAll(anotherList)
     */
    @Test
    public void learn_Inserting_And_Retrieving() {
        List<String> list = new ArrayList<>();
        // Add elements
        list.add("Alice");
        list.add("Bob");
        list.add("Cathy");

        // get element
        String name = list.get(0);

        // get the size
        int size = list.size();

        // create another list
        List<String> list2 = new ArrayList<>();
        list2.add("Derrik");
        list2.add("Ethan");

        // Add all elements from list2 to list
        list.addAll(list2);
    }

    /**
     * remove(int index)
     * remove(Object o)
     * removeRange(int fromIndex, int toIndex)
     * removeAll(Collection<?> c)
     * clear()
     *
     * Update:
     * set(int index, E e)
     * replaceAll(UnaryOperator<E> operator)
     *
     * check:
     * contains(Object o)
     * indexOf(Object o)
     * lastIndexOf(Object o)
     */
    @Test
    public void learn_Remove_Replacing_Updating() {
        List<String> list = new ArrayList<>();
        list.add("Alice");
        list.add("bob");
        list.add("Cathy");

        // remove an elemtn
        list.remove(1);

        // remove an element by object
        list.remove("Alice");

        //clear the entire list
        list.clear();

        // update
        list.add("Apple");
        list.set(0, "Banana");

        // convert all to uppercase
        list.replaceAll(String::toUpperCase);

        //check if contains
        boolean containsBanana = list.contains("BANANA");

        // Find index
        int indexOfApple = list.indexOf("APPLE");

        // find the last index of an element
        int lastIndexOfApple = list.lastIndexOf("APPLE");
    }

    /**
     * iterator()
     * hasNext()
     * next()
     * remove()
     * forEachRemaining(Consumer<? super E> action) -- from Java8
     */

    @Test
    public void learn_Iterator() {
        List<String> list = new ArrayList<>();
        list.add("Alice");
        list.add("Bob");
        list.add("Cathy");

        // iterate through the list
        for (String name :list){
            System.out.println(name);
        }
    }

    /**
     * sort(List<T> list)
     * Collections.sort(List<T> t)
     * Comparator.reverseOrder()
     */

    @Test
    public void learn_Sorting() {
        List<String> list = new ArrayList<>();
        list.add("Alice");
        list.add("bob");
        list.add("cathy");

        //sort
        list.sort(null);

        // sort list in reverse order
        list.sort(java.util.Collections.reverseOrder());
    }
}
