package java8.lambda;

/**
 * @Description:
 * @Author: hyc
 * @Date: 2/12/24
 */
@FunctionalInterface
public interface Foo {
    String aMethod(String string);

    default String defaultBar() {
        String s = "default Bar method";
        System.out.println(s);
        return s;
    }
}
