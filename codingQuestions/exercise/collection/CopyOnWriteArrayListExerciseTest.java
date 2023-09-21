package com.chuwa.exercise.collection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Iterator;
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

        // add elements
        list.add("Apple");
        list.add("Banana");

        // insert an element at a specific index
        list.add(1, "Cathy");

        // Add multiple elements from a collections
        list.addAll(List.of("Derrick", "Ethan"));

        // add an element if it's not already present
        boolean apple = ((CopyOnWriteArrayList<String>) list).addIfAbsent("Apple");

        ((CopyOnWriteArrayList<String>) list).addAllAbsent(List.of("Peach", "Apple"));

        // retrieve elements from the list
        String name = list.get(1);
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

        //Created an iterator
        Iterator<String> itr = list.iterator();

        // Use the iterator to traverse and possibly remove elements
        String element = itr.next();
        // remove an element using the iterator
        if (element.equals("Banana")){
            itr.remove();
        }

        // the list has been modified, and Banana is remove
        System.out.println("new list " + list);
    }
}
