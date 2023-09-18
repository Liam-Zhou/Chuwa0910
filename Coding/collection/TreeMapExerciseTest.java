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

        System.out.println(map);

        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);
        map.putIfAbsent("Four", 4);

        System.out.println(map);

        map.putAll(Map.of("Five", 5, "Six", 6));

        System.out.println(map);

        System.out.println(map.get("Two"));

        System.out.println(map.firstKey());

        System.out.println(map.lastKey());

        System.out.println(map.containsKey("Three"));

        System.out.println(map.containsValue(6));

        System.out.println(map.keySet());

        System.out.println(map.values());

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
        TreeMap<String, Integer> map = new TreeMap<>();

        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);
        System.out.println(map);

        map.replace("Two", 2, 22);
        System.out.println(map);

        map.replace("One", 11);
        System.out.println(map);

        map.remove("Three");
        System.out.println(map);
    }
}
