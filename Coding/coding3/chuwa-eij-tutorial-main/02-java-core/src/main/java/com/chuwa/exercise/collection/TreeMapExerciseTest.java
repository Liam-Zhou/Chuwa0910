package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.HashMap;
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

        // put
        map.put("one", 1);
        map.put("two", 2);
        System.out.println("TreeMap after inserting: " + map);

        // putIfAbsent
        map.putIfAbsent("three", 3);
        map.putIfAbsent("two", 22);
        System.out.println("TreeMap after using putIfAbsent: " + map);

        // putAll
        Map<String, Integer> anotherMap = new HashMap<>();
        anotherMap.put("four", 4);
        anotherMap.put("five", 5);
        map.putAll(anotherMap);
        System.out.println("TreeMap after putting all from another map: " + map);

        // get
        System.out.println("Value for 'three': " + map.get("three"));

        // firstKey and lastKey
        System.out.println("First key: " + map.firstKey());
        System.out.println("Last key: " + map.lastKey());

        // containsKey and containsValue
        System.out.println("Contains 'two' key? " + map.containsKey("two"));
        System.out.println("Contains value 5? " + map.containsValue(5));

        // keySet and values
        System.out.println("All keys: " + map.keySet());
        System.out.println("All values: " + map.values());

        // isEmpty
        System.out.println("Is the map empty? " + map.isEmpty());
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
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        System.out.println("Initial TreeMap: " + map);

        // replace
        map.replace("two", 2, 22);
        map.replace("three", 33);
        System.out.println("TreeMap after replacements: " + map);

        // remove
        map.remove("one");
        System.out.println("TreeMap after removing 'one': " + map);
    }
}
