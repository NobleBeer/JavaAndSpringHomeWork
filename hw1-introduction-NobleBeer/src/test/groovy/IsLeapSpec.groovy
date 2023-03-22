import spock.lang.Specification

class IsLeapSpec extends Specification {
    def "check isLeapDigits"() {
        expect:
        IntroTasks.isLeapYear(a) == isLeapYear

        where:
        a     || isLeapYear
        1764  || true
        1980  || true
        2088  || true
        2012  || true
        2000  || true
        1800  || false
        1900  || false
        1700  || false
        2013  || false
        2014  || false
        2100  || false
    }
}
