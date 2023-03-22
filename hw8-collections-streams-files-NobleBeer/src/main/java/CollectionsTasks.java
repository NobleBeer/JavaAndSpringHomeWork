import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class CollectionsTasks {
    public static <T> void reverseList(List<T> list) {
        if (list == null) {
            throw new RuntimeException("Wrong input data");
        }
        Collections.reverse(list);
    }

    public static <T> List<T> createReversedList(List<T> list) {
        try {
            if (list == null) {
                throw new RuntimeException();
            }
            return IntStream.range(0, list.size())
                .map(i -> (list.size() - 1 - i))
                .mapToObj(list::get)
                .collect(Collectors.toCollection(ArrayList::new));
        } catch (RuntimeException e) {
            throw new RuntimeException("Wrong input data");
        }
    }

    public static <T> void deleteEvenElements(List<T> list) {
        if (list == null) {
            throw new RuntimeException("Wrong input data");
        }
        list.removeIf(n -> (list.indexOf(n) % 2 == 0));
    }

    public static <T> List<T> createOddElementsList(List<T> list) {
        try {
            if (list == null) {
                throw new RuntimeException();
            }
            return list.stream().filter(n -> (list.indexOf(n) % 2 != 0)).toList();
        } catch (RuntimeException e) {
            throw new RuntimeException("Wrong input data");
        }
    }
}
