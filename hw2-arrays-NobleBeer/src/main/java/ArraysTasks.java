import java.util.Arrays;
import java.util.stream.Stream;
import java.util.*;
import java.util.List;

public class ArraysTasks {
    public static int[] even(int n) {
        int[] evenResult;
        if (n > 0) {
            evenResult = new int[n];

            for (int i = 1; i <= n; i++) {
                evenResult[i - 1] = i * 2;
            }
        }
        else {
            evenResult = new int[0];
        }
        return evenResult;
    }

    public static boolean allSimilar(int[] a) {
        List<Integer> list = Arrays.stream(a).boxed().toList();
        boolean allEqual;
        if (list.size() < 1) { allEqual = false; }
        else { allEqual = Collections.frequency(list, list.get(0)) == list.size(); }
        return allEqual;
    }

    public static boolean hasSimilar(int[] a) {
        Long distinctCount = Stream.of(a).distinct().count();
        if (a.length > 2) {
            return a.length != distinctCount;
        }
        else { return false; }
    }

    public static double mean(int[] a) {
        return Arrays.stream(a).average().orElse(0.0);
    }

    public static int[] shift(int[] a) {
        if (a.length > 1) {
            int last = a[a.length - 1];
            if (a.length > 1) {
                for (int i = a.length - 2; i >= 0; i--) {
                    a[i + 1] = a[i];
                }
            }
            a[0] = last;
        }
        return a;

    }

    public static int[] copyShift(int[] a) {
        a = a.clone();
        if (a.length > 1) {
            int last = a[a.length - 1];

            if (a.length > 1) {
                for (int i = a.length - 2; i >= 0; i--) {
                    a[i + 1] = a[i];
                }
            }
            a[0] = last;
        }
        return a;
    }
}
