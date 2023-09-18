package collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author b1go
 * @date 6/12/22 4:48 PM
 */
public class CollectionsExerciseTest {

    /**
     * Collections.min(list))
     * min(Collection c, Comparator comp)
     *
     * Collections.max(list)
     * max(Collection c, Comparator comp)
     *
     * frequency(Collection c, object o)
     */

    @Test
    public void learn_common_collections_operations() {
        // Create a list of integers
        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(5);
        numbers.add(15);
        numbers.add(7);
        numbers.add(20);
        numbers.add(5);

        int min = Collections.min(numbers);
        System.out.println("Minimum element: " + min);

        int max = Collections.max(numbers);
        System.out.println("Maximum element: " + max);

        int frequencyOf5 = Collections.frequency(numbers, 5);
        System.out.println("Frequency of 5: " + frequencyOf5);
    }

    /**
     * synchronizedList()
     */

    @Test
    public void learn_thread_safe_ArrayList() {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> arrayList1 = new ArrayList<>();
        List<Integer> synchronizedList = Collections.synchronizedList(arrayList1);

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                synchronizedList.add(i);
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 1000; i < 2000; i++) {
                synchronizedList.add(i);
            }
        });

        Thread thread3 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                arrayList.add(i);
            }
        });
        Thread thread4 = new Thread(() -> {
            for (int i = 1000; i < 2000; i++) {
                arrayList.add(i);
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Size of synchronizedList: " + synchronizedList.size());
        System.out.println("Size of arrayList: " + arrayList.size());
    }
}
