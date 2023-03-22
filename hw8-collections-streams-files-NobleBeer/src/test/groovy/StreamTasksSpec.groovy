import spock.lang.Specification

class StreamTasksSpec extends Specification {

    def "1: sum first #n numbers"() {
        when:
        def result = StreamsTasks.sumN(n)

        then:
        result == expectedResult

        where:
        n       ||    expectedResult
        0       ||    0
        1       ||    0
        2       ||    1
        5       ||    10
        10      ||    45
        100000  ||    704982704
    }

    def "1: fails on summing negative numbers"() {
        when:
        StreamsTasks.sumN(n as int)

        then:
        def exception = thrown(RuntimeException)
        exception.message == "Wrong input data"

        where:
        n << [-1, -2, -5, -10, -10000]
    }

    def "2: sum cubes of first #n numbers"() {
        given:
        def result = StreamsTasks.sumN3(n)

        expect:
        result == expectedResult

        where:
        n       ||    expectedResult
        0       ||    0
        1       ||    0
        2       ||    1
        3       ||    9
        5       ||    100
        10      ||    2025
        9876    ||    223347204
    }

    def "2: fails on summing cubes of negative numbers"() {
        when:
        StreamsTasks.sumN3(n as int)

        then:
        def exception = thrown(RuntimeException)
        exception.message == "Wrong input data"

        where:
        n << [-1, -2, -5, -10, -10000]
    }

    def "3: should return new list with odd elements"() {
        given:
        def sourceListCopy = new ArrayList<>(sourceList)

        when:
        def result = StreamsTasks.oddNumbersList(sourceList)

        then:
        result == expectedList
        sourceList == sourceListCopy

        where:
        sourceList    ||   expectedList
        [1, 2, 3]     ||   [1, 3]
        [1, 3, 5]     ||   [1, 3, 5]
        [2, 4, 6]     ||   []
        []            ||   []
    }

    def "3: should fail on null input"() {
        when:
        StreamsTasks.oddNumbersList(null)

        then:
        def exception = thrown(RuntimeException)
        exception.message == "Wrong input data"
    }
}
