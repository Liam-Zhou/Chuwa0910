import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class ArrayListExerciseTest extends ArrayList<String> {
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
        list.add("one");
        list.add("two");
        list.add("three");
        System.out.println(list.get(0));
        int size = list.size();
        System.out.println("size: "+ size);
        ArrayList<String> list2 = new ArrayList<>();
        list2.add("one");
        list2.add("two");
        list2.add("three");
        list2.add("four");
        list.addAll(2, list2);
        System.out.println(list);   // [one, two, one, two, three, four, three]
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
    public void learn_Remove_Replacing_Updating(){
        ArrayList<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("tag");

        ArrayList<String> list2 = new ArrayList<>();
        list2.add("one");
        list2.add("two");
        list2.add("three");
        list2.add("four");

        list.remove("one");
        System.out.println(list); //[two, three]

        list.remove(1);
        System.out.println(list); // [two]

        //list.removeRange(0,1); // this is protected void method, needs to extend ArrayList class.

        list.addAll(list2);
        System.out.println(list); // [two, one, two, three, four]
        list.removeAll(list2);  // only remove the element in list2. Include duplicated element.
        System.out.println(list); // []

        list.clear(); // clear the whole arraylist


        // list.set(0,"setWord");  // error since we clear the list, even set index = 0. indexOutOfBoundsException!
        list2.set(1, "setWord");
        System.out.println(list2);  // [one, setWord, three, four]

        list2.replaceAll(e->e.toUpperCase());
        System.out.println(list2);  // [ONE, SETWORD, THREE, FOUR]

        System.out.println(list2.contains("SETWORD"));  // true

        System.out.println(list2.indexOf("tag")); // -1

        System.out.println(list2.lastIndexOf("ONE".toUpperCase())); // 0


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
        ArrayList<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");

        Iterator<String> iter = list.iterator();

        while(iter.hasNext()){
            System.out.println(iter.next());
            iter.remove();
        }

        System.out.println("test1: "+list); // element was also removed by iterator.remove().

        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");

        Iterator<String> iter2 = list.iterator();
        iter2.forEachRemaining(e -> System.out.println(e));

    }

    /**
     * sort(List<T> list)
     * Collections.sort(List<T> t)
     * Comparator.reverseOrder()
     */

    @Test
    public void learn_Sorting() {
        ArrayList<String> list = new ArrayList<>();
        list.add("one");
        list.add("twoa");
        list.add("three");
        list.add("fouraaa");
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

                return  o2.length()-o1.length();
            }
        };

        list.sort(comparator);
        System.out.println(list);

        Collections.sort(list);
        System.out.println(list);
    }
}
