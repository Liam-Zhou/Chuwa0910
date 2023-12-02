package kechen;

import org.junit.Test;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LinkedListExerciseTest {

    @Test
    public void learn_Inserting_And_Retrieving() {
        /**
         * List<Integer> list = new LinkedList<Integer>();
         */
        // Create a LinkedList of integers
        LinkedList<Integer> list = new LinkedList<>();

        /**
         * Inserting:
         * add(E e) or addLast(E e)
         * addFirst(E e)
         * add(int index, E element)
         * addAll(Collection c)
         * addAll(int index, Collection c)
         */
        // Inserting elements:
        // Add elements to the end of the list
        list.add(1);
        list.add(2);
        list.addLast(3);
        System.out.println(list); //output: [1, 2, 3]

        // Insert an element at the beginning of the list
        list.addFirst(0);
        System.out.println(list); //output: [0, 1, 2, 3]

        // Insert an element at a specific index
        list.add(2, 0);
        System.out.println(list);  //output: [0, 1, 0, 2, 3]

        // Add elements from a collection at the end
        List<Integer> collection = new LinkedList<>();
        collection.add(20);
        collection.add(25);
        list.addAll(collection);
        System.out.println(list);   //output: [0, 1, 0, 2, 3, 20, 25]

        // Add elements from a collection at a specific index
        List<Integer> collectionToAdd = new LinkedList<>();
        collectionToAdd.add(4);
        collectionToAdd.add(5);
        list.addAll(5, collectionToAdd);
        System.out.println(list);  //output:  [0, 1, 0, 2, 3, 4, 5, 20, 25]

        /**
         * Retrieving:
         * getFirst()
         * getLast()
         * get(int index)
         */
        // Retrieving elements:
        // Get the first element
        System.out.println(list.getFirst());  //output: 0

        // Get the last element
        System.out.println(list.getLast());   //output: 25

        // Get an element at a specific index
        System.out.println(list.get(2));    //output: 0
    }


    @Test
    public void learn_Remove_Sort() {
        LinkedList<String> list = new LinkedList<>();
        list.add("D");
        list.add("D");
        list.add("C");
        list.add("C");
        list.add("Banana");
        list.add("B");
        list.add("B");
        list.add("A");
        list.add("Banana");
        list.addLast("A");

        /**
         * removeFirst()
         * removeLast()
         * remove(int index)
         * remove(Object o)
         * removeLastOccurrence()
         */
        System.out.println(list.removeFirst());   // D
        System.out.println(list.removeLast());   // A
        System.out.println(list.remove(1));    // C
        System.out.println(list.remove("B"));    // true
        System.out.println(list);   // [D, C, Banana, B, A, Banana]
        System.out.println(list.removeLastOccurrence("Banana"));  // true
        System.out.println(list);    // [D, C, Banana, B, A]

        /**
         * sort()
         */
        // Sort the ArrayList in ascending order
        Collections.sort(list);
        System.out.println(list);   // [A, B, Banana, C, D]
    }
}
