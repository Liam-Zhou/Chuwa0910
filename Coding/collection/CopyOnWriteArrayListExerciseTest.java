package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
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
        List<Integer> list = new CopyOnWriteArrayList<>();
        list.add(4);
        list.add(2);
        list.add(3);
        list.add(1);
        System.out.println(list);

        list.add(1, 5);
        System.out.println(list);

        List<Integer> list2 = new CopyOnWriteArrayList<>();
        list2.addAll(list);
        System.out.println(list2);

        ((CopyOnWriteArrayList<Integer>) list).addIfAbsent(4);
        System.out.println(list);

        List<Integer> list3 = new CopyOnWriteArrayList<>();
        list3.add(4);
        list3.add(2);
        ((CopyOnWriteArrayList<Integer>) list3).addAllAbsent(list);
        System.out.println(list2);
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
        List<String> list2 = new CopyOnWriteArrayList<>();
        while(itr.hasNext()) {
            String s = itr.next().toString();
            list2.add(s);
        }
        System.out.println(list2);
        list2.remove(0);
        System.out.println(list2);
    }
}
