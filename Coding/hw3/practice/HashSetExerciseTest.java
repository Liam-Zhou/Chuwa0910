
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;


public class HashSetExerciseTest {
    /**
     * e.g.
     * Set<Integer> set= new HashSet<>();
     *
     * add(E e)
     * addAll(Collection<> c)
     *
     * get() // ?
     * contains()
     *
     * remove(Object o)
     * clear()
     *
     * isEmpty()
     *
     *
     */

    @Test
    public void learn_Inserting_And_Retrieving_Removing() {
        Set<Integer> set= new HashSet<>();
        set.add(1);
        set.add(99);
        System.out.println(set);
        System.out.println(set.contains(99));
        set.remove(0);
        set.clear();
        set.isEmpty();


    }
}
