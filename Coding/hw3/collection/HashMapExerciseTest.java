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

        // put(K key, V value)
        map.put("one", 1);
        map.put("two", 2);
        System.out.println("After inserting key-value pairs: " + map);

        // putIfAbsent(K key, V value)
        map.putIfAbsent("three", 3);
        map.putIfAbsent("one", 11);  // This won't update since key "one" is already present
        System.out.println("After using putIfAbsent: " + map);

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
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.replace("two", 2, 22);
        map.replace("three", 33);
        System.out.println("After simple replacing value of key 'three': " + map);
        map.replaceAll((key, value) -> value * 10);
        System.out.println("After replacing all values using BiFunction: " + map);

    }
}
