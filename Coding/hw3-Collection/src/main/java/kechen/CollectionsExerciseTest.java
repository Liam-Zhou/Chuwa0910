package kechen;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsExerciseTest {

    @Test
    public void learn_common_collections_operations() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(4);

        /**
         * Collections.min(list))
         * min(Collection c, Comparator comp)
         */
        System.out.println(Collections.min(list));    // 1

        /**
         * Collections.max(list)
         * max(Collection c, Comparator comp)
         */
        System.out.println(Collections.max(list));     // 4

        /**
         * frequency(Collection c, object o)       // 2
         */
        System.out.println(Collections.frequency(list, 3));
    }


    @Test
    public void learn_thread_safe_ArrayList() {
        /**
         * synchronizedList()
         */
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        List<Integer> synchronizedList = Collections.synchronizedList(list);
        System.out.println(synchronizedList);    // [1, 2, 3]
    }
}
