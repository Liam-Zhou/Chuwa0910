package kechen.features.stream_api;

import jdk.swing.interop.SwingInterOpUtils;
import kechen.common.pojos.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamApiCreationTest {
    @Test
    public void testCollection(){
        //创建 Stream方式一：通过集合
        List<Integer> col = Arrays.asList(1,2,3,4,5);
        col.forEach(System.out::println);

        Stream<Integer> stream = col.stream();
        System.out.println("Stream object:      " + stream);

        Stream<Integer> parallelStream = col.parallelStream();
        System.out.println("Parallel Stream object:     " + parallelStream);
    }

    //创建 Stream方式二：通过数组
    @Test
    public void testArrays(){
        int[] arr = new int[]{1,2,3,4,5};
        IntStream stream = Arrays.stream(arr);
        System.out.println("Stream object:      " + stream);

        Employee e1 = new Employee(1001, "tom", 20, 2222);
        Employee e2 = new Employee(1002, "Jerry", 18, 5000);
        Employee[] arr1 = new Employee[]{e1, e2};
        Stream<Employee> stream1 = Arrays.stream(arr1);
        System.out.println("Stream object:     " + stream1);
    }

    //创建 Stream方式三：通过Stream的of()
    public void testOf() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);
        System.out.println("Stream object:      " + stream);
    }

    //创建 Stream方式四：创建无限流
    public void testIterate() {
        // iterate(final T seed, final UnaryOperator<T> f)
        // limit: 10 element
        Stream.iterate(0, t -> t + 2).limit(10).forEach(System.out::println);
    }

    @Test
    public void testGenerate() {
        // //public static<T> Stream<T> generate(Supplier<T> s)
        Stream.generate(Math::random).limit(10).forEach(System.out::println);

        Stream<String> streamGenerated =
                Stream.generate(() -> "element").limit(10);
        streamGenerated.forEach(System.out::println);
    }

    @Test
    public void testStreamOfPrimitives() {
        IntStream intStream = IntStream.range(1, 3);
        LongStream longStream = LongStream.rangeClosed(1, 3);

        System.out.println("Stream Object:  " + intStream);
        intStream.forEach(System.out::println);

        System.out.println("Stream Object:  " + longStream);
        longStream.forEach(System.out::println);
    }
}
