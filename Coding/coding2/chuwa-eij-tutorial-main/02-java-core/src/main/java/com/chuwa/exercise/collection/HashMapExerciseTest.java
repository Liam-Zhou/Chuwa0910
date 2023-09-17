package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

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
        Map<String, Integer> map = new HashMap<>();

        // put(K key, V value)
        map.put("one", 1);
        map.put("two", 2);
        System.out.println("After inserting key-value pairs: " + map);

        // putIfAbsent(K key, V value)
        map.putIfAbsent("three", 3);
        map.putIfAbsent("one", 11);  // This won't update since key "one" is already present
        System.out.println("After using putIfAbsent: " + map);

        // putAll(Map<? extends K, ? extends V> m)
        Map<String, Integer> anotherMap = new HashMap<>();
        anotherMap.put("four", 4);
        anotherMap.put("five", 5);
        map.putAll(anotherMap);
        System.out.println("After putting all from another map: " + map);

        // get(Object key)
        System.out.println("Get value for key 'one': " + map.get("one"));

        // getOrDefault(Object key, V defaultValue)
        System.out.println("Get value for key 'six' (default to 0): " + map.getOrDefault("six", 0));

        // containsKey(Object key)
        System.out.println("Contains key 'one': " + map.containsKey("one"));

        // containsValue(Object value)
        System.out.println("Contains value 3: " + map.containsValue(3));

        // keySet()
        System.out.println("Key set: " + map.keySet());

        // values()
        System.out.println("Values: " + map.values());

        // isEmpty()
        System.out.println("Is map empty: " + map.isEmpty());
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
        Map<String, Integer> map = new HashMap<>();
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);

        // replace(K key, V oldValue, V newValue)
        map.replace("two", 2, 22);
        System.out.println("After replacing value of key 'two': " + map);

        // replace(K key, V value)
        map.replace("three", 33);
        System.out.println("After simple replacing value of key 'three': " + map);

        // replaceAll(BiFunction<? super K, ? super V, ? extends V> function)
        map.replaceAll((key, value) -> value * 10);
        System.out.println("After replacing all values using BiFunction: " + map);

        // remove(Object key)
        map.remove("one");
        System.out.println("After removing key 'one': " + map);

        // remove(Object key, Object value)
        map.remove("two", 220);  // This will remove since key-value match
        System.out.println("After removing key 'two' with value 220: " + map);

        // compute(Key, BiFunction)
        map.compute("three", (key, value) -> value + 10);
        System.out.println("After computing value for key 'three': " + map);

        // computeIfAbsent(Key, Function)
        map.computeIfAbsent("four", k -> 44);
        System.out.println("After computing if absent for key 'four': " + map);

        // computeIfPresent(Key, BiFunction)
        map.computeIfPresent("three", (key, value) -> value * 10);
        System.out.println("After computing if present for key 'three': " + map);
    }
}
