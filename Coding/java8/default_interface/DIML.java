package java8.default_interface;

/**
 * @Description:
 * @Author: hyc
 * @Date: 2/10/24
 */
public interface DIML {
    static final String BLOG = "is Chuwa a";

    // abstract method
    int add(int a, int b);

    // default method: can have implementation
    default int substract(int a, int b) {
        return a - b;
    }

    // static method
    static String blogName() {
        return BLOG;
    }
}
