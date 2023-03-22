import java.io.File;
import java.io.FileNotFoundException;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.HashMap;

public class StreamsAndScannerTasks {

    public static long calcWordsCount(File inputFile) {
        try {
            if (inputFile == null || inputFile.length() == 0) {
                throw new IllegalArgumentException();
            } else {
                Scanner scanner = new Scanner(inputFile).useDelimiter("\\s+");
                return scanner.tokens().count();
            }
        } catch (IllegalArgumentException | FileNotFoundException e) {
            throw new RuntimeException("Failed to load file");
        }
    }

    public static long calcWordsCountWithoutStopWords(File inputFile, File stopWords) {
        try {
            if (inputFile == null || inputFile.length() == 0 || stopWords == null
                    || stopWords.length() == 0) {
                throw new RuntimeException();
            } else {
                Scanner scanner = new Scanner(inputFile).useDelimiter("\\s+");
                Scanner stopScanner = new Scanner(stopWords).useDelimiter("\\s+");
                List<String> tokensList = scanner.tokens()
                        .map(String::toLowerCase).toList();
                List<String> stopWordsList = stopScanner.tokens()
                        .map(String::toLowerCase).toList();
                return tokensList.stream().filter(s -> !stopWordsList.contains(s)).count();
            }
        } catch (RuntimeException | FileNotFoundException e) {
            throw new RuntimeException("Failed to load file");
        }
    }

    public static long calcWordsCountWithUpperCaseFirstLetter(File inputFile) {
        try {
            if (inputFile == null || inputFile.length() == 0) {
                throw new RuntimeException();
            } else {
                Scanner scanner = new Scanner(inputFile).useDelimiter("\\s+");
                Pattern pattern = Pattern.compile("[A-Z][a-zA-Z0-9]");
                return scanner.tokens().filter(pattern.asPredicate()).count();
            }
        } catch (RuntimeException | FileNotFoundException e) {
            throw new RuntimeException("Failed to load file");
        }
    }

    public static Map<String, Double> calcWordsStatistic(File inputFile) {
        try {
            if (inputFile == null || inputFile.length() == 0) {
                throw new RuntimeException();
            } else {
                Scanner scanner = new Scanner(inputFile).useDelimiter("\\s+");

                DoubleSummaryStatistics result = scanner.tokens()
                        .mapToDouble(String::length).summaryStatistics();
                Map<String, Double> ret = new HashMap<>();
                ret.put("min_length", result.getMin());
                ret.put("max_length", result.getMax());
                ret.put("average_length", result.getAverage());
                return ret;
            }
        } catch (RuntimeException | FileNotFoundException e) {
            throw new RuntimeException("Failed to load file");
        }
    }

    public static Map<String, Long> calcWordsFrequency(File inputFile) {
        try {
            if (inputFile == null || inputFile.length() == 0) {
                throw new RuntimeException();
            } else {
                Scanner scanner = new Scanner(inputFile).useDelimiter("\\s+");
                return scanner.tokens().map(String::toLowerCase)
                        .collect(Collectors
                                .groupingBy(Function.identity(), Collectors.counting()));
            }
        } catch (RuntimeException | FileNotFoundException e) {
            throw new RuntimeException("Failed to load file");
        }
    }
}
