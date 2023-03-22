import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        return Arrays.stream(words)
                .collect(Collectors.groupingBy(Function.identity(),
                        Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .map(Map.Entry::getKey).limit(k).toList();
    }

}
