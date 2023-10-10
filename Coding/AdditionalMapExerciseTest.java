package com.chuwa.exercise.collection;

import org.junit.Test;

/**
 * @author b1go
 * @date 6/12/22 4:48 PM
 */
public class AdditionalMapExerciseTest {


    @Test
    public void learn_ConcurrentHashMap() {
      ConcurrentHashMap<String, Integer> m1 = new ConcurrentHashMap<>();
      ConcurrentHashMap<String, Integer> m2 = new ConcurrentHashMap<>();

      m2.put("third", 3);
      m2.putIfAbsent("fourth", 4);

      m1.put("first", 1);
      m1.putIfAbsent("second", 2);
      m1.putAll(m2);
    }



}
