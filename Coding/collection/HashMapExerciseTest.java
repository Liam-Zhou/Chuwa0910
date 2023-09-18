package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

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

        map.put("One", 1);
        System.out.println(map);

        map.put("Two", 2);
        System.out.println(map);

        map.put("Three", 3);
        System.out.println(map);

        map.putIfAbsent("Four", 4);
        System.out.println(map);

        map.putAll(Map.of("Five", 5, "Six", 6));
        System.out.println(map);

        System.out.println(map.get("Two"));

        System.out.println(map.getOrDefault("Seven", 0));

        System.out.println(map.containsKey("Three"));

        System.out.println(map.containsValue(6));

        System.out.println(map.keySet());

        System.out.println(map.values());

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

        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);
        System.out.println(map);

        System.out.println(map.replace("Two", 22));

        System.out.println(map.replace("One", 1, 11));

        map.replaceAll((key, value) -> value * 10);
        System.out.println(map);

        System.out.println(map.remove("Three"));

        System.out.println(map.remove("Two", 22));

        map.compute("Four", (key, value) -> value == null ? 4 : value * 4);
        System.out.println(map);

        map.computeIfAbsent("Five", key -> 55);
        System.out.println(map);

        map.computeIfPresent("Six", (key, value) -> value * 6);
        System.out.println(map);
    }
}
