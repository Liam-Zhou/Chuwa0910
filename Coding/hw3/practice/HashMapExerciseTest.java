
import org.junit.Test;
import java.util.*;

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
        map.put("one",1);
        map.putIfAbsent("two", 2);
        //map putAll( another map name);
        map.isEmpty();
        System.out.println(map.keySet());
        System.out.println(map.values());
        System.out.println(map.containsKey(map.keySet().iterator().next()));
        System.out.println(map.containsValue(4));

    }

    /**
     * replace(K key, V oldValue, V newValue)
     * replace(K key, V value)
     * replaceAll(BiFunction<? super K, ? super V, ? extends V> function) // ?
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
        map.put("one",1);
        map.putIfAbsent("two", 2);
        map.replace("one", 2);
        map.replace("one", 1,2);
        //replaceAll?
        //what is bi-function

    }
}
