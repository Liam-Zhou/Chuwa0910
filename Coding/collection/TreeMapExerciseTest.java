package com.chuwa.exercise.collection;

import org.junit.Test;

import apple.laf.JRSUIUtils.Tree;

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

        TreeMap<String,Integer> mp = new TreeMap<>();

        mp.put("banana", 2);
        mp.put("apple", 7);
        mp.put("pear",5);
        System.out.println(mp);

        mp.putIfAbsent("grape", 1);
        System.out.println(mp);

        TreeMap <String, Integer> new_mp = new TreeMap<>();
        new_mp.putAll(mp);
        System.out.println(new_mp);

        int a = mp.get("apple");
        System.out.println(a);
        
        String s = mp.firstKey();
        System.out.println("First key is:" + s);
        String b = mp.lastKey();
        System.out.println("last key is:" + b);

        
        System.out.println(mp.containsKey("apple"));
        System.out.println(mp.containsValue(6));

        Set<String> st = mp.keySet();
        System.out.println(st);

        Collection<Integer> val = mp.values();
        System.out.println(val);

        mp.clear();
        System.out.println(mp.isEmpty());




    }

    /**
     * replace(K key, V oldValue, V newValue)
     * replace(K key, V value)
     *
     * remove(Object key)
     */
    @Test
    public void learn_Remove_Replacing_Updating() {

        TreeMap<String,Integer> mp = new TreeMap<>();

        mp.put("banana", 2);
        mp.put("apple", 7);
        mp.put("pear",5);
        System.out.println(mp);
        
        mp.replace("apple", 7, 4);
        mp.replace("pear", 3);
        System.out.println(mp);

        mp.remove("apple");
        System.out.println(mp);

    }
}
