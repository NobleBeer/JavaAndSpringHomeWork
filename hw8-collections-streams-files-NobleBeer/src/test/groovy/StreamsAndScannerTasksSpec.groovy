import spock.lang.Specification

class StreamsAndScannerTasksSpec extends Specification {
    def "4: calc words count in file #fileName"() {
        given:
        ClassLoader classLoader = getClass().getClassLoader()
        def file = new File(classLoader.getResource(fileName).getFile())

        when:
        def result = StreamsAndScannerTasks.calcWordsCount(file)

        then:
        result == expectedResult

        where:
        fileName              ||    expectedResult
        "test_input_1.txt"    ||    383
        "test_input_2.txt"    ||    180
    }

    def "4: should fail for incorrect file #fileName"() {
        given:
        def file = new File(fileName)

        when:
        StreamsAndScannerTasks.calcWordsCount(file)

        then:
        def exception = thrown(RuntimeException)
        exception.message == "Failed to load file"

        where:
        fileName << ["test_input_wrong_name_1.txt", "test_input_wrong_name_2.txt"]
    }

    def "4: should fail for null file"() {
        when:
        StreamsAndScannerTasks.calcWordsCount(null)

        then:
        def exception = thrown(RuntimeException)
        exception.message == "Failed to load file"
    }

    def "5: calc words count in file #fileName without stop words"() {
        given:
        ClassLoader classLoader = getClass().getClassLoader()
        def file = new File(classLoader.getResource(fileName).getFile())
        def stopWords = new File(classLoader.getResource("stop_words.txt").getFile())

        when:
        def result = StreamsAndScannerTasks.calcWordsCountWithoutStopWords(file, stopWords)

        then:
        result == expectedResult

        where:
        fileName              ||    expectedResult
        "test_input_1.txt"    ||    353
        "test_input_2.txt"    ||    101
    }

    def "5: should fail for incorrect file #fileName"() {
        given:
        ClassLoader classLoader = getClass().getClassLoader()
        def file = new File(fileName)
        def stopWords = new File(classLoader.getResource("stop_words.txt").getFile())

        when:
        StreamsAndScannerTasks.calcWordsCountWithoutStopWords(file, stopWords)

        then:
        def exception = thrown(RuntimeException)
        exception.message == "Failed to load file"

        where:
        fileName << ["test_input_wrong_name_1.txt", "test_input_wrong_name_2.txt"]
    }

    def "5: should fail for incorrect stop words file"() {
        given:
        ClassLoader classLoader = getClass().getClassLoader()
        def file = new File(classLoader.getResource("test_input_1.txt").getFile())
        def stopWords = new File("stop_words_wrong.txt")

        when:
        StreamsAndScannerTasks.calcWordsCountWithoutStopWords(file, stopWords)

        then:
        def exception = thrown(RuntimeException)
        exception.message == "Failed to load file"
    }

    def "6: calc words count with first upper case letter in file #fileName"() {
        given:
        ClassLoader classLoader = getClass().getClassLoader()
        def file = new File(classLoader.getResource(fileName).getFile())

        when:
        def result = StreamsAndScannerTasks.calcWordsCountWithUpperCaseFirstLetter(file)

        then:
        result == expectedResult

        where:
        fileName              ||    expectedResult
        "test_input_1.txt"    ||    50
        "test_input_2.txt"    ||    23
    }

    def "6: should fail for incorrect file #fileName"() {
        given:
        def file = new File(fileName)

        when:
        StreamsAndScannerTasks.calcWordsCountWithUpperCaseFirstLetter(file)

        then:
        def exception = thrown(RuntimeException)
        exception.message == "Failed to load file"

        where:
        fileName << ["test_input_wrong_name_1.txt", "test_input_wrong_name_2.txt"]
    }

    def "7: calc words count with first upper case letter in file #fileName"() {
        given:
        ClassLoader classLoader = getClass().getClassLoader()
        def file = new File(classLoader.getResource(fileName).getFile())

        when:
        def result = StreamsAndScannerTasks.calcWordsStatistic(file)

        then:
        result.size() == 3
        result["average_length"] == expectedResult["average_length"]
        result["min_length"] == expectedResult["min_length"]
        result["max_length"] == expectedResult["max_length"]

        where:
        fileName              ||    expectedResult
        "test_input_1.txt"    ||    ["average_length" : 5.908616187989556, "min_length" : 1.0D, "max_length" : 12.0]
        "test_input_2.txt"    ||    ["average_length" : 6.055555555555555D, "min_length" : 1.0D, "max_length" : 14.0]
    }

    def "7: should fail for incorrect file #fileName"() {
        given:
        def file = new File(fileName)

        when:
        StreamsAndScannerTasks.calcWordsStatistic(file)

        then:
        def exception = thrown(RuntimeException)
        exception.message == "Failed to load file"

        where:
        fileName << ["test_input_wrong_name_1.txt", "test_input_wrong_name_2.txt"]
    }

    def "8: calc words count with first upper case letter in file #fileName"() {
        given:
        ClassLoader classLoader = getClass().getClassLoader()
        def file = new File(classLoader.getResource("test_input_2.txt").getFile())

        when:
        def result = StreamsAndScannerTasks.calcWordsFrequency(file)

        then:
        result.size() == 124
        result["it"] == 4I
        result["education"] == 1I
        result["for"] == 5I

    }
}
