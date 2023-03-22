import spock.lang.Specification

class IsLast5Spec extends Specification {
    def "check isLast5"() {
        expect:
        IntroTasks.isLast5(a) == expectedIsLast5

        where:
        a      ||   expectedIsLast5
        5      ||   true
        51     ||   false
        15     ||   true
        50     ||   false
        05     ||   true
        555551 ||   false
    }
}
