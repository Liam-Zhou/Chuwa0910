package kechen;

import org.junit.Test;

import java.time.DayOfWeek;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AdditionalMapExerciseTest {

    /*
    Use Case: You should use ConcurrentHashMap when you need a thread-safe and highly concurrent map for multi-threaded
              applications. It allows for multiple threads to read and write concurrently without explicit locking.
    Example: In multi-threaded applications where you need to safely share and update data in a map among multiple
             threads without the risk of data corruption.
     */
    @Test
    public void learn_ConcurrentHashMap() {
        /**
         * e.g.
         * ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
         */
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

        /**
         * put(K key, V value)
         * putIfAbsent(K key, V value)
         * putAll(Map<? extends K, ? extends V> m)
         */
        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);
        System.out.println(map);  // {One=1, Two=2, Three=3}

        map.putIfAbsent("Four", 4);

        Map<String, Integer> moreNum = new HashMap<>();
        moreNum.put("Five", 5);
        moreNum.put("Six", 6);
        map.putAll(moreNum);
        System.out.println(map);   // {Five=5, Six=6, One=1, Four=4, Two=2, Three=3}
    }


    /*
    Use Case: You should use IdentityHashMap when you want to use reference equality (==) to compare keysrather than
              object equality (equals method).
              This means that two different key objects that are equal according to their equals method will still be
              treated as distinct keys if they have different references.
    Example: When you need to maintain keys based on their actual memory addresses or object identity.
     */
    @Test
    public void learn_IdentityHashMap() {
        /**
         * e.g.
         * Map<DayOfWeek, Integer> map = new IdentityHashMap<>();
         */
        Map<DayOfWeek, Integer> map = new IdentityHashMap<>();

        /**
         * put(K key, V value)
         * putIfAbsent(K key, V value)
         */

        map.put(DayOfWeek.MONDAY, 1);
        map.put(DayOfWeek.TUESDAY, 2);
        map.put(DayOfWeek.WEDNESDAY, 3);
        map.put(DayOfWeek.THURSDAY, 4);
        System.out.println(map);    // {MONDAY=1, TUESDAY=2, WEDNESDAY=3, THURSDAY=4}
    }

    /*
    Use Case: Use EnumMap when you have an enum as keys, and you want an efficient and specialized map implementation
              for such scenarios.
              EnumMap is designed to work with enum keys and is more efficient than other map implementations for this
              specific use case.
    Example: When you are working with enum-based data, such as days of the week, months,
             or other well-defined sets of values.
     */
    @Test
    public void learn_EnumMap() {
        /**
         * e.g.
         * EnumMap<DayOfWeek, Integer> enumMap = new EnumMap<>(DayOfWeek.class);
         */
        EnumMap<DayOfWeek, Integer> enumMap = new EnumMap<>(DayOfWeek.class);

        /**
         * put(K key, V value)
         * putIfAbsent(K key, V value)
         */
        enumMap.put(DayOfWeek.MONDAY, 1);
        enumMap.put(DayOfWeek.TUESDAY, 2);
        enumMap.put(DayOfWeek.WEDNESDAY, 3);
        enumMap.put(DayOfWeek.THURSDAY, 4);
        System.out.println(enumMap);    // {THURSDAY=4, MONDAY=1, WEDNESDAY=3, TUESDAY=2}
    }
}
