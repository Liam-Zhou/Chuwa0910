package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author b1go
 * @date 6/12/22 4:46 PM
 */
public class CopyOnWriteArrayListExerciseTest {

    /**
     * e.g.
     * List list = new CopyOnWriteArrayList();
     *
     * add(E e)
     * add(int index, E element)
     * addAll(Collection c)
     * addIfAbsent(E e)
     * addAllAbsent(Collection c)
     */
    @Test
    public void learn_Inserting_And_Retrieving() {
        List<String> list = new CopyOnWriteArrayList<>();

        // add(E e)
        list.add("Apple");
        System.out.println("After adding Apple: " + list);

        // add(int index, E element)
        list.add(1, "Cherry");
        System.out.println("After adding Cherry at index 1: " + list);

        // addAll(Collection c)
        list.addAll(Arrays.asList("Banana", "Date", "Fig"));
        System.out.println("After adding a collection: " + list);

        // addIfAbsent(E e)
        ((CopyOnWriteArrayList<String>) list).addIfAbsent("Apple");  // won't add because it's already in the list
        ((CopyOnWriteArrayList<String>) list).addIfAbsent("Grape");
        System.out.println("After adding Grape (if absent): " + list);

        // addAllAbsent(Collection c)
        ((CopyOnWriteArrayList<String>) list).addAllAbsent(Arrays.asList("Apple", "Honeydew", "Iced Fruit"));
        System.out.println("After adding a collection (if absent): " + list);
    }

    /**
     * iterator()
     * hasNext()
     * next()
     * remove()
     */

    @Test
    public void learn_Iterator() {
        List<String> list = new CopyOnWriteArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");

        // Create an iterator
        Iterator<String> itr = list.iterator();

        // Display using iterator
        System.out.println("List elements using iterator:");
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

        // Unlike some other iterators, the iterator for CopyOnWriteArrayList does not support the remove() operation.
        // Calling itr.remove() will throw an UnsupportedOperationException.
    }
}
