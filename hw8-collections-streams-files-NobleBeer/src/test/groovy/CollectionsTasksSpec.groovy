import spock.lang.Specification

class CollectionsTasksSpec extends Specification {
    def "11 reverse list (clear function)"() {
        when:
        CollectionsTasks.reverseList(sourceList)

        then:
        sourceList == expectedList

        where:
        sourceList      ||     expectedList
        [1, 2, 3]       ||     [3, 2, 1]
        ["2", "3"]      ||     ["3", "2"]
        [1, 4, 6, 9, 2] ||     [2, 9, 6, 4, 1]
        []              ||     []
    }

    def "11 reverse list (clear function) should fail on null"() {
        when:
        CollectionsTasks.reverseList(null)

        then:
        def ex = thrown(RuntimeException)
        ex.message == "Wrong input data"
    }

    def "11 reverse list (not clear function)"() {
        given:
        def sourceListCopy = sourceList.collect()

        when:
        def result = CollectionsTasks.createReversedList(sourceList)

        then:
        sourceList == sourceListCopy
        result == expectedList

        where:
        sourceList      ||     expectedList
        [1, 2, 3]       ||     [3, 2, 1]
        ["2", "3"]      ||     ["3", "2"]
        [1, 4, 6, 9, 2] ||     [2, 9, 6, 4, 1]
        []              ||     []
    }

    def "11 reverse list (not clear function) should fail on null"() {
        when:
        CollectionsTasks.createReversedList(null)

        then:
        def ex = thrown(RuntimeException)
        ex.message == "Wrong input data"
    }

    def "12 remove even indexed items from list"() {
        when:
        CollectionsTasks.deleteEvenElements(sourceList)

        then:
        sourceList == expectedList

        where:
        sourceList      ||     expectedList
        [1, 2, 3]       ||     [2]
        ["2", "3"]      ||     ["3"]
        [1, 4, 6, 9, 2] ||     [4, 9]
        []              ||     []
    }

    def "12 remove even indexed items from list should fail on null"() {
        when:
        CollectionsTasks.deleteEvenElements(null)

        then:
        def ex = thrown(RuntimeException)
        ex.message == "Wrong input data"
    }

    def "13 return new list, where removed even indexed items "() {
        given:
        def sourceListCopy = sourceList.collect()

        when:
        def result = CollectionsTasks.createOddElementsList(sourceList)

        then:

        sourceList == sourceListCopy
        result == expectedList

        where:
        sourceList      ||     expectedList
        [1, 2, 3]       ||     [2]
        ["2", "3"]      ||     ["3"]
        [1, 4, 6, 9, 2] ||     [4, 9]
        []              ||     []
    }

    def "13 create odd elements list should fail on null"() {
        when:
        CollectionsTasks.createOddElementsList(null)

        then:
        def ex = thrown(RuntimeException)
        ex.message == "Wrong input data"
    }
}
