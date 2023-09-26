package com.chuwa.exercise.collection;

import org.junit.Test;
import java.util.*;
import java.util.function.UnaryOperator;

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
        ArrayList<String> list = new ArrayList<>();
        list.add("apple");
        list.add("banana");
        list.add("cherry");

        System.out.println("Item at index 0: " + list.get(0));
        System.out.println("List size: " + list.size());

        ArrayList<String> anotherList = new ArrayList<>();
        anotherList.add("date");
        anotherList.add("elderberry");

        list.addAll(anotherList);
        System.out.println("List size after adding anotherList: " + list.size());
        System.out.println("Item at index 3: " + list.get(3));
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
        ArrayList<String> list = new ArrayList<>(Arrays.asList("apple", "banana", "cherry", "date", "elderberry"));

        list.remove(1);
        System.out.println("Contains 'banana' after removal: " + list.contains("banana"));

        list.remove("cherry");
        System.out.println("Contains 'cherry' after removal: " + list.contains("cherry"));

        list.removeAll(Arrays.asList("apple", "date"));
        System.out.println("List after removeAll: " + list);

        list.clear();
        System.out.println("Is list empty after clear(): " + list.isEmpty());

        list.addAll(Arrays.asList("apple", "banana", "cherry"));
        list.set(1, "blueberry");
        System.out.println("List after adding elements and replacing banana with blueberry: " + list);

        list.replaceAll(String::toUpperCase);
        System.out.println("List after replaceAll: " + list);
        System.out.println("Index of 'APPLE': " + list.indexOf("APPLE"));
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
        ArrayList<String> list = new ArrayList<>(Arrays.asList("apple", "banana", "cherry"));
        Iterator<String> iterator = list.iterator();

        while(iterator.hasNext()) {
            System.out.println("Item from iterator: " + iterator.next());
        }

        iterator = list.iterator();
        iterator.next();
        iterator.remove();
        System.out.println("List after iterator.remove(): " + list);

        iterator.forEachRemaining(s -> System.out.println("Item in uppercase from forEachRemaining: " + s.toUpperCase()));
    }

    /**
     * sort(List<T> list)
     * Collections.sort(List<T> t)
     * Comparator.reverseOrder()
     */

    @Test
    public void learn_Sorting() {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("cherry", "banana", "apple"));
        list.sort(Comparator.naturalOrder());
        System.out.println("List after sorting in natural order: " + list);

        Collections.sort(list, Comparator.reverseOrder());
        System.out.println("List after reverse order sorting: " + list);
    }
}
