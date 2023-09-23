package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.*;


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
        NavigableMap<String, Integer> map = new TreeMap<>();
        //The firstKey() method is not available directly on the java.util.Map interface.
        // It is a method provided by the NavigableMap interface. import java.util.*;
        map.put("Apple", 5);
        map.putIfAbsent("Banana", 8);
        NavigableMap<String, Integer> map2 = new TreeMap<>();
        map2.put("Orange", 3);
        map2.put("Cherry", 99);
        map.putAll(map2); // sort by key's alphabet
        System.out.println(map);

        System.out.println(map.get("Banana"));
        System.out.println(map.firstKey());
        System.out.println(map.lastKey());
        System.out.println(map.containsKey("Peach"));
        System.out.println(map.containsValue(6));

        Set<String> set = new HashSet<>(map.keySet());
        System.out.println(set);

        for(int value: map.values()) {
            System.out.println(value + ", ");
        }
        System.out.println(map.isEmpty());
    }

    /**
     * replace(K key, V oldValue, V newValue)
     * replace(K key, V value)
     *
     * remove(Object key)
     */
    @Test
    public void learn_Remove_Replacing_Updating() {
        NavigableMap<String, Integer> map = new TreeMap<>();
        //The firstKey() method is not available directly on the java.util.Map interface.
        // It is a method provided by the NavigableMap interface. import java.util.*;
        map.put("Apple", 5);
        map.putIfAbsent("Banana", 8);
        NavigableMap<String, Integer> map2 = new TreeMap<>();
        map2.put("Orange", 3);
        map2.put("Cherry", 99);
        map.putAll(map2); // sort by key's alphabet
        System.out.println(map);

        map.replace("Orange", 5);
        map.remove("Cherry");
        System.out.println(map);
    }
}
