import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class StreamApiEndOperation {

    private static final List<Employee> EMPLOYEES = EmployeeData.getEmployees();


    public void testCollect() {
        List<Employee> collect = EMPLOYEES.stream().filter(e -> e.getId() > 1002).collect(Collectors.toList());

        Set<Employee> collect2 = EMPLOYEES.stream().filter(e -> e.getId() > 1002).collect(Collectors.toSet());
    }

    public void testMatch() {
        boolean allMatch = EMPLOYEES.stream().allMatch(e -> e.getName().length() > 2);
        boolean anyMatch = EMPLOYEES.stream().anyMatch(e -> e.getName().length() > 3);
        boolean noneMatch = EMPLOYEES.stream().noneMatch(e -> e.getName().startsWith("Yun"));
    }

    public void testFind() {
        Optional<Employee> employee = EMPLOYEES.stream().findFirst();

        Optional<Employee> any = EMPLOYEES.parallelStream().findAny();
    }

    @Test
    public void testCountMaxMin() {
        long count = EMPLOYEES.stream().filter(e -> e.getAge() > 40).count();

        Stream<Integer> stream = EMPLOYEES.stream().map(Employee::getAge);
        Optional<Integer> max = stream.max(Integer::compare);

        Optional<Employee> min = EMPLOYEES.stream().min(Comparator.comparingInt(Employee::getId));

        List<String> collect = EMPLOYEES.stream()
                .filter(e -> e.getAge() > 40).map(e -> e.getName() + " ： OLD PPL")
                .collect(Collectors.toList());
    }

    @Test
    public void testIteration() {
        EMPLOYEES.stream().forEach(System.out::println);

        EMPLOYEES.forEach(System.out::println);
    }

    public void testReduce() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer reduce = list.stream().reduce(0, Integer::sum);

        Stream<Integer> stream = EMPLOYEES.stream().map(Employee::getAge);
        Optional<Integer> reduce1 = stream.reduce(Integer::sum);

        Stream<Integer> stream2 = EMPLOYEES.stream().map(Employee::getAge);
        Optional<Integer> reduce2 = stream2.reduce((d1, d2) -> d1 + d2);
    }


    public void testChain() {
        List<Double> collect = EMPLOYEES.stream()
                .filter(e -> e.getAge() < 40)
                .map(e -> e.getSalary() * 0.8)
                .collect(Collectors.toList());


        Optional<Integer> reduce = EMPLOYEES.stream()
                .filter(e -> e.getAge() < 40)
                .map(e -> e.getSalary() * 0.8)
                .map(e -> {
                    System.out.println(e);
                    return e.intValue();
                })
                .reduce(Integer::sum);

        Optional<Integer> reduce1 = EMPLOYEES.stream()
                .filter(e -> e.getAge() < 40)
                .collect(Collectors.toList())
                .stream()
                .map(e -> e.getSalary() * 0.8)
                .map(e -> {
                    System.out.println(e);
                    return e.intValue();
                })
                .reduce(Integer::sum);
    }


    public void testGroupBy() {
        Map<String, Optional<Employee>> collect = EMPLOYEES
                .stream()
                .collect(Collectors
                        .groupingBy(
                                Employee::getGender,
                                Collectors.maxBy(Comparator.comparing(Employee::getSalary))));
    }

    public void testToMap() {
        Map<Integer, Double> collect = EMPLOYEES.stream()
                .collect(Collectors.toMap(
                        Employee::getId,
                        Employee::getSalary
                ));
    }
}

