package java8.lambda;

import java8.tool.Person;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @Description:
 * @Author: hyc
 * @Date: 2/12/24
 */
public class LambdaLearn {

    @Test
    public void overrideFoo() {
        // Foo 这个interface有一个abstract method,
        // 所以在Anonymous Class里需要override来提供method body
        Foo fooByIC = new Foo() {
            @Override
            public String aMethod(String string) {
                return string + "from Foo";
            }
        };
        String hello = fooByIC.aMethod("hello");
        System.out.println(hello);
    }

    @Test
    public void lambdaFoo() {
        Foo foo = parameter -> parameter.toUpperCase() + " from Foo";
        String hello = foo.aMethod("hello");
        System.out.println(hello);
    }

    @Test
    public void testFinal() {
        final String localVariable = "Local";
        Foo foo = parameter -> parameter + " " + localVariable;
        System.out.println(foo.aMethod("hello"));
    }

    /**
     * 换object会报错，因为换了内存地址
     * Variable used in lambda expression should be final or effectively final
     */
    @Test
    public void testFinal21() {
        String localVariable = "Local";
        localVariable = "LOCAL";    // 新的内存地址
        Foo foo = parameter -> {
            // return parameter + " " + localVariable;
            return parameter;
        };
    }

    @Test
    public void testFinal22() {
        String localVariable = "Local";

        Foo foo = parameter -> {
            // return parameter + " " + localVariable;
            return parameter;
        };
        localVariable = "LOCAL"; // 新的内存地址
        System.out.println(foo.aMethod("hello"));
    }

    /**
     * Object 的set方法不会报错
     */
    @Test
    public void testFinal3() {
        List<Person> employees = Arrays.asList(new Person("jack", 1), new Person("mile", 2));
        Person person1 = employees.get(0);
        person1.setAge(55);
        Foo foo = parameter -> parameter + " " + person1.getAge();
        System.out.println(foo.aMethod("hello"));
    }
}
