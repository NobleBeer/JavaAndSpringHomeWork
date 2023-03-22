import spock.lang.Specification

class CatSpec extends Specification {
    def "check cat"() {
        expect:
        IntroTasks.cat(a) == expectedCat

        where:
        a    || expectedCat
        -5   || "-5 котов"
        -4   || "-4 кота"
        -1   || "-1 кот"
        0    || "0 котов"
        2    || "2 кота"
        3    || "3 кота"
        4    || "4 кота"
        5    || "5 котов"
        6    || "6 котов"
        7    || "7 котов"
        8    || "8 котов"
        9    || "9 котов"
        11   || "11 котов"
        14   || "14 котов"
        21   || "21 кот"
        22   || "22 кота"
        25   || "25 котов"
        1001 || "1001 кот"
        1003 || "1003 кота"
        1005 || "1005 котов"
    }
}
