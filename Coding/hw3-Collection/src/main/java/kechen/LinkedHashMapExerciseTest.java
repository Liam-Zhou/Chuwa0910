package kechen;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapExerciseTest {

    @Test
    public void learn_Inserting_And_Retrieving() {
        /**
         * e.g.
         * HashMap<String, Integer> map = new LinkedHashMap<>();
         */
        HashMap<String, Integer> map = new LinkedHashMap<>();

        /**
         * put(K key, V value)
         * putIfAbsent(K key, V value)
         * putAll(Map<? extends K, ? extends V> m)
         */

        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);
        System.out.println(map);  // {One=1, Two=2, Three=3}

        map.putIfAbsent("Four", 4);

        Map<String, Integer> moreNum = new HashMap<>();
        moreNum.put("Five", 5);
        moreNum.put("Six", 6);
        map.putAll(moreNum);
        System.out.println(map);   // {One=1, Two=2, Three=3, Four=4, Five=5, Six=6}

        /**
         * get(Object key)
         * getOrDefault(Object key, V defaultValue)
         */
        System.out.println(map.get("Five"));    // 5
        System.out.println(map.getOrDefault("Seven", 7));  // 7

        /**
         * containsKey(Object key)
         * containsValue(Object value)
         */
        System.out.println(map.containsKey("Five"));  // true
        System.out.println(map.containsValue(5));     // true

        /**
         * keySet()
         * values()
         * isEmpty()
         */
        System.out.println(map.keySet());   // [One, Two, Three, Four, Five, Six]
        System.out.println(map.values());   // [1, 2, 3, 4, 5, 6]
        System.out.println(map.isEmpty());   // false
    }


    @Test
    public void learn_Remove_Replacing_Updating() {
        HashMap<String, Integer> map = new LinkedHashMap<>();

        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);
        map.put("Four", 4);
        map.put("Five", 5);
        map.put("Six", 6);
        System.out.println(map);  // {One=1, Two=2, Three=3, Four=4, Five=5, Six=6}

        /**
         * replace(K key, V oldValue, V newValue)
         * replace(K key, V value)
         * replaceAll(BiFunction<? super K, ? super V, ? extends V> function)
         */
        // Replace a value for a specific key if it matches the old value
        map.replace("Two", 2, 4);
        System.out.println(map);   // {One=1, Two=4, Three=3, Four=4, Five=5, Six=6}

        // Replace a value for a specific key
        map.replace("Two", 2);   // {One=1, Two=2, Three=3, Four=4, Five=5, Six=6}
        System.out.println(map);

        // Replace all values using a function
        map.replaceAll((k, v) -> v * 2);
        System.out.println(map);   //  {One=2, Two=4, Three=6, Four=8, Five=10, Six=12}

        /**
         *
         * remove(Object key)
         * remove(Object key, Object value)
         */
        map.remove("Six");
        map.remove("Five", 5);   //not success because of wrong value
        System.out.println(map);   // {One=2, Two=4, Three=6, Four=8, Five=10}

        /**
         * compute(Key, BiFunction)
         * computeIfAbsent(Key, Function)
         * computeIfPresent(Key, BiFunction)
         */
        map.compute("Five",(k,v) -> v+3);
        map.computeIfPresent("Two",(k,v) -> v+3);
        System.out.println(map);   // {One=2, Two=7, Three=6, Four=8, Five=13}
    }
}
