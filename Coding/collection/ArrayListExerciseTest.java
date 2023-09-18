package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.*;

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

        System.out.println("------------------Adding elements------------------");
        System.out.println(list.add("one string"));
        System.out.println(list.add("two string"));
        System.out.println(list.add("three string"));
        System.out.println(list.add("four string"));
        System.out.println(list.add("five string"));

        System.out.println("------------------Getting elements------------------");
        System.out.println(list.get(0));
        System.out.println(list.get(2));
        System.out.println(list.get(4));

        System.out.println("------------------Getting size------------------");
        System.out.println(list.size());

        System.out.println("------------------Adding another list------------------");
        List<String> list2 = new ArrayList<>();
        list2.add("another string");
        System.out.println(list2.addAll(list));
        System.out.println(list2.size());
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

        ArrayList<String> list = new ArrayList<>();

        list.add("one string");
        list.add("two string");
        list.add("three string");
        list.add("four string");
        list.add("five string");

        list.set(0, "new one");
        list.replaceAll(str -> str + "?");

        list.contains("new one");
        list.indexOf("new one?");
        list.lastIndexOf("five string?");

        list.remove(1);
        list.remove("five string");
//        list.removeRange(2, 3);
        list.removeAll(new ArrayList<>());
        list.clear();

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
        list.add("one string");
        list.add("two string");
        list.add("three string");
        list.add("four string");
        list.add("five string");

        // Get an iterator for the list
        Iterator<String> iterator = list.iterator();

        // Using iterator() and hasNext() to iterate over the list
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // Using remove() to remove an element while iterating
        iterator = list.iterator(); // Reset the iterator
        while (iterator.hasNext()) {
            String element = iterator.next();
            if (element.equals("five string")) {
                iterator.remove(); // Removes "Banana" from the list
            }
        }

        // Using forEachRemaining(Consumer<? super E> action) from Java 8
        iterator = list.iterator(); // Reset the iterator
        iterator.forEachRemaining(item -> System.out.println("Remaining: " + item));
    }

    /**
     * sort(List<T> list)
     * Collections.sort(List<T> t)
     * Comparator.reverseOrder()
     */

    @Test
    public void learn_Sorting() {
        List<String> list = new ArrayList<>();
        list.add("one string");
        list.add("two string");
        list.add("three string");
        list.add("four string");
        list.add("five string");

        // Sorting the list using sort() method
        Collections.sort(list);

        // Printing the sorted list
        System.out.println("Sorted List:");
        list.forEach(item -> System.out.println(item));

        // Sorting the list in reverse order using Collections.sort() and Comparator.reverseOrder()
        Collections.sort(list, Comparator.reverseOrder());

        // Printing the reverse sorted list
        System.out.println("Reverse Sorted List:");
        list.forEach(item -> System.out.println(item));
    }
}
