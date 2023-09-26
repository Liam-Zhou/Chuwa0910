@FunctionalInterface
public interface Foo {
    String aMethod(String string);

    default String defaultBar() {
        String s = "aaa";
        System.out.println(s);
        return s;
    }

    default String defaultCommon() {
        String s = "bbb";
        System.out.println(s);
        return s;
    }
}
