package kechen;

import org.junit.Test;

import java.util.*;

public class ArrayListExerciseTest {


    @Test
    public void learn_Inserting_And_Retrieving() {

        /**
         * new ArrayList()
         * add elements
         * get element
         * get Size
         * list.addAll(anotherList)
         */
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

        /**
         * remove(int index)
         * remove(Object o)
         * removeRange(int fromIndex, int toIndex)
         * removeAll(Collection<?> c)
         * clear()
         */
        // remove(int index)  remove by index
        arrayList.remove(0);
        // remove(Object o)   remove by value
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
        arrayList.clear();
        System.out.println(arrayList); // output: []

        /**
         * Update:
         * set(int index, E e)
         * replaceAll(UnaryOperator<E> operator)
         */
        //re-add
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.add("D");
        arrayList.add("E");
        arrayList.add("F");

        // set(int index, E e)
        System.out.println(arrayList.set(0,"KE"));   // output: A
        System.out.println(arrayList);   // output: [KE, B, C, D, E, F]

        // replaceAll(UnaryOperator<E> operator)
        arrayList.replaceAll(e -> e.toLowerCase());
        System.out.println(arrayList);   // output: [ke, b, c, d, e, f]

        /**
         * check:
         * contains(Object o)
         * indexOf(Object o)
         * lastIndexOf(Object o)
         */
        // contains(Object o)
        System.out.println(arrayList.contains("ke")); // output: true
        // indexOf(Object o)
        System.out.println(arrayList.indexOf("ke"));   // output: 0
        // lastIndexOf(Object o)
        arrayList.add("a");
        System.out.println(arrayList.lastIndexOf("a"));  // output: 6
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
        // Using the iterator to iterate over the elements
        // uing hasNext() + next()
        while (iterator.hasNext()) {
            String item = iterator.next();
            System.out.println("Iterator: " + item);
            /*
            output:
            Iterator: A
            Iterator: B
            Iterator: C
            Iterator: D
            Iterator: E
            Iterator: F
             */

            // using remove() to remove an element using the iterator
            if (item.equals("C")) {
                iterator.remove();
            }
        }
        // Print the ArrayList after removing an element
        System.out.println("After removing 'C': " + arrayList);  // output: After removing 'C': [A, B, D, E, F]

        // Using the forEachRemaining method (Java 8+)
        iterator = arrayList.iterator(); // Reset the iterator
        iterator.forEachRemaining(element -> System.out.println("Remaining: " + element));
        /*
        output:
        Iterator: A
        Iterator: B
        Iterator: D
        Iterator: E
        Iterator: F
        */
    }

    /**
     * sort(List<T> list)
     * Collections.sort(List<T> t)
     * Comparator.reverseOrder()
     */
    @Test
    public void learn_Sorting() {
        // sort(List<T> list)
        List<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(2);
        numbers.add(8);
        numbers.add(1);

        // Sort the ArrayList in ascending order using the sort method
        Collections.sort(numbers);
        System.out.println("Sorted in ascending order: " + numbers);
        // output: Sorted in ascending order: [1, 2, 5, 8]

        // Reset the ArrayList
        numbers.clear();

        // Add some elements to the ArrayList
        numbers.add(5);
        numbers.add(2);
        numbers.add(8);
        numbers.add(1);
        numbers.add(10);

        // Sort the ArrayList in descending order using reverseOrder
        numbers.sort(Comparator.reverseOrder());
        System.out.println("Sorted in descending order: " + numbers);
        // output: Sorted in descending order: [10, 8, 5, 2, 1]
    }
}
