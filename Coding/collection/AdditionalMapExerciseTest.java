package com.chuwa.exercise.collection;

import java.time.DayOfWeek;
import java.util.EnumMap;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.junit.Test;

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

        ConcurrentHashMap<String, Integer> mp = new ConcurrentHashMap<>();
        mp.put("apple",1);
        mp.put("banana",3);
        mp.put("pear", 5);
        System.out.println(mp);

        mp.putIfAbsent("grape", 7);

        ConcurrentHashMap<String, Integer> new_map = new ConcurrentHashMap<>();
        new_map.putAll(mp);
        System.out.println(new_map);

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
        
        Map<DayOfWeek, Integer> mp = new IdentityHashMap<>();

        mp.put(DayOfWeek.MONDAY, 1);
        mp.put(DayOfWeek.TUESDAY, 2);
        mp.put(DayOfWeek.FRIDAY,5);

        mp.putIfAbsent(DayOfWeek.FRIDAY, 3);

        System.out.println(mp);





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

        EnumMap<DayOfWeek, Integer> em = new EnumMap<>(DayOfWeek.class);
        em.put(DayOfWeek.MONDAY, 1);
        em.put(DayOfWeek.TUESDAY,2);
        em.put(DayOfWeek.FRIDAY, 5);

        System.out.println(em);

        em.putIfAbsent(DayOfWeek.SATURDAY, 6);
        System.out.println(em);



        



    }
}
