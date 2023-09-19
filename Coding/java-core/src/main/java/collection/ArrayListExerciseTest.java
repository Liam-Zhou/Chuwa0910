package collection;

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
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list.size());
        System.out.println(list.get(0));


        List<Integer> list1 = new ArrayList<>();
        list1.addAll(list);
        list1.forEach(System.out::println);
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
        // Test remove(int index)
        List<String> list1 = new ArrayList<>(List.of("A", "B", "C", "D", "E", "F", "G"));
        List<String> listD = new ArrayList<>(List.of("E", "F"));
        list1.remove(2);
        list1.remove("G");
        list1.removeAll(listD);
        list1.forEach(System.out::println);

        // Test clear()
        List<String> list4 = new ArrayList<>(List.of("A", "B", "C", "D", "E"));
        list4.clear();
        System.out.println(list4.isEmpty());

        // Test set(int index, E e)
        List<String> list5 = new ArrayList<>(List.of("A", "B", "C", "D", "E"));
        list5.set(2, "X");
        System.out.println(list5.get(2));

        // Test replaceAll(UnaryOperator<E> operator)
        List<Integer> list6 = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        list6.replaceAll(x -> x * 2); // Double each element
        System.out.println(list6);

        // Test contains(Object o)
        List<String> list7 = new ArrayList<>(List.of("A", "B", "C", "D", "E"));
        System.out.println(list7.contains("C"));
        System.out.println(list7.contains("F"));

        // Test indexOf(Object o)
        List<String> list8 = new ArrayList<>(List.of("A", "B", "C", "D", "E"));
        System.out.println(list8.indexOf("C"));
        System.out.println(list8.indexOf("F"));

        // Test lastIndexOf(Object o)
        List<String> list9 = new ArrayList<>(List.of("A", "B", "C", "D", "C"));
        System.out.println(list9.lastIndexOf("C"));
        System.out.println(list9.lastIndexOf("F"));
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
        // Create a list of integers
        List<Integer> numbers = new ArrayList<> (List.of(1,2,3,4,5));

        // Create an iterator for the list
        Iterator<Integer> iterator = numbers.iterator();

        // Test hasNext() and next()
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());

        // Test remove()
        iterator.remove();
        System.out.println(numbers.size());
        System.out.println(numbers.contains(3));

        // Test forEachRemaining()
        List<Integer> remainingElements = new ArrayList<>();
        iterator.forEachRemaining(remainingElements::add);
        System.out.println(remainingElements.size());
        System.out.println(remainingElements.contains(4));
        System.out.println(remainingElements.contains(5));
    }

    /**
     * sort(List<T> list)
     * Collections.sort(List<T> t)
     * Comparator.reverseOrder()
     */

    @Test
    public void learn_Sorting() {
        // Create a list of integers
        List<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(1);
        numbers.add(3);
        numbers.add(2);
        numbers.add(4);
        Collections.sort(numbers);
        System.out.println(numbers);

        List<String> words = new ArrayList<>();
        words.add("banana");
        words.add("apple");
        words.add("cherry");
        words.add("date");
        Collections.sort(words);
        System.out.println(words);
        Collections.sort(words, Comparator.reverseOrder());
        System.out.println(words);
    }
}
