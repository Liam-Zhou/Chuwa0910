package com.chuwa.exercise.collection;

import org.junit.Test;
import java.util.*;

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
        Map<String ,Integer> map = new HashMap<>();
        map.put("apple" ,1);
        map.putIfAbsent("apple", 2);
        Map<String, Integer> otherMap = new HashMap<>();
        otherMap.put("grape", 4);
        otherMap.put("kiwi", 6);
        map.putAll(otherMap);
        map.get("apple");
        map.getOrDefault("apple", 0);
        map.containsKey("pear");
        map.containsValue(2);
        map.keySet();
        map.values();
        map.isEmpty();
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
        Map<String ,Integer> map = new HashMap<>();
        map.put("apple" ,1);
        map.replace("apple", 1, 3);
        map.replace("apple", 2);
        map.replaceAll((key, value) -> value * 2);

        map.remove("apple");
        map.put("apple", 3);
        map.remove("apple" , 2);

        map.compute("apple", (key, value) -> value *2);
    }
}
