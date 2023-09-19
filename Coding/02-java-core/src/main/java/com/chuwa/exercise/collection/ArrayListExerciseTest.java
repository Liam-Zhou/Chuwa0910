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
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.get(0);
        System.out.println(list.size());
        List<Integer> newList = Arrays.asList(1, 2, 3);
        list.addAll(newList);
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
        List<Integer> list = Arrays.asList(1, 2, 3);
        list.remove(0);
        Integer i = 2;
        list.remove(i);

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
        List<String> myList = Arrays.asList("apple", "banana", "cherry");
        Iterator<String> iterator = myList.listIterator();

        while (iterator.hasNext()){
            String str = iterator.next();
            iterator.remove();
        }
        iterator.forEachRemaining(s -> System.out.println(s));
    }

    /**
     * sort(List<T> list)
     * Collections.sort(List<T> t)
     * Comparator.reverseOrder()
     */

    @Test
    public void learn_Sorting() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        Collections.sort(list);
        Collections.sort(list, Collections.reverseOrder());

    }
}
