import java.util.Optional;

public class OptionalMainMethodTest {

    public void testOptionalWithNotHandleException() {
        Employee employee = new Employee();
        Optional<Employee> optional = Optional.of(employee);

        employee = null;
        Optional<Employee> optional2 = Optional.of(employee);
    }

    public void test1() {
        Employee employee = new Employee();
        Optional<Employee> optional = Optional.of(employee);

        employee = null;
        Optional<Employee> optional2 = Optional.of(employee);
    }

    public void testOfNullable() {
        Employee employee = new Employee();
        Optional<Employee> optional = Optional.ofNullable(employee);
        System.out.println(optional);

        employee = null;
        Optional<Employee> optional2 = Optional.ofNullable(employee);
        System.out.println(optional2);
    }

    public void testOrElse() {
        Employee employee = new Employee();
        Optional<Employee> optional = Optional.ofNullable(employee);
        System.out.println(optional);

        employee = null;
        Optional<Employee> optional2 = Optional.ofNullable(employee);
        System.out.println(optional2);

        Employee employee1 = Optional.ofNullable(employee).orElse(new Employee(1, "John", 30, 6666));
        if (employee != null) {
            employee1 = employee;
        } else {
            employee1 = new Employee(1, "John", 30, 6666);
        }
        System.out.println(employee1);
    }

    public void testOrElseThrow() {
        Employee employee = new Employee();
        Optional<Employee> optional = Optional.ofNullable(employee);
        System.out.println(optional);

        employee = null;
        Optional<Employee> optional2 = Optional.ofNullable(employee);
        System.out.println(optional2);

        Employee employee1 = Optional.ofNullable(employee).orElseThrow(() -> new RuntimeException("Wow Exception"));
        System.out.println(employee1);
    }
}
