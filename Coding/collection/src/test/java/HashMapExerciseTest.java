import org.junit.jupiter.api.Test;

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
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 2);
        map.putIfAbsent("c", 3);
        map.putAll(Map.of("d", 4, "e", 5));
        map.get("a");
        map.getOrDefault("f", 6);
        map.containsKey("a");
        map.containsValue(1);
        map.keySet();
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
        map.put("a", 1);
        map.put("b", 2);
        map.replace("a", 1, 3);
        map.replace("b", 4);
        map.replaceAll((k, v) -> v * 2);
        map.remove("a");
        map.remove("b", 4);
        map.compute("a", (k, v) -> v * 2);
        map.computeIfAbsent("b", k -> 2);
        map.computeIfPresent("c", (k, v) -> v * 2);
    }
}