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
        Map<String,Integer> map = new HashMap<>();
        map.put("c",3);
        map.put("a",1);
        map.putIfAbsent("a",0);
        map.put("c",3);
        TreeMap<String,Integer> map1 = new TreeMap<>();
        map1.putAll(map);
        map1.putIfAbsent("c",3);
        map1.put("d",4);
        map1.put("a",1);
        map1.putIfAbsent("b",2);
        map1.put("e",5);


        System.out.println(map1.get("c"));
        System.out.println("firt key " + map1.firstKey());
        System.out.println("last key " + map1.lastKey());

        System.out.println(map1.containsKey("a"));
        System.out.println(map1.containsValue(1));

        for(var key: map1.keySet()) {
            System.out.println(map1.get(key));
        }
        for(var value: map1.values()) {
            System.out.println(value);
        }
        System.out.println(map1.isEmpty());
    }



    /**
     * replace(K key, V oldValue, V newValue)
     * replace(K key, V value)
     *
     * remove(Object key)
     */
    @Test
    public void learn_Remove_Replacing_Updating() {
        TreeMap<String,Integer> map = new TreeMap<>();
        map.put("a",1);
        map.put("b",2);
        map.put("c",3);
        map.put("d",4);
        map.put("e",5);

        System.out.println("replace with wrong  " + map.replace("a",2,3));
        System.out.println(map.replace("b",1000));
        System.out.println(map.replace("f",1000));
    }
}
