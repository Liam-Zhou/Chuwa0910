package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * @author Ke Chen
 * @date 09/19/23
 */
public class ArrayListExerciseTest {
    @Test
    public void learn_Inserting_And_Retrieving() {
        // new ArrayList()
        List<String> arrayList = new ArrayList<>();
        // add elements
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.add("D");
        // get element
        System.out.println(arrayList.get(0)); // output: A
        // get Size
        System.out.println("The size of arraylist is : " + arrayList.size()); // output: 4

        // list.addAll(anotherList)
        List<String> anotherList = new ArrayList<>();
        anotherList.add("E");
        anotherList.add("F");
        arrayList.addAll(anotherList);
        System.out.println(arrayList); // output: [A, B, C, D, E, F]
    }


    @Test
    public void learn_Remove_Replacing_Updating() {
        List<String> arrayList = new ArrayList<>();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.add("D");
        arrayList.add("E");
        arrayList.add("F");

        // remove(int index)  // remove by index
        arrayList.remove(0);
        // remove(Object o)   // remove by value
        arrayList.remove("B");
        System.out.println(arrayList);  // output: [C, D, E, F]

        /*
        arrayList.removeRange(0,2);

        https://blog.csdn.net/weixin_44048746/article/details/120666984v
        如果你想要使用ArrayList的removeRange方法，
        可以直接写一个list类，继承ArrayList，然后就可以使用它的removeRange方法。
         */

        // removeAll(Collection<?> c)
        ArrayList<String> toRemove = new ArrayList<>();
        toRemove.add("C");
        toRemove.add("D");
        System.out.println(arrayList.removeAll(toRemove));  // // output: true
        System.out.println(arrayList);  // output: [E, F]

        // clear()
        // arrayList.clear();
        // System.out.println(arrayList); // output: []

        // set(int index, E e)
        System.out.println(arrayList.set(0,"A"));   // output: E
        System.out.println(arrayList);   // output: [A, F]

        // replaceAll(UnaryOperator<E> operator)
        arrayList.replaceAll(e -> e.toLowerCase());
        System.out.println(arrayList);   // output: [a, f]

        // contains(Object o)
        System.out.println(arrayList.contains("a")); // output: true
        // indexOf(Object o)
        System.out.println(arrayList.indexOf("a"));   // output: 0
        // lastIndexOf(Object o)
        arrayList.add("a");
        System.out.println(arrayList.lastIndexOf("a"));  // output: 2
    }

    @Test
    public void learn_Iterator() {
        /**
         * iterator()
         * hasNext()
         * next()
         * remove()
         * forEachRemaining(Consumer<? super E> action) -- from Java8
         */
        // iterator()
        List<String> arrayList = new ArrayList<>();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.add("D");
        arrayList.add("E");
        arrayList.add("F");

        // Create an iterator and iterate through the list
        Iterator<String> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            System.out.println("Iterator: " + item);
        }
    }

    /**
     * sort(List<T> list)
     * Collections.sort(List<T> t)
     * Comparator.reverseOrder()
     */

    @Test
    public void learn_Sorting() {
        // sort(List<T> list)
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(2);
        numbers.add(8);
        numbers.add(1);

        Collections.sort(numbers);
        System.out.println(numbers);   // output: [1,2,5,8]

    }
}
