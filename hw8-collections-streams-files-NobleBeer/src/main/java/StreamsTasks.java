import java.util.List;
import java.util.stream.IntStream;


public class StreamsTasks {
    public static int sumN(int n) {
        try {
            if (n < 0) {
                throw new IllegalArgumentException();
            }
            return (n * (n + 1) / 2) - n;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Wrong input data");
        }
    }

    public static int sumN3(int n) {
        try {
            if (n < 0) {
                throw new IllegalArgumentException();
            }
            return IntStream.range(0, n).map(x -> x * x * x).sum();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Wrong input data");
        }
    }

    public static List<Integer> oddNumbersList(List<Integer> list) {
        try {
            if (list == null) {
                throw new IllegalArgumentException();
            }
            return list.stream().filter(x -> x % 2 != 0).toList();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Wrong input data");
        }
    }
}
