
import org.junit.Test;

import java.util.TreeMap;

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
        map.put("one",1);
        map.put("two",2);
        map.putIfAbsent("three",3);

        TreeMap<String, Integer> map2 = new TreeMap<>();
        map2.put("one",1);
        map2.putIfAbsent("three",3);
        map2.putIfAbsent("four",4);
        map.putAll(map2);
        System.out.println(map);  //{four=4, one=1, three=3, two=2}, sorted.
        map.get("four"); //return value;
        map.firstKey();
        if(map.containsKey("four")){
            System.out.println(map.containsValue(4));
        }

        for(String k : map.keySet()){
            System.out.println(k+", "+map.get(k));
        }


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
        map.put("one",1);
        map.put("two",2);
        map.putIfAbsent("three",3);

        TreeMap<String, Integer> map2 = new TreeMap<>();
        map2.put("one",1);
        map2.putIfAbsent("three",3);
        map2.putIfAbsent("four",4);
        map.putAll(map2);

        map.replace("four", 4, 44 );
        map.replace("four", 44);
        map.remove("two");
    }
}
