package com.chuwa.exercise.collection;

import org.junit.Test;
import java.util.*;

import javax.sound.midi.SysexMessage;

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

        Map<String, Integer> mp = new HashMap<>();
        mp.put("apple", 1);
        mp.put("pear", 2);
        System.out.println(mp);

        mp.putIfAbsent("apple",2);
        mp.putIfAbsent("peach", 3);
        System.out.println(mp);

        HashMap <String, Integer> new_map = new HashMap<>();
        new_map.putAll(mp);
        System.out.println(new_map);

        int a = new_map.get("apple");
        System.out.println(a);


        int b = mp.getOrDefault("apple", 200);
        int c = mp.getOrDefault("banana", 5);
        System.out.println(b +", "+ c);


        System.out.println(mp.containsKey("apple"));
        System.out.println(mp.containsValue(7));


        Set<String> myKey = new HashSet<>();
        myKey = mp.keySet();
        System.out.println(myKey);

        Collection<Integer> val = new ArrayList<>();
        val = mp.values();
        System.out.println(val);

        mp.clear();
        System.out.println(mp.isEmpty());











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

        Map<String, Integer> mp = new HashMap<>();
        mp.put("apple", 1);
        mp.put("pear", 2);
        mp.put("banana",5);
        System.out.println(mp);
        
        mp.replace("apple", 1, 3);
        System.out.println(mp);

        mp.replace("pear", 4);
        System.out.println(mp);

        mp.replaceAll((k,v)->v+1);
        System.out.println("replace all:" + mp);

        
        mp.remove("apple");
        mp.remove("banana", 5);
        System.out.println(mp);

        mp.compute("pear", (key,value) -> value == null ? 2 : value +1);
        System.out.println(mp);

        mp.computeIfAbsent("apple", val -> 3);
        System.out.println(mp);

        mp.computeIfPresent("apple", (key,val)-> val == null ? 1 : 7);
        System.out.println(mp);






    }
}
