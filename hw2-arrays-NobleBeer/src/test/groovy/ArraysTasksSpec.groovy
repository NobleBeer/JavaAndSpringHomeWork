import spock.lang.Specification

class ArraysTasksSpec extends Specification {
    def "even: should return even numbers"() {
        expect:
        ArraysTasks.even(3) == [2, 4, 6]
    }

    def "even: should process one even numbers"() {
        expect:
        ArraysTasks.even(1) == [2]
    }

    def "even: should process empty array"() {
        expect:
        ArraysTasks.even(0) == []
    }

    def "even: should process negative numbers"() {
        expect:
        ArraysTasks.even(-5) == []
    }

    def "allSimilar: should process empty array"() {
        expect:
        ArraysTasks.allSimilar([] as int[]) == false
    }

    def "allSimilar: should process array with one element"() {
        expect:
        ArraysTasks.allSimilar([1] as int[]) == true
    }

    def "allSimilar: should process array with similar elements"() {
        expect:
        ArraysTasks.allSimilar([1, 1, 1] as int[]) == true
    }

    def "allSimilar: should process array with not similar elements"() {
        expect:
        ArraysTasks.allSimilar([1, 2, 1] as int[]) == false
    }

    def "hasSimilar: should process empty array"() {
        expect:
        ArraysTasks.hasSimilar([] as int[]) == false
    }

    def "hasSimilar: should process array with one element"() {
        expect:
        ArraysTasks.hasSimilar([1] as int[]) == false
    }

    def "hasSimilar: should process array with some similar elements"() {
        expect:
        ArraysTasks.hasSimilar([1, 2, 1] as int[]) == true
    }

    def "hasSimilar: should process array with not similar elements"() {
        expect:
        ArraysTasks.hasSimilar([1, 2, 3] as int[]) == false
    }

    def "mean: should process empty array"() {
        when:
        ArraysTasks.mean([] as int[])
        then:
        noExceptionThrown()
    }

    def "mean: should process array with one element"() {
        expect:
        ArraysTasks.mean([10] as int[]) == 10
    }

    def "mean: should process array with some elements"() {
        expect:
        ArraysTasks.mean([2, 5, 20] as int[]) == 9
    }

    def "mean: should process array with negative elements"() {
        expect:
        ArraysTasks.mean([-5, 3, 2] as int[]) == 0
    }

    def "shift: should process empty array"() {
        given:
        int[] a = []
        when:
        ArraysTasks.shift(a)
        then:
        a == []
    }

    def "shift: should process array with one element"() {
        given:
        int[] a = [1]
        when:
        ArraysTasks.shift(a)
        then:
        a == [1]
    }

    def "shift: should process array"() {
        given:
        int[] a = [1, 2, 3, 4]
        when:
        ArraysTasks.shift(a)
        then:
        a == [4, 1, 2, 3]
    }

    def "copyShift: process empty array"() {
        given:
        int[] a = []
        when:
        def aCopy = ArraysTasks.copyShift(a)
        then:
        a == []
        aCopy == []
    }

    def "copyShift: process array with one element"() {
        given:
        int[] a = [1]
        when:
        def aCopy = ArraysTasks.copyShift(a)
        then:
        a == [1]
        aCopy == [1]
    }

    def "copyShift: process array"() {
        given:
        int[] a = [1, 2, 3]
        when:
        def aCopy = ArraysTasks.copyShift(a)
        then:
        a == [1, 2, 3]
        aCopy == [3, 1, 2]
    }
}