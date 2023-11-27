package kechen;

import org.junit.Test;

import java.sql.SQLOutput;
import java.util.HashSet;

public class HashSetExerciseTest {
    /**
     * e.g.
     * Set<Integer> set= new HashSet<>();
     *
     * add(E e)
     * addAll(Collection<> c)
     *
     * get()
     * contains()
     *
     * remove(Object o)
     * clear()
     *
     * isEmpty()
     */

    @Test
    public void learn_Inserting_And_Retrieving_Removing() {
        HashSet<Integer> set = new HashSet<>();

        //add(E e)
        set.add(0);
        set.add(1);
        set.add(2);
        set.add(3);
        System.out.println(set);  // [0, 1, 2, 3]

        //addAll(Collection<> c)
        HashSet<Integer> number = new HashSet<>();
        number.add(4);
        number.add(5);
        set.addAll(number);
        System.out.println(set);  // [0, 1, 2, 3, 4, 5]

        //hashset does not have a get() method because it is not an indexed collection

        //contains()
        System.out.println(set.contains(8));   // false

        //remove(Object o)
        System.out.println(set.remove(0));  //true
        // clear()
        set.clear();
        System.out.println(set);   // []

        System.out.println(set.isEmpty());   // true
    }
}
