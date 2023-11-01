package kechen;

import org.junit.Test;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 从 CopyOnWriteArrayList 的名字就能看出CopyOnWriteArrayList 是满足CopyOnWrite 的 ArrayList，
 * 所谓CopyOnWrite 也就是说：在计算机，如果你想要对一块内存进行修改时，我们不在原有内存块中进行写操作，
 * 而是将内存拷贝一份，在新的内存中进行写操作，写完之后呢，就将指向原来内存指针指向新的内存，原来的内存就可以被回收掉了。
 */

public class CopyOnWriteArrayListExerciseTest {
    /**
     * e.g.
     * List list = new CopyOnWriteArrayList();
     *
     * add(E e)
     * add(int index, E element)
     * addAll(Collection c)
     * addIfAbsent(E e)
     * addAllAbsent(Collection c)
     */
    @Test
    public void learn_Inserting_And_Retrieving() {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        //add(E e)
        list.add("A");
        list.add("B");
        list.add("D");
        list.add("E");
        list.add("F");
        System.out.println(list);   // [A, B, D, E, F]

        //add(int index, E element)
        list.add(2,"C");
        System.out.println(list);   // [A, B, C, D, E, F]

        //addAll(Collection c)
        List<String> element = new CopyOnWriteArrayList<>();
        element.add("Grapes");
        element.add("Mango");
        list.addAll(element);
        System.out.println(list);  // [A, B, C, D, E, F, Grapes, Mango]

        // addIfAbsent(E e)
        list.addIfAbsent("Orange");
        System.out.println(list);    // [A, B, C, D, E, F, Grapes, Mango, Orange]

        // addAllAbsent(Collection c)
        // Add multiple elements if they are not already present
        List<String> number = new CopyOnWriteArrayList<>();
        number.add("1");
        number.add("2");
        number.add("Orange");
        list.addAllAbsent(number);
        System.out.println(list);   // [A, B, C, D, E, F, Grapes, Mango, Orange, 1, 2]
    }

    /**
     * iterator()
     * hasNext()
     * next()
     * remove()
     */

    @Test
    public void learn_Iterator() {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");

        // Create an iterator for the CopyOnWriteArrayList
        Iterator<String> iterator = list.iterator();

        // Iterate and remove elements
        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.println(element);
        }

        /*
        The CopyOnWriteArrayList does not support the iterator.remove() method
         */
    }
}
