import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamApiCreationTest {
    public void testCollection() {
        List<Integer> col = Arrays.asList(1, 2, 3, 4, 5);

        Stream<Integer> stream = col.stream();

        Stream<Integer> parallelStream = col.parallelStream();
    }

    public void testArrays() {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        IntStream stream = Arrays.stream(arr);

        Employee e1 = new Employee(1001, "tom", 20, 2222);
        Employee e2 = new Employee(1002, "Jerry", 18, 5000);
        Employee[] arr1 = new Employee[]{e1, e2};
        Stream<Employee> stream1 = Arrays.stream(arr1);
    }

    public void testOf() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);
    }
    -------------------  华丽分割线  ------------------------------------

    public void testIterate() {
        Stream.iterate(0, t -> t + 2).limit(10).forEach(System.out::println);
    }

    public void testGenerate() {
        Stream.generate(Math::random).limit(10).forEach(System.out::println);

        Stream<String> streamGenerated = Stream.generate(() -> "element").limit(10);
    }

    public void testStreamOfPrimitives() {
        IntStream intStream = IntStream.range(1, 3);
        LongStream longStream = LongStream.rangeClosed(1, 3);
    }
}
