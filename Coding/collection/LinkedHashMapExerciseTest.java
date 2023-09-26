package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.*;

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

        HashMap <String, Integer> mp = new LinkedHashMap<>();


        mp.put("apple", 1);
        mp.put("banana", 2);
        mp.put("pear",3);
        System.out.println(mp);

        mp.putIfAbsent("grape", 5);

        HashMap<String, Integer> new_mp = new LinkedHashMap<>();
        new_mp.putAll(mp);
        System.out.println(new_mp);


        int a = mp.get("apple");
        System.out.println(a);

        int b = mp.getOrDefault("water", 7);
        System.out.println(b);


        System.out.println(mp.containsKey("apple"));
        System.out.println(mp.containsValue(6));


        Set <String> st = mp.keySet();
        System.out.println("Key set is:" + st);

        Collection <Integer> val = mp.values();
        System.out.println("Value is" + val);

        System.out.println(mp.isEmpty());



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

        HashMap <String, Integer> mp = new LinkedHashMap<>();


        mp.put("apple", 1);
        mp.put("banana", 2);
        mp.put("pear",3);
        System.out.println(mp);
        
        mp.replace("apple", 1, 4);
        mp.replace("pear", 5);
        System.out.println(mp);

        mp.replaceAll((key,val)->val+1);
        System.out.println("After replace all:"+mp);

        mp.remove("apple");
        mp.remove("pear", 6);
        System.out.println(mp);

        mp.compute("banana",(k,v)->v==null?2:7);
        System.out.println(mp);

        mp.computeIfAbsent("apple", v->3);
        System.out.print(mp);

        mp.computeIfPresent("apple", (k,v)->v==null?0:5);
        System.out.print(mp);
    }
}
