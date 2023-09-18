package com.chuwa.exercise.collection;

import org.junit.Test;

import java.time.DayOfWeek;
import java.util.*;
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
        Map<String,Integer> map = new HashMap<>();
        map.put("a",1);
        map.put("b",2);

        ConcurrentHashMap<String,Integer> coMap = new ConcurrentHashMap<>();
        coMap.put("d",3);
        coMap.put("e",4);
        coMap.putIfAbsent("d",4);
        coMap.putAll(map);
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
        Map<String,Integer> map = new IdentityHashMap<>();
        map.put("a",1);
        map.putIfAbsent(new String("a"),2);
        System.out.println(map);
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
        EnumMap<DayOfWeek,Integer> map = new EnumMap<>(DayOfWeek.class);
        map.put(DayOfWeek.SATURDAY,1);
        map.put(DayOfWeek.FRIDAY,1000);
        map.putIfAbsent(DayOfWeek.SATURDAY,2);
        System.out.println(map);
    }
}
