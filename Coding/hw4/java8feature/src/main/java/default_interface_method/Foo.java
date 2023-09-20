package default_interface_method;

@FunctionalInterface
public interface Foo {
    String addHello(String string);

    default String defaultfoo() {
        System.out.println("hello world");
        return "hello world";
    }
}
