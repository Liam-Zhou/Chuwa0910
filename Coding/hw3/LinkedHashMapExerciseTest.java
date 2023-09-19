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
        Map<String,Integer> map = new LinkedHashMap<>();
        map.put("a",1);
        map.putIfAbsent("a",0);
        map.put("c",3);
        Map<String,Integer> map1 = new HashMap<>();
        map1.putAll(map);

        System.out.println(map1.get("a"));
        System.out.println(map1.getOrDefault("b",-1));

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
        Map<String,Integer> map = new LinkedHashMap<>();
        map.put("a",1);
        map.put("b",2);
        map.put("c",3);
        map.put("d",4);
        map.put("e",5);

        System.out.println("replace with wrong  " + map.replace("a",2,3));
        System.out.println(map.replace("b",1000));
        System.out.println(map.replace("f",1000));
        System.out.println("replaceAll");
        map.replaceAll((key,value)->value*2);
        System.out.println(map);

        map.remove("a");
        map.remove("b","3");
        System.out.println("After remove" + map);

        final int i=1;
        map.compute("c",(key,value)->(value+=i));
        map.computeIfAbsent("g",k-> 200+300);
        map.computeIfPresent("e",(k,v)-> v+20);
        System.out.println("After compute" + map);
    }
}
