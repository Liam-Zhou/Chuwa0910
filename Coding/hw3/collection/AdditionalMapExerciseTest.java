package com.chuwa.exercise.collection;

import org.junit.Test;

import java.time.DayOfWeek;
import java.util.EnumMap;
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
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        map.put("key1", 1);
        System.out.println("Value for key1 after put: " + map.get("key1"));

        // putIfAbsent operation
        map.putIfAbsent("key1", 2);
        map.putIfAbsent("key2", 2);
        System.out.println("Value for key1 after putIfAbsent: " + map.get("key1"));
        System.out.println("Value for key2 after putIfAbsent: " + map.get("key2"));
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
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        map.put("key1", 1);
        System.out.println("Value for key1 after put: " + map.get("key1"));
        map.putIfAbsent("key1", 2);
        map.putIfAbsent("key2", 2);
        System.out.println("Value for key1 after putIfAbsent: " + map.get("key1"));
        System.out.println("Value for key2 after putIfAbsent: " + map.get("key2"));
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
        EnumMap<DayOfWeek, Integer> enumMap = new EnumMap<>(DayOfWeek.class);
        enumMap.put(DayOfWeek.MONDAY, 1);
        System.out.println("Value for MONDAY after put: " + enumMap.get(DayOfWeek.MONDAY));
    }
}
