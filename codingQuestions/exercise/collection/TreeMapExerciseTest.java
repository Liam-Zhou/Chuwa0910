package com.chuwa.exercise.collection;
import java.util.Map;
import java.util.TreeMap;
import java.util.Set;
import org.junit.Test;
import java.util.Collection;

/**
 * @author b1go
 * @date 6/12/22 4:47 PM
 */
public class TreeMapExerciseTest {

    /**
     * e.g.
     * TreeMap<String, Integer> map = new TreeMap<>();
     *
     * put(K key, V value)
     * putIfAbsent(K key, V value)
     * putAll(Map<? extends K, ? extends V> m)
     *
     * get(Object key)
     * firstKey()
     * lastKey()
     *
     * containsKey(Object key)
     * containsValue(Object value)
     *
     * keySet()
     * values()
     * isEmpty()
     */

    @Test
    public void learn_Inserting_And_Retrieving() {
        // TreeMap and LinkedList has defined order, but HashMap doesn't
        TreeMap<String, Integer> map = new TreeMap<>();
        map.put("Apple", 1);
        map.put("Banana", 2);
        map.put("Cherry", 3);
        int appleValue = map.get("Apple");

        String firstKey = map.firstKey();
        String lastKey = map.lastKey();

        boolean containsKey = map.containsKey("Banana");
        boolean containsValue = map.containsValue(3);

        Set<String> keys = map.keySet();
        Collection<Integer> values = map.values();
    }

    /**
     * replace(K key, V oldValue, V newValue)
     * replace(K key, V value)
     *
     * remove(Object key)
     */
    @Test
    public void learn_Remove_Replacing_Updating() {
        TreeMap<String, Integer> map = new TreeMap<>();
        map.put("Apple", 1);
        map.put("Banana", 2);
        // replace a value for a key (requires exact match)
        map.replace("Apple", 1, 3);

        // replace a value for a key (no need for exact match)
        map.replace("Banana", 4);

        // remove a key-value pair
        map.remove("Apple");
    }
}
