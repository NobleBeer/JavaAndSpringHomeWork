import spock.lang.Specification

class Is3DigitSpec extends Specification {
    def "check is3Digit"() {
        expect:
        IntroTasks.is3Digit(a) == expectedIs3Digit

        where:
        a    || expectedIs3Digit
        1    || false
        10   || false
        111  || true
        1111 || false
        1000 || false
    }
}
