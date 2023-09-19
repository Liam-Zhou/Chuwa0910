package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author b1go
 * @date 6/12/22 4:48 PM
 */
public class LinkedHashMapExerciseTest {
    /**
     * e.g.
     * HashMap<String, Integer> map = new LinkedHashMap<>();
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
        Map<String, Integer> map = new LinkedHashMap<>();

        System.out.println(map);

        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);
        System.out.println(map);

        map.putIfAbsent("Four", 4);
        System.out.println(map);

        map.putAll(Map.of("Five", 5, "Six", 6));
        System.out.println(map);

        System.out.println(map.get("One"));

        System.out.println(map.getOrDefault("two", 0));

        System.out.println(map.containsKey("three"));

        System.out.println(map.containsValue(4));

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
        Map<String, Integer> map = new LinkedHashMap<>();

        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);
        System.out.println(map);

        map.replace("One", 1, 11);
        System.out.println(map);

        map.replace("One", 22);
        System.out.println(map);

        map.replaceAll((key, value) -> value * 10);
        System.out.println(map);

        map.remove("One");
        System.out.println(map);

        map.remove("Two", 22);
        System.out.println(map);

        map.compute("Three", (key, value) -> value == null ? 4 : value * 4);
        System.out.println(map);

        map.computeIfAbsent("Four", key -> 55);
        System.out.println(map);

        map.computeIfPresent("Five", (key, value) -> value * 6);
        System.out.println(map);
    }
}
