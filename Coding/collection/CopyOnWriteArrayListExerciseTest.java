package com.chuwa.exercise.collection;

import org.junit.Test;

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
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList();
        list.add("2");
        System.out.println("list");
        list.add(0,"1");
        System.out.println("list");
        list.addAll(Arrays.asList("3", "4"));
        System.out.println("list");
        list.addIfAbsent("4");
        System.out.println("list");
        list.addIfAbsent("5");
        System.out.println("list");
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
        Iterator<String> tem = list.iterator();
        System.out.println(tem.hasNext());
        list.remove("Apple");
        System.out.println(list);

    }
}
