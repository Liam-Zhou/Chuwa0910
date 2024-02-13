package java8.generic;

/**
 * @Description:
 * @Author: hyc
 * @Date: 2/10/24
 */
public class GenericMultiArguments {

    public static <T1, T2, T3> void temp(T1 x, T2 y, T3 z) {
        System.out.println("This is x = " + x);
        System.out.println("This is y = " + y);
        System.out.println("This is z = " + z);
    }

    public static void main(String[] args) {
        temp(1, "2", 3L);
    }
}
