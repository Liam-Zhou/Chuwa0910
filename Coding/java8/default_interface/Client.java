package java8.default_interface;

/**
 * @Description:
 * @Author: hyc
 * @Date: 2/10/24
 */
public class Client {
    public static void main(String[] args) {
        DIMImpl dim = new DIMImpl();
        System.out.println("Override method: " + dim.add(1, 2));
        System.out.println("default method: " + dim.substract(1, 2));
        System.out.println("static method: " + DIML.blogName());
    }
}
