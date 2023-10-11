package com.chuwa.exercise.collection;

import org.junit.Before;
import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.util.*;

/**
 * @author b1go
 * @date 6/12/22 4:43 PM
 */
public class ArrayListExerciseTest {
    List<String> arrList = new ArrayList<>();
    /**
     * new ArrayList()
     * add elements
     * get element
     * get Size
     * list.addAll(anotherList)
     */
    @Before
    public void inital() {
        this.arrList.add("a");
        this.arrList.add("b");
        this.arrList.add("c");
        this.arrList.add("d");
        this.arrList.add("e");
        this.arrList.add("d");
    }
    @Test
    public void learn_Inserting_And_Retrieving() {
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.get(0);
        System.out.println(arr.size());
        List<Integer> arrb = new ArrayList<>();
        arr.addAll(arrb);
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
/*        System.out.println(arrList);
        arrList.remove(0);
        System.out.println(arrList);
        arrList.remove("c");
        System.out.println(arrList);
        List<String> barr = new ArrayList<>();
        barr.add("d");
        barr.add("e");
        arrList.removeAll(barr);
        System.out.println(arrList);*/

        arrList.set(0,"A");
        arrList.replaceAll(e->"c");
        System.out.println(arrList.contains("c"));
        System.out.println(arrList.indexOf("c"));
        System.out.println(arrList.lastIndexOf("c"));

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
        Iterator<String> iterator = arrList.listIterator();

        while (iterator.hasNext()){
            String str = iterator.next();
            iterator.remove();
        }
        iterator.forEachRemaining(s-> System.out.println(s));

    }

    /**
     * sort(List<T> list)
     * Collections.sort(List<T> t)
     * Comparator.reverseOrder()
     */

    @Test
    public void learn_Sorting() {
        List<Integer> list = Arrays.asList(1, 3,2);
        Collections.sort(list);
        Collections.sort(list, Collections.reverseOrder());
        System.out.println(list);
    }
}
