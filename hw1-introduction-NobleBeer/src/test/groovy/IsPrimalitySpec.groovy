import spock.lang.Specification

class IsPrimalitySpec extends Specification {
    def "check isPrimality"() {
        expect:
        IntroTasks.isPrimality(a) == expectedIsPrimality

        where:
        a      ||   expectedIsPrimality
        2      ||   true
        3      ||   true
        5      ||   true
        7      ||   true
        983    ||   true
        991    ||   true
        997    ||   true
        984959 ||   true
        4      ||   false
        6      ||   false
        9      ||   false
        982743 ||   false
        984957 ||   false
    }
}
