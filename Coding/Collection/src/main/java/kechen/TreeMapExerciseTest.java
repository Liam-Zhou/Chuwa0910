package kechen;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapExerciseTest {

    @Test
    public void learn_Inserting_And_Retrieving() {
        /**
         * e.g.
         * TreeMap<String, Integer> map = new TreeMap<>();
         */
        TreeMap<String, Integer> map = new TreeMap<>();
        /**
         * put(K key, V value)
         * putIfAbsent(K key, V value)
         * putAll(Map<? extends K, ? extends V> m)
         */
        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);
        System.out.println(map);  // {One=1, Three=3, Two=2}

        map.putIfAbsent("Four", 4);

        Map<String, Integer> moreNum = new HashMap<>();
        moreNum.put("Five", 5);
        moreNum.put("Six", 6);
        map.putAll(moreNum);
        System.out.println(map);   // {Five=5, Four=4, One=1, Six=6, Three=3, Two=2}

        /**
         * get(Object key)
         * firstKey()
         * lastKey()
         */
        System.out.println(map.get("Five"));    // 5
        System.out.println(map.firstKey());     // Five
        System.out.println(map.lastKey());      // Two

        /**
         * containsKey(Object key)
         * containsValue(Object value)
         */

        System.out.println(map.containsKey("Five"));   // true
        System.out.println(map.containsValue(5));      // true

        /**
         * keySet()
         * values()
         * isEmpty()
         */
        System.out.println(map.keySet());    // [Five, Four, One, Six, Three, Two]
        System.out.println(map.values());    // [5, 4, 1, 6, 3, 2]
        System.out.println(map.isEmpty());   // false

    }

    /**
     * replace(K key, V oldValue, V newValue)
     * replace(K key, V value)
     *
     * remove(Object key)
     */
    @Test
    public void learn_Remove_Replacing_Updating() {
        /**
         * replace(K key, V oldValue, V newValue)
         * replace(K key, V value)
         */
        TreeMap<String, Integer> map = new TreeMap<>();
        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);

        map.replace("Three", 3, 6);
        System.out.println(map);   // {One=1, Three=6, Two=2}
        map.replace("Three", 3);
        System.out.println(map);    // {One=1, Three=3, Two=2}

        /**
         * remove(Object key)
         */
        map.remove("Two");
        map.remove("Three",1); //not success because of wrong value
        System.out.println(map);    // {One=1, Three=3}

    }
}
