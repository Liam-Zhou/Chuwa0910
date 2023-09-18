package com.chuwa.exercise.collection;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.function.UnaryOperator;
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
        System.out.println("New ArrayList created: " + list);

        // Testing add elements
        list.add("A");
        list.add("B");
        list.add("C");
        System.out.println(list);

        // Testing get element
        String elementAtPosition1 = list.get(1);
        System.out.println("Element at position 1: " + elementAtPosition1);

        // Testing get Size
        int size = list.size();
        System.out.println("Size of list: " + size);

        // Testing list.addAll(anotherList)
        List<String> anotherList = Arrays.asList("D", "E");
        list.addAll(anotherList);
        System.out.println("After adding another list (D and E): " + list);
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
        List<String> list = new ArrayList<>(Arrays.asList("A", "B", "C", "D", "E", "B"));

        list.remove(2); // Removing "C"
        System.out.println("After removing element at index 2: " + list);

        list.remove("A");
        System.out.println("After removing object A: " + list);

        list.removeAll(Arrays.asList("B", "D"));
        System.out.println("After removing all occurrences of B and D: " + list);

        list.clear();
        System.out.println("After clearing list: " + list);

        list.addAll(Arrays.asList("A", "B", "C", "D", "E", "B"));

        list.set(1, "X");
        System.out.println(list);

        // Test replaceAll(UnaryOperator<E> operator)
        list.replaceAll(s -> s.toLowerCase());
        System.out.println(list);

        // Test contains(Object o)
        System.out.println("Contains 'a': " + list.contains("a"));
        System.out.println("Contains 'z': " + list.contains("z"));

        // Test indexOf(Object o)
        System.out.println("Index of 'b': " + list.indexOf("b"));

        // Test lastIndexOf(Object o)
        System.out.println("Last index of 'b': " + list.lastIndexOf("b"));
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
        List<String> list = new ArrayList<>(Arrays.asList("A", "B", "C", "D", "E"));

        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        // Using iterator's remove()
        iterator = list.iterator();
        while(iterator.hasNext()) {
            if(iterator.next().equals("C")) {
                iterator.remove();
            }
        }
        System.out.println(list);

        // Test forEachRemaining(Consumer<? super E> action)
        iterator = list.iterator();
        iterator.forEachRemaining(item -> System.out.print(item + " "));
    }

    /**
     * sort(List<T> list)
     * Collections.sort(List<T> t)
     * Comparator.reverseOrder()
     */

    @Test
    public void learn_Sorting() {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(3,1,2));

        Collections.sort(list);
        System.out.println(list);
        list.sort(Comparator.reverseOrder());
        System.out.println(list);
    }
}
