package com.chuwa.exercise.collection;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import org.junit.Test;

/**
 * @author b1go
 * @date 6/12/22 4:47 PM
 */
public class HashMapExerciseTest {

    /**
     * e.g.
     * Map<String, Integer> map = new HashMap<>();
     *
     * put(K key, V value)
     * putIfAbsent(K key, V value)
     * putAll(Map<? extends K, ? extends V> m)
     *
     * get(Object key)
     * getOrDefault(Object key, V defaultValue)
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
        // Create a HashMap
        Map<String, Integer> map = new HashMap<>();

        // insert
        map.put("Apple", 1);
        map.put("Banana", 2);

        // get a value by key
        int appleValue = map.get("Apple");

        // check if a key exists
        boolean containsKey = map.containsKey("Banana");

        // get the set of keys in the map, like map.keys() in python
        Set<String> keys = map.keySet();

        /* Get a collections of values in the map, like map.values() in python */
        Collection<Integer> values = map.values();

        // check if the map is empty
        boolean isEmpty = map.isEmpty();
    }

    /**
     * replace(K key, V oldValue, V newValue)
     * replace(K key, V value)
     * replaceAll(BiFunction<? super K, ? super V, ? extends V> function)
     *
     * remove(Object key)
     * remove(Object key, Object value)
     *
     * compute(Key, BiFunction)
     * computeIfAbsent(Key, Function)
     * computeIfPresent(Key, BiFunction)
     */
    @Test
    public void learn_Remove_Replacing_Updating() {
        Map<String, Integer> map = new HashMap<>();
        map.put("Apple", 1);
        map.put("Banana", 2);

        // replace old value 1 with new value 3
        map.replace("Apple", 1, 3);

        // remove a pair
        map.remove("Banana");

        // use replace All to modify all values in the map
        map.replaceAll((key, value) -> value * 2);

        // compute a new value for a key
        map.compute("Cherry", (key, oldValue) -> oldValue == null ? 1 :oldValue + 2);

        // compute a value if absent
        map.computeIfAbsent("Orange", key -> 4);

        // compute a value if present
        map.computeIfPresent("Banana", (key, oldValue) -> oldValue * 3);

    }
}
