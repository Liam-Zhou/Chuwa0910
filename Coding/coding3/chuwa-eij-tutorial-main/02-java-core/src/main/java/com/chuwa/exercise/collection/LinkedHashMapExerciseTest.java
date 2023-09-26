package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.HashMap;
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
        HashMap<String, Integer> map = new LinkedHashMap<>();

        // Insertion
        map.put("one", 1);
        System.out.println("After put(\"one\", 1): " + map);

        map.putIfAbsent("one", 10);
        System.out.println("After putIfAbsent(\"one\", 10): " + map);

        Map<String, Integer> anotherMap = new HashMap<>();
        anotherMap.put("two", 2);
        anotherMap.put("three", 3);
        map.putAll(anotherMap);
        System.out.println("After putAll(anotherMap): " + map);

        // Retrieving
        System.out.println("Get \"one\": " + map.get("one"));
        System.out.println("GetOrDefault \"four\": " + map.getOrDefault("four", 4));

        System.out.println("Contains key \"two\": " + map.containsKey("two"));
        System.out.println("Contains value 3: " + map.containsValue(3));

        System.out.println("Key set: " + map.keySet());
        System.out.println("Values: " + map.values());
        System.out.println("Is empty: " + map.isEmpty());
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
        HashMap<String, Integer> map = new LinkedHashMap<>();

        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);

        // Replacing
        map.replace("one", 10);
        System.out.println("After replace(\"one\", 10): " + map);

        map.replace("two", 2, 20);
        System.out.println("After replace(\"two\", 2, 20): " + map);

        map.replaceAll((key, value) -> value * 10);
        System.out.println("After replaceAll(value * 10): " + map);

        // Removing
        map.remove("three");
        System.out.println("After remove(\"three\"): " + map);

        map.remove("one", 100);
        System.out.println("After remove(\"one\", 100): " + map);

        // Compute
        map.compute("one", (key, value) -> value == null ? 1 : value + 1);
        System.out.println("After compute(\"one\"): " + map);

        map.computeIfAbsent("four", key -> 4);
        System.out.println("After computeIfAbsent(\"four\"): " + map);

        map.computeIfPresent("four", (key, value) -> value + 1);
        System.out.println("After computeIfPresent(\"four\"): " + map);
    }
}
