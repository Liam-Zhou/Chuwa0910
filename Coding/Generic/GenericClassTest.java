package Generic;

public class GenericClassTest {
    public static void main(String[] args) {
        GenericClass<Integer> obj1 = new GenericClass<>(5);
        System.out.println(obj1.getObj());

        GenericClass<String> obj2 = new GenericClass<>("my first generic class");
        System.out.println(obj2.getObj());
    }
}
