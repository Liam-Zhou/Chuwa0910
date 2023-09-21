import java.util.List;

public class LambdaLearn {

    public void lambdaFoo() {
        Foo foo = parameter -> parameter + " from Foo";

        String hello = foo.aMethod("hello");
        System.out.println(hello);
    }

    public void lambdaFoo2() {
        Foo foo = parameter -> parameter.toUpperCase() + " from Foo";

        String hello = foo.aMethod("hello");
        System.out.println(hello);
    }

    public void testFinal() {
        final String localVariable = "Local";
        Foo foo = parameter -> {return parameter + " " + localVariable;};

        System.out.println(foo.aMethod("hello"));
    }

    public void testEffectivelyFinal() {
        String localVariable = "Local";
        Foo foo = parameter -> {return parameter + " " + localVariable;};

        System.out.println(foo.aMethod("hello"));
    }

    public void testFinal22() {
        String localVariable = "Local";

        Foo foo = parameter -> {
//            return parameter + " " + localVariable;
            return parameter;
        };

        localVariable = "LOCAL"; // new location

        System.out.println(foo.aMethod("hello"));
    }

    public void testFinal3() {
        List<Employee> employees = EmployeeData.getEmployees();

        Employee employee = employees.get(0);
        employee.setAge(55);
        Foo foo = parameter -> {
            return parameter + " " + employee;
        };

        System.out.println(foo.aMethod("hello"));
    }
}
