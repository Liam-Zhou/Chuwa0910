package method_reference;

import java.util.Comparator;

public class Person {
    private String name;
    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public static int compareByName(Person p1,Person p2) {
        return p1.getName().compareTo(p2.getName());
    }

    @Override
    public String toString() {
        return name + "(" + age + ")";
    }
}
