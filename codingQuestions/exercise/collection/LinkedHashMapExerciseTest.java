package com.chuwa.exercise.collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Collection;
import java.util.Set;
import org.junit.Test;

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
        // LinkedHashMap has order, but HashMap doesn't have order
        Map<String, Integer> map = new LinkedHashMap<>();

        map.put("Apple", 1);
        map.put("Banana", 2);

        int appleValue = map.get("Apple"); // Retrieves 1

        boolean containsKey = map.containsKey("Cherry");

        Set<String> keys = map.keySet();

        Collection<Integer> values = map.values();

        boolean isEmpty = map.isEmpty();
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
        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("Apple", 1);
        map.put("Banana", 2);

        map.replace("Apple", 1, 3);

        map.remove("Banana");

        map.replaceAll((key, value) -> value * 2);

        map.compute("Cherry", (key, oldValue) -> oldValue == null ? 1 : oldValue + 1);

        map.computeIfAbsent("Orange", key -> 4);

        map.computeIfPresent("Banana", (key, oldValue) -> oldValue * 3);
    }
}
