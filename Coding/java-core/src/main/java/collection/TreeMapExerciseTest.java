package collection;

import org.junit.Test;

import java.util.TreeMap;

/**
 * @author b1go
 * @date 6/12/22 4:47 PM
 */
public class TreeMapExerciseTest {

    /**
     * e.g.
     * TreeMap<String, Integer> map = new TreeMap<>();
     *
     * put(K key, V value)
     * putIfAbsent(K key, V value)
     * putAll(Map<? extends K, ? extends V> m)
     *
     * get(Object key)
     * firstKey()
     * lastKey()
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
        TreeMap<String, Integer> map = new TreeMap<>();
        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);
        map.putIfAbsent("Four", 4);

        TreeMap<String, Integer> anotherMap = new TreeMap<>();
        anotherMap.put("Five", 5);
        anotherMap.put("Six", 6);
        map.putAll(anotherMap);

        System.out.println("Value for 'One': " + map.get("One"));
        System.out.println("First key: " + map.firstKey());
        System.out.println("Last key: " + map.lastKey());

        System.out.println("Contains key 'Three': " + map.containsKey("Three"));
        System.out.println("Contains value '5': " + map.containsValue(5));

        System.out.println("Key set: " + map.keySet());
        System.out.println("Values: " + map.values());

        System.out.println("Is empty: " + map.isEmpty());
        System.out.println("Map after inserting: " + map);
    }

    /**
     * replace(K key, V oldValue, V newValue)
     * replace(K key, V value)
     *
     * remove(Object key)
     */
    @Test
    public void learn_Remove_Replacing_Updating() {
        TreeMap<String, Integer> map = new TreeMap<>();
        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);

        boolean replaced1 = map.replace("One", 1, 10);
        Integer replaced2 = map.replace("Two", 20);

        System.out.println("Map after replacing 'One' with 10: " + map);
        System.out.println(replaced1);
        System.out.println(replaced2);

        map.remove("Three");
        System.out.println("Map after removing 'Three': " + map);
    }
}
