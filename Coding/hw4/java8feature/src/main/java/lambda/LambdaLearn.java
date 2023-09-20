package lambda;

import org.junit.Test;

import java.util.ArrayList;

public class LambdaLearn {

    @Test
    public void overrrideFoo() {
        Foo fooByIC = new Foo() {
            @Override
            public String aMethod(String string) {return string + " from Foo"; }
        };

        String hello = fooByIC.aMethod("hello");
        System.out.println(hello);
    }

    @Test
    public void lambdaFoo() {
        Foo foo = (o1) -> o1 + " from foo;";
        System.out.println(foo.aMethod("hello"));
    }

    @Test
    public void testFinal() {
        final String addstr = " from foo;";
        Foo foo = (o1) -> o1 + addstr;
        System.out.println(foo.aMethod("hello"));
    }

    @Test
    public void testFinal3() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);

        Foo foo = (o1) -> o1 + " " + list.toString();
        System.out.println(foo.aMethod("hello"));

    }
}
