package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
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
        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();

        list.add(1);
        System.out.println(list);

        list.add(0, 0);
        System.out.println(list);

        Collection<Integer> collection = new ArrayList<>();
        collection.add(2);
        collection.add(3);
        list.addAll(collection);
        System.out.println(list);

        list.addIfAbsent(4);
        System.out.println(list);

        Collection<Integer> anotherCollection = new ArrayList<>();
        anotherCollection.add(3);
        anotherCollection.add(5);
        list.addAllAbsent(anotherCollection);
        System.out.println(list);
    }

    /**
     * iterator()
     * hasNext()
     * next()
     * remove()
     */

    @Test
    public void learn_Iterator() {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");

        Iterator<String> itr = list.iterator();

        while (itr.hasNext()) {
            String element = itr.next();
            System.out.println(element);

            if (element.equals("Banana")) {
                itr.remove(); // doesn't support
            }
        }

        System.out.println(list);
    }
}
