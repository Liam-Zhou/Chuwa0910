package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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
        Map<String,Integer> d = new HashMap<>();
        d.put("apple",1);
        System.out.println(d);
        d.putIfAbsent("apple",2);
        System.out.println(d);
        Map<String,Integer> d2 = new HashMap<>();
        d2.put("orange",1);
        d.putAll(d2);
        System.out.println(d);
        System.out.println(d.get("apple"));
        d.getOrDefault("cherry",4);
        System.out.println(d);
        System.out.println(d.containsKey("orange"));
        System.out.println(d.containsValue(1));
        System.out.println(d.values());
        System.out.println(d.isEmpty());

        Set<String> keys = d.keySet();
        System.out.println(keys);

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
        Map<String,Integer> d = new HashMap<>();
        System.out.println(d);
        d.put("Apple",1);
        d.replace("Apple",1,3);
        d.replace("Apple",2);
        System.out.println(d);
        d.replaceAll((name, number) -> number + 1);
        System.out.println(d);
        d.remove("Apple");
        System.out.println(d);
        d.put("Apple",2);
        d.remove("Apple",1);
        System.out.println(d);
        d.compute("Apple",(name,number)->number + 2);
        System.out.println(d);
        d.computeIfAbsent("orange", name -> 40);
        System.out.println(d);
        d.computeIfPresent("Apple", (name, number) -> number + 5);
        System.out.println(d);
    }
}
