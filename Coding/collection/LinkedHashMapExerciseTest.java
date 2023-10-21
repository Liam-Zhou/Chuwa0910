package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

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
        map.put("Apple", 5);
        map.putIfAbsent("Banana", 8);
        Map<String, Integer> map2 = new LinkedHashMap<>();
        map2.put("Orange", 3);
        map2.put("Cherry", 99);
        map.putAll(map2); // sort by key's insert order
        System.out.println(map);

        System.out.println(map.get("Cherry"));
        System.out.println(map.getOrDefault("Peach", 0));
        System.out.println(map.containsKey("Orange"));
        System.out.println(map.containsValue(5));

        Set<String> set = map.keySet();
        System.out.println(set);
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
        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("Apple", 5);
        map.putIfAbsent("Banana", 8);
        Map<String, Integer> map2 = new LinkedHashMap<>();
        map2.put("Orange", 3);
        map2.put("Cherry", 99);
        map.putAll(map2);

        map.replace("Apple", 3);
        map.replaceAll((key, value) -> value+10);
        map.remove("Apple");
        System.out.println(map);

        map.compute("Orange", (key, value) -> value+2);
        System.out.println(map);
        map.computeIfPresent("Orange", (key, value) -> value+2);
        map.computeIfAbsent("Durian", value -> 99);
        System.out.println(map);


    }
}
