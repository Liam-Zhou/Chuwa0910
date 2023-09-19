package collection;

import org.junit.Test;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author b1go
 * @date 6/12/22 4:46 PM
 */
public class TreeSetExerciseTest {
    /**
     * e.g.
     * Set<Integer> set= new TreeSet<>();
     *
     * add(E e)
     * addAll(Collection<> c)
     *
     * contains(Object o)
     *
     * first()
     * last()
     * subSet(E fromElement, E toElement)
     * headSet(E toElement)
     * tailSet(E fromElement)
     *
     * remove(Object o)
     *
     * size()
     * isEmpty()
     *
     *
     */

    @Test
    public void learn_Inserting_And_Retrieving_Removing() {
        Set<Integer> set = new TreeSet<>();

        set.add(3);
        set.addAll(List.of(1, 2, 3, 4));

        System.out.println(set.contains(3));
        System.out.println(set.stream().findFirst()); // first()

        Set<Integer> subSet = ((TreeSet<Integer>) set).subSet(2, 4);
        Set<Integer> headSet = ((TreeSet<Integer>) set).headSet(3);
        Set<Integer> tailSet = ((TreeSet<Integer>) set).tailSet(3);

        System.out.println(set.remove(3));

        System.out.println(set.size());
        System.out.println(set.isEmpty());

        System.out.println("Set after inserting: " + set);
        System.out.println("Subset: " + subSet);
        System.out.println("Headset: " + headSet);
        System.out.println("Tailset: " + tailSet);
    }
}
