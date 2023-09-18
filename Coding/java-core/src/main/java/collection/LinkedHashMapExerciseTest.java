package collection;

import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

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
        Map<String, Integer> map = new LinkedHashMap<>();

        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);

        System.out.println("Contains Key 'Two': " + map.containsKey("Two"));
        System.out.println("Contains Value 3: " + map.containsValue(3));
        System.out.println("Value for Key 'Two': " + map.get("Two"));
        System.out.println("Value for Non-Existent Key 'Four' with Default Value: " +  map.getOrDefault("Four", 0));

        System.out.println("Keys in the Map: " + map.keySet());
        System.out.println("Values in the Map: " + map.values());
        System.out.println("Is Map Empty: " + map.isEmpty());

        map.putIfAbsent("Four", 4);
        System.out.println("Inserted Key-Value Pair 'Four' - Value: " + map.get("Four"));

        Map<String, Integer> anotherMap = Map.of("Five", 5, "Six", 6);
        map.putAll(anotherMap);
        System.out.println("Inserted Key-Value Pairs from Another Map: " + map.keySet() + ", " + map.values());
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

        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);

        map.replace("Two", 2, 22);
        map.replace("Three", 33);
        map.replaceAll((key, oldValue) -> oldValue * 10);
        map.remove("One");

        map.compute("Four", (key, value) -> value == null ? 4 : value + 4);

        map.computeIfAbsent("Five", key -> 5);

        map.computeIfPresent("Three", (key, value) -> value + 3);

        System.out.println("Updated LinkedHashMap: " + map);
    }
}
