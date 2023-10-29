package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

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
        ArrayList<Integer> num = new ArrayList<>();
        num.add(8);
        num.add(9);
        System.out.println(num);
        System.out.println(num.get(0));//find [0] value
        System.out.println(num.size());
        ArrayList<String> name = new ArrayList<>();
        name.add("Grace");
        name.add("Bob");
        //num.addAll(name); didn't work, only same data type

        ArrayList<Integer> num2 = new ArrayList<>();
        num2.add(8);
        num2.add(9);
        num.addAll(num2);
        System.out.println(num);
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
        ArrayList<Integer> num = new ArrayList<>();
        ArrayList<Integer> num2 = new ArrayList<>();
        num.add(0);
        num2.add(1);
        num.add(1);
        num.add(1);
        num.add(2);
        num.add(3);
        num.add(4);
        //num.remove(0);
        //num.removeAll(num2); // remove all 1
        num.set(0, 9);
        num.replaceAll(number -> number*2);
        System.out.println(num);
        System.out.println(num.contains(8));
        System.out.println(num.indexOf(2)); //return index number(first occur)
        System.out.println(num.lastIndexOf(2)); //last
        num.clear();
        System.out.println(num);
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
        ArrayList<String> car = new ArrayList<>();
        car.add("BMW");
        car.add("Tesla");
        car.add("Toyota");
        car.add("Nissan");
        Iterator iterator = car.iterator();

        while(iterator.hasNext()) {
            String s = iterator.next().toString();
            if(s.equals("Tesla")) {
                iterator.remove();
            }
        }
        System.out.println(car);


//      Iterator<String> iterator = fruits.iterator();
//
//      while (iterator.hasNext()) {
//          System.out.println(iterator.next());
//      }

        //same example shown above, but more concise and readable!!
        iterator = car.iterator();
        iterator.forEachRemaining(c -> System.out.println(c));//can't use forER after using remove()
    }

    /**
     * sort(List<T> list)
     * Collections.sort(List<T> t)
     * Comparator.reverseOrder()
     */

    @Test
    public void learn_Sorting() {
        ArrayList<Integer> num = new ArrayList<>();
        num.add(2);
        num.add(1);
        num.add(4);
        num.add(3);
        Collections.sort(num);
        System.out.println(num);
        num.sort(Comparator.reverseOrder());
        System.out.println(num);
    }
}
