package com.chuwa.exercise.collection;
import java.util.*;

import org.junit.Test;

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
        //new ArrayList()
        List <Integer> lst = new ArrayList<>();

        //add elements
        lst.add(15);
        lst.add(20);
        lst.add(25);
        System.out.println("My lst is:" + lst);

        //get element
        int a = lst.get(1);
        System.out.println("Element at idx1 is:" + a);



        //get Size
        int size = lst.size();
        System.out.println("lst size is:" + size);


        //list.addAll(anotherList)
        List <Integer> lst2 = new ArrayList<>(Arrays.asList(2,4,6));

        lst.addAll(lst2);

        System.out.println("New arr is:" + lst);

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
        //remove(idx)
        List <Integer> lst = new ArrayList<>(Arrays.asList(2,4,6,8,10,12));
        lst.remove(0);
        System.out.println(lst);


        //remove(Obj);
        lst.remove(new Integer(4));
        System.out.println(lst); 

        //removeRange(int fromIndex, int toIndex)
        lst.subList(0, 2).clear();
        System.out.println(lst); 


        //removeAll(Collection<?> c)
        lst.removeAll(lst);
        System.out.println(lst); 

        //clear()
        lst.add(0, 1);
        lst.add(1, 2);
        System.out.println(lst); 
        lst.clear();
        System.out.println(lst); 


        //set
        lst = Arrays.asList(1,2,3,4,5,6);
        System.out.println("My new lst is:" + lst);
        lst.set(0, 6);
        System.out.println("Updated lst is:"+lst);

        //replaceALL
        lst.replaceAll(a-> a+1);
        System.out.println("replace as:" + lst);

        //contains
        System.out.println(lst.contains(4)); 

        //Index of
        System.out.println(lst.indexOf(4));

        //lastIdxOf
        System.out.println(lst.lastIndexOf(7));


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

        //iterator
        List <Integer> lst = new ArrayList<>(Arrays.asList(2,4,6,8,10,12));
        Iterator<Integer> it = lst.iterator();
        List<Integer> lst2 = new ArrayList<Integer>();
        //has next
        while(it.hasNext()){
            //next
            Integer value = it.next();
            System.out.println("iterator:" + value);


            //remove
            if(value.equals(4))
                it.remove();
    
        } 
        System.out.println(lst);

        it = lst.iterator();
        it.forEachRemaining(value->lst2.add(value+1));
        lst.addAll(lst2);
        System.out.println("new lst is:" + lst);


        

        






    }

    /**
     * sort(List<T> list)
     * Collections.sort(List<T> t)
     * Comparator.reverseOrder()
     */

    @Test
    public void learn_Sorting() {
        List <Integer> lst = new ArrayList<>(Arrays.asList(8,2,4,9,1,4,0));
        lst.sort(null);
        System.out.println(lst);


        lst = Arrays.asList(8,12,24,9,31,14,56); 
        Collections.sort(lst);
        System.out.println(lst);

        List <String> lst2 = new ArrayList<>(Arrays.asList("apple","banana","pear","peach"));
        Collections.sort(lst2,Comparator.reverseOrder());
        System.out.println(lst2);
    }
}
