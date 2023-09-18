package com.chuwa.exercise.collection;

import org.junit.Test;
import java.util.HashMap;
import java.util.Map;
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
        HashMap<String, Integer> map = new HashMap<>();
        map.put("a",1);
        map.put("b",2);
        map.putIfAbsent("a",2); //"a" is still 1
        System.out.println(map);

        Map<String, Integer> elementsToAdd = Map.of("c", 3, "d", 4);
        map.putAll(elementsToAdd);
        System.out.println(map);
        System.out.println(map.get("c"));
        System.out.println(map.getOrDefault("e", 0));

        System.out.println(map.containsKey("a"));
        System.out.println(map.containsValue(5));

        System.out.println(map.keySet());
        System.out.println(map.values());

        System.out.println(map.isEmpty());
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
        HashMap<String, Integer> map = new HashMap<>();
        map.put("a",1);
        map.put("b",2);
        map.put("c",3);
        map.put("d",4);
        System.out.println(map);
        map.replace("a", 1, 5);
        System.out.println(map);
        map.replace("a", 1, 6); //fail
        System.out.println(map);
        map.replace("a", 6);
        System.out.println(map);
        map.replaceAll((key, value)-> value*2);
        System.out.println(map);

        map.remove("a");
        map.remove("b", 5); //fail

        map.compute("c", (key, oldValue) -> oldValue * 2);
        map.computeIfAbsent("c", key -> 3); //not change
        map.computeIfAbsent("e", key -> 5);
        map.computeIfPresent("b", (key, value) -> value * 2);
        map.computeIfPresent("z", (key, value) -> 3); // fail
    }
}
