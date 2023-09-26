package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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
        Map<String, Integer> map = new HashMap<>();
        map.put("Apple", 5);
        map.putIfAbsent("Banana", 8);
        Map<String, Integer> map2 = new HashMap<>();
        map2.put("Orange", 3);
        map2.put("Cherry", 99);
        map.putAll(map2); // potentially
        System.out.println(map);
        System.out.println(map.get("Banana"));
        System.out.println(map.getOrDefault("Strawberry", 0));
        System.out.println(map.containsKey("Cherry"));
        System.out.println(map.containsValue(9));


        Set<String> keyset = map.keySet(); // returns a set of the same data type
        System.out.println(keyset);

        // values() returns a view of all values
        // for-each loop access each value from the view
        for(int value: map.values()) {
            System.out.println(value + ", ");
        }

        System.out.println(map.isEmpty());
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
        map.put("Apple", 5);
        map.put("Peach", 5);
        map.putIfAbsent("Banana", 8);
        map.put("Orange", 3);
        map.put("Cherry", 99);
        map.replace("Orange", 2);
        System.out.println(map);
        map.replace("Cherry", 99, 98);
        System.out.println(map);

        map.replaceAll((key, value) -> value - 1);
        System.out.println(map);

        map.remove("Orange", 1);
        // Or map.remove("Orange");
        System.out.println(map);

        map.compute("Cherry", (key, value) -> value+10);
        map.computeIfPresent("Peach", (key,value) -> value +10);
        map.computeIfAbsent("Grape", value -> 20);
        System.out.println(map);
    }
}
