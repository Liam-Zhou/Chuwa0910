package com.chuwa.exercise.collection;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.time.DayOfWeek;
import java.util.EnumMap;
import java.util.IdentityHashMap;
import java.util.Map;
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
        ConcurrentHashMap<String, Integer> map1 = new ConcurrentHashMap<>();
        ConcurrentHashMap<String, Integer> map2 = new ConcurrentHashMap<>();
        map1.put("Grace", 5);
        map1.putIfAbsent("Grace", 3); //nothing change
        map1.put("Alice", 7);

        map2.put("Nancy", 2);
        map2.put("Tina", 1);
        map2.put("Jessica", 1); //NO overwrite! add the pair together.
                                // ConcurrentHashMap allows multiple keys to map to the same value.

        map1.putAll(map2);
        System.out.println("Merged Map (map1): " + map1);

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
        Map<DayOfWeek, Integer> map = new IdentityHashMap<>();
        map.put(DayOfWeek.MONDAY, 1);
        map.putIfAbsent(DayOfWeek.MONDAY, 2);
        //map.put(DayOfWeek.MONDAY, 2); //overwrite
        map.put(DayOfWeek.TUESDAY, 2);
        int value = map.getOrDefault(DayOfWeek.MONDAY, 0);
        System.out.println(value);

    }

    public enum weekDays {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY
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
        EnumMap<weekDays, Integer> enumMap = new EnumMap<>(weekDays.class);
        enumMap.put(weekDays.FRIDAY, 5);
        enumMap.putIfAbsent(weekDays.MONDAY, 1);
        System.out.println(enumMap);

    }
}