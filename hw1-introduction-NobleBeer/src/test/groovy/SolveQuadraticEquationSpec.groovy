import spock.lang.Specification

class SolveQuadraticEquationSpec extends Specification {
    def "check isLast5"() {
        expect:
        IntroTasks.getQuadraticEquationSolution(a, b, c) == expectedSolution

        where:
        a      ||     b      ||     c      ||   expectedSolution
        1      ||     2      ||     3      ||   "no solution"
        1      ||    -16     ||     64     ||   "one solution x = 8"
        1      ||     2      ||     -3     ||   "two solutions x1 = -3, x2 = 1"
        0      ||     0      ||     0      ||   "there are infinitely many solutions"
        100    ||     1      ||     50     ||   "no solution"

    }
}
