package collection;

import org.junit.Test;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author b1go
 * @date 6/12/22 4:46 PM
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
        List<Integer> copyOnWriteList = new CopyOnWriteArrayList<>();
        copyOnWriteList.add(1);
        copyOnWriteList.add(2);
        copyOnWriteList.add(3);

        System.out.println("Initial List: " + copyOnWriteList);

        copyOnWriteList.add(1, 4);
        System.out.println("List after inserting 4 at index 1: " + copyOnWriteList);

        List<Integer> anotherList = List.of(5, 6, 7);
        copyOnWriteList.addAll(anotherList);
        System.out.println("List after adding elements from another collection: " + copyOnWriteList);

        boolean added = ((CopyOnWriteArrayList<Integer>) copyOnWriteList).addIfAbsent(4); // 4 is already in the list, so it won't be added
        System.out.println("Result of adding 4 if absent: " + added);

        List<Integer> absentElements = List.of(4, 8, 9, 10);
        int addedAll = ((CopyOnWriteArrayList<Integer>) copyOnWriteList).addAllAbsent(absentElements);
        System.out.println("Result of adding absent elements: " + addedAll);
        System.out.println("Final List: " + copyOnWriteList);
    }

    /**
     * iterator()
     * hasNext()
     * next()
     * remove()
     */

    @Test
    public void learn_Iterator() {
        List<String> list = new CopyOnWriteArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");

        Iterator<String> itr = list.iterator();

        while (itr.hasNext()) {
            String element = itr.next();
            System.out.println("Element: " + element);
        }
        //itr.remove(); not supported

        System.out.println("List after iterator removal: " + list);
    }
}
