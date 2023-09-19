package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.HashMap;
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
        HashMap<String, Integer> d = new LinkedHashMap<>();
        d.put("apple",1);
        d.putIfAbsent("apple",2);
        Map<String, Integer> d2 = new HashMap<>();
        d2.put("orange", 5);
        d.putAll(d2);
        System.out.println(d);
        System.out.println(d.get("Apple"));
        System.out.println(d.getOrDefault("cherry",7));
        System.out.println(d.containsKey("Apple"));
        System.out.println(d.containsValue("Apple"));
        System.out.println(d.keySet());
        System.out.println(d.values());
        System.out.println(d.isEmpty());
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
        HashMap<String, Integer> d = new LinkedHashMap<>();
        d.put("apple",1);
        d.replace("apple",2);
        System.out.println(d);
        d.replaceAll((key, oldValue) -> oldValue  +10);
        d.remove("apple");
        d.put("orange",1);
        d.compute("orange", (key, value) -> (value == null) ? 40 : value + 40);
        System.out.println(d);
        d.computeIfAbsent("apple", key -> 50);
        System.out.println(d);
        d.computeIfPresent("apple", (key, value) -> value + 100);
        System.out.println(d);
    }
}
