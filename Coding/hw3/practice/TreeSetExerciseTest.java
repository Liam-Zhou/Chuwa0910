
import org.junit.Test;
import java.util.Set;
import java.util.TreeSet;

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
        TreeSet<Integer> set= new TreeSet<>();
        set.add(1);
        set.add(2);
        set.add(-1);
        set.add(99);
        set.add(100);
        System.out.println(set.contains(99));
        set.first();
        set.last();
        System.out.println(set);
        System.out.println(set.first()+", "+set.last()+", "+set.subSet(1,2)+ ", "+set.headSet(5)
                +", "+set.tailSet(3));
        System.out.println(set.size()+", "+set.isEmpty());

        //true
        //[-1, 1, 2, 99, 100]
        //-1, 100, [1], [-1, 1, 2], [99, 100]
        //5, false
    }
}
