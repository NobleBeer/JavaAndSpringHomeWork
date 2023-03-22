import spock.lang.Specification

class IsSameDigitsSpec extends Specification {
    def "check isSameDigits"() {
        expect:
        IntroTasks.isSameDigits(a) == expectedIsSameDigits

        where:
        a    || expectedIsSameDigits
        1    || false
        00   || false
        11   || true
        111  || true
        1101 || false
        1111 || true
    }
}
