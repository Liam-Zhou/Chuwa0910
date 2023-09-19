import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.Collections;



public class CollectionsExamples {



    public static void main(String[] args){


        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Apple");
        arrayList.add("Banana");
        arrayList.add("Cherry");
        System.out.println(arrayList);

        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(10);
        linkedList.add(20);
        linkedList.add(30);
        System.out.println(linkedList);

        CopyOnWriteArrayList<String> cowArrayList = new CopyOnWriteArrayList<>();
        cowArrayList.add("Java");
        cowArrayList.add("Python");
        cowArrayList.add("C++");
        System.out.println(cowArrayList);

        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("Red");
        hashSet.add("Green");
        hashSet.add("Blue");
        System.out.println(hashSet);

        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(5);
        treeSet.add(2);
        treeSet.add(8);
        System.out.println(treeSet);

        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Alice", 25);
        hashMap.put("Bob", 30);
        hashMap.put("Charlie", 35);
        System.out.println(hashMap);

        TreeMap<String, Double> treeMap = new TreeMap<>();
        treeMap.put("Apple", 2.99);
        treeMap.put("Banana", 1.49);
        treeMap.put("Cherry", 3.99);
        System.out.println(treeMap);

        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(1, "One");
        linkedHashMap.put(2, "Two");
        linkedHashMap.put(3, "Three");
        System.out.println(linkedHashMap);

        ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("Java", 25);
        concurrentHashMap.put("Python", 30);
        concurrentHashMap.put("C++", 35);
        System.out.println(concurrentHashMap);

        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(2);
        numbers.add(8);

        System.out.println("Original List: " + numbers);

        Collections.sort(numbers);
        System.out.println("Sorted List: " + numbers);
    }
}
