package default_interface_method;

import java.util.Arrays;

public class lambda_function {
    public static void main(String[] args) {
        Foo method = (s) -> {
            return s + " hello world";
        };

        System.out.println(method.addHello("hello"));

       
    }
}
