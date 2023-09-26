package method_reference;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class MethodReferenceExample {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Alice", 30),
                new Person("Bob", 25),
                new Person("Charlie", 35));

        people.sort(Person::compareByName);

        Comparator<Person> cmp = Comparator.comparingInt(Person::getAge);
        people.sort(cmp);

        Function<Person,String> getNameFunction = Person::getName;
        List<String> names = Arrays.asList("Alice","Bob","Charlie");
        names.sort(String::compareToIgnoreCase);
        System.out.println(names);

        BiFunction<String,Integer,Person> personCreator = Person::new;
        Person newPerson = personCreator.apply("Kila",13);
    }
}
