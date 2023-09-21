package com.chuwa.exercise.collection;

import org.junit.Test;

import java.time.DayOfWeek;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.IdentityHashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author b1go
 * @date 6/12/22 4:48 PM
 */
public class AdditionalMapExerciseTest {

    /**
     * e.g.
     * ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
     *
     * put(K key, V value)
     * putIfAbsent(K key, V value)
     * putAll(Map<? extends K, ? extends V> m)
     */
    @Test
    public void learn_ConcurrentHashMap() {
        // Initializing
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

        // put operation
        map.put("key1", 1);
        System.out.println("Value for key1 after put: " + map.get("key1"));

        // putIfAbsent operation
        map.putIfAbsent("key1", 2);
        map.putIfAbsent("key2", 2);
        System.out.println("Value for key1 after putIfAbsent: " + map.get("key1"));
        System.out.println("Value for key2 after putIfAbsent: " + map.get("key2"));

        // putAll operation
        HashMap<String, Integer> sourceMap = new HashMap<>();
        sourceMap.put("key3", 3);
        sourceMap.put("key4", 4);
        map.putAll(sourceMap);
        System.out.println("Value for key3 after putAll: " + map.get("key3"));
        System.out.println("Value for key4 after putAll: " + map.get("key4"));
    }

    /**
     * e.g.
     * Map<DayOfWeek, Integer> map = new IdentityHashMap<>();
     *
     * put(K key, V value)
     * putIfAbsent(K key, V value)
     */
    @Test
    public void learn_IdentityHashMap() {
        // Initializing
        IdentityHashMap<DayOfWeek, Integer> map = new IdentityHashMap<>();
        DayOfWeek key1 = DayOfWeek.MONDAY;
        DayOfWeek key2 = DayOfWeek.TUESDAY;

        // put operation
        map.put(key1, 1);
        System.out.println("Value for key1 (MONDAY) after put: " + map.get(key1));

        // putIfAbsent operation
        map.putIfAbsent(key1, 2);
        map.putIfAbsent(key2, 2);
        System.out.println("Value for key1 (MONDAY) after putIfAbsent: " + map.get(key1));
        System.out.println("Value for key2 (TUESDAY) after putIfAbsent: " + map.get(key2));
    }

    /**
     * e.g.
     * EnumMap<DayOfWeek, Integer> enumMap = new EnumMap<>(DayOfWeek.class);
     *
     * put(K key, V value)
     * putIfAbsent(K key, V value)
     */
    @Test
    public void learn_EnumMap() {
        // Initializing
        EnumMap<DayOfWeek, Integer> enumMap = new EnumMap<>(DayOfWeek.class);

        // put operation
        enumMap.put(DayOfWeek.MONDAY, 1);
        System.out.println("Value for MONDAY after put: " + enumMap.get(DayOfWeek.MONDAY));

        // putIfAbsent operation
        enumMap.putIfAbsent(DayOfWeek.MONDAY, 2);
        enumMap.putIfAbsent(DayOfWeek.TUESDAY, 2);
        System.out.println("Value for MONDAY after putIfAbsent: " + enumMap.get(DayOfWeek.MONDAY));
        System.out.println("Value for TUESDAY after putIfAbsent: " + enumMap.get(DayOfWeek.TUESDAY));
    }
}
