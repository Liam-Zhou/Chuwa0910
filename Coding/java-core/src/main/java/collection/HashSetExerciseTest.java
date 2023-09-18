package collection;

import org.junit.Test;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * @author b1go
 * @date 6/12/22 4:46 PM
 */
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
     *
     *
     */

    @Test
    public void learn_Inserting_And_Retrieving_Removing() {
        Set<Integer> set = new HashSet<>();

        set.add(1);
        set.add(2);
        set.add(3);

        System.out.println(set.contains(2));

        System.out.println(set.isEmpty());
        Collection<Integer> anotherCollection = Set.of(4, 5, 6);
        set.addAll(anotherCollection);
        boolean removed = set.remove(3);
        System.out.println(removed);

        set.clear();
        System.out.println(set.isEmpty());
    }
}
