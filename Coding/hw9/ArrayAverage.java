import java.util.stream.IntStream;

public class ArrayAverage {
    public static void main(String[] args) {
        int[] arr = {20, 3, 78, 9, 6, 53, 73, 99, 24, 32};
        double avg = IntStream.of(arr).average().orElseThrow();
        System.out.println(avg);
    }
}
