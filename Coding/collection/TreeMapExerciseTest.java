package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;

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
        TreeMap<String, Integer> map = new TreeMap<>();

        // put(K key, V value)
        map.put("apple", 5);
        map.put("banana", 7);
        map.put("cherry", 3);
        System.out.println("After put(): " + map);

        // putIfAbsent(K key, V value)
        map.putIfAbsent("banana", 10);
        map.putIfAbsent("date", 4);
        System.out.println("After putIfAbsent(): " + map);  // banana's value remains 7, date added with value 4

        // putAll(Map<? extends K, ? extends V> m)
        Map<String, Integer> anotherMap = new TreeMap<>();
        anotherMap.put("eggfruit", 2);
        anotherMap.put("fig", 6);
        map.putAll(anotherMap);
        System.out.println("After putAll(): " + map);

        // get(Object key)
        System.out.println("Value of 'banana': " + map.get("banana"));

        // firstKey()
        System.out.println("First key: " + map.firstKey());

        // lastKey()
        System.out.println("Last key: " + map.lastKey());

        // containsKey(Object key)
        System.out.println("Contains 'apple' key: " + map.containsKey("apple"));

        // containsValue(Object value)
        System.out.println("Contains value 4: " + map.containsValue(4));

        // keySet()
        System.out.println("Key set: " + map.keySet());

        // values()
        System.out.println("Values: " + map.values());

        // isEmpty()
        System.out.println("Is empty: " + map.isEmpty());
    }

    /**
     * replace(K key, V oldValue, V newValue)
     * replace(K key, V value)
     *
     * remove(Object key)
     */
    @Test
    public void learn_Remove_Replacing_Updating() {
        TreeMap<String, Integer> map = new TreeMap<>();

        map.put("apple", 5);
        map.put("banana", 7);
        map.put("cherry", 3);
        System.out.println("Initial map: " + map);

        // replace(K key, V oldValue, V newValue)
        map.replace("banana", 7, 8);  // replaces the value of "banana" if its current value is 7
        System.out.println("After replacing 'banana' from 7 to 8: " + map);

        // replace(K key, V value)
        map.replace("cherry", 10);  // simply replaces the value of "cherry" regardless of its current value
        System.out.println("After replacing 'cherry' to 10: " + map);

        // remove(Object key)
        map.remove("apple");
        System.out.println("After removing 'apple': " + map);
    }
}
