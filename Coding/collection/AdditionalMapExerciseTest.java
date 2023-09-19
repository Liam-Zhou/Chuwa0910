package com.chuwa.exercise.collection;

import org.junit.Test;
import java.util.IdentityHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.EnumMap;
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

        map.put("one", 1);
        map.put("two", 2);

        map.putIfAbsent("three", 3);
        map.putIfAbsent("two", 22);  // 不会覆盖现有的值

        System.out.println(map.get("two"));  // 输出: 2

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
        Map<String, String> hashMap = new HashMap<>();
        Map<String, String> identityMap = new IdentityHashMap<>();

        hashMap.put(new String("key"), "value1");
        hashMap.put(new String("key"), "value2");

        identityMap.put(new String("key"), "value1");
        identityMap.put(new String("key"), "value2");

        System.out.println(hashMap.size());      // 输出: 1
        System.out.println(identityMap.size());  // 输出: 2
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

        // 使用 put 方法添加键值对
        enumMap.put(DayOfWeek.MONDAY, 1);
        enumMap.put(DayOfWeek.TUESDAY, 2);

        // 输出: 1
        System.out.println(enumMap.get(DayOfWeek.MONDAY));

        // 使用 putIfAbsent，如果对应的键已经有值，则不会进行任何操作
        enumMap.putIfAbsent(DayOfWeek.MONDAY, 10);  // 由于 MONDAY 已经有值，所以这不会有任何效果
        enumMap.putIfAbsent(DayOfWeek.WEDNESDAY, 3);

        // 输出: 1
        System.out.println(enumMap.get(DayOfWeek.MONDAY));
        // 输出: 3
        System.out.println(enumMap.get(DayOfWeek.WEDNESDAY));
    }
}
