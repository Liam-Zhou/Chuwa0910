package kechen.features.lambda;

import kechen.common.pojos.Employee;
import kechen.common.utils.EmployeeData;
import org.junit.Test;

import java.sql.SQLOutput;
import java.util.List;

public class LambdaLearn {

    // 没有使用lambda
    @Test
    public void overrideFoo(){
        Foo fooByIC = new Foo(){
            @Override
            public String aMethod(String string){
                return string + " from Foo";
            }
        };

        String hello = fooByIC.aMethod("hello");
        System.out.println(hello);
    }

    // 属于 Lambda 需要一个参数，但是没有返回值。
    // 数据类型可以省略，因为可由编译器推断得出，称为“类型推断”
    // Lambda 若只需要一个参数时，参数的小括号可以省略
    // 笔记：https://juejin.cn/post/6962035387787116551#heading-0
    @Test
    public void lamdaFoo(){
        Foo foo = parameter -> parameter + " from Foo";

        String hello = foo.aMethod("Hello");
        System.out.println(hello);
    }

    // Lambda表达式提供了一个灵活的方式来为接口中的抽象方法提供方法体（method body）的实现
    // Lambda表达式中的 parameter -> parameter.toUpperCase() + " from Foo" 部分就是提供给 aMethod 方法的方法体，
    // 它将传入的参数转换为大写，并附加 " from Foo"。
    @Test
    public void lamdaFoo2(){
        // 可以提供任何method body
        Foo foo = parameter -> parameter.toUpperCase() + " from Foo";

        String hello = foo.aMethod("Hello");
        System.out.println(hello);
    }

    @Test
    public void testFinal(){
        final String localVariable = "Local";
        Foo foo = parameter -> {
            return parameter + " " + localVariable;
        };

        System.out.println(foo.aMethod("Hello"));
    }

    // 当variable只赋值一次，没有任何变动的时候，Java默认是final。
    // 注意，在lambda expression的前后都不能被改变
    @Test
    public void testEffectivelyFinal(){
        String localVariable = "Local";
        Foo foo = parameter ->{
          return parameter + " " + localVariable;
        };

        System.out.println(foo.aMethod("hello"));
    }

    // localVariale在lambda前面改变了。
    @Test
    public void testFinal21(){
        String localVariable = "Local";
        localVariable = "LOCAL";  // 新的内存地址

        Foo foo = parameter -> {
            // java: local variables referenced from a lambda expression must be final or effectively final
            // return parameter + " " + localVariable;
            return parameter;
        };
        System.out.println(foo.aMethod("Hello"));

    }

    // localVariale在lambda后面改变了。
    @Test
    public void testFinal22(){
        String localVariable = "Local";
        Foo foo = parameter -> {
            // return parameter + " " + localVariable;
            return parameter;
        };
        localVariable = "LOCAL"; // 新的内存地址

        System.out.println(foo.aMethod("hello"));
    }

    @Test
    public void testFinal3() {
        List<Employee> employees = EmployeeData.getEmployees();

        // Object 的set方法不会报错
        // 因为只是在object里面modify，does not change the reference to the Employee object;
        Employee employee = employees.get(0);
        employee.setAge(55);
        Foo foo = parameter -> {
            return parameter + " " + employee;
        };

        System.out.println(foo.aMethod("hello"));
    }
}
