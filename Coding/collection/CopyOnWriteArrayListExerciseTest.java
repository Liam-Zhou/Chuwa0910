package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.*;

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

        CopyOnWriteArrayList<Integer> lst = new CopyOnWriteArrayList<>();
        lst.add(3);
        lst.add(1,5);
        System.out.println(lst);
        
        Collection <Integer> lst2 = new ArrayList<>(Arrays.asList(1,7,9));
        lst.addAll(lst2);
        System.out.println("After added lst is:"+lst);

        lst.addIfAbsent(3);
        lst.addIfAbsent(4);
        System.out.println(lst);

        Collection <Integer> lst3 = Arrays.asList(1,2,3,4);
        lst.addAllAbsent(lst3);
        System.out.println(lst);






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
        while(itr.hasNext()){
            String value = itr.next();
            System.out.println("value is: " + value);

            if(value.equals("Apple"))
                list.remove(value);


        }
        System.out.println(list);
    }
}
