import spock.lang.Specification

class RegexpTasksSpec extends Specification {

    def "1: is true cat test"() {
        given:
        def result = RegexpTasks.isTrueCat(input)

        expect:
        result == expectedResult

        where:
        input                        ||   expectedResult
        "cat"                        ||   true
        "Cat"                        ||   true
        "theCATisHERE"               ||   true
        "cccattt"                    ||   true
        null                         ||   false
        "kat"                        ||   false
        "cot"                        ||   false
        "cart"                       ||   false
        "caat"                       ||   false
        "cta"                        ||   false
    }

    def "2: catculator"() {
        given:
        def result = RegexpTasks.catculator(input)

        expect:
        result == expectedResult

        where:
        input                                                ||   expectedResult
        null                                                 ||   0
        ""                                                   ||   0
        "Valentina has 3 cats, but Nikolay has only 1 cat"   ||   4
        "Alexander has 1 dog, but want to have 1 cat"        ||   1
        "On November 7 3 cats decided to make a revolution"  ||   3
        "Hermitage Cat invites you to the museum"            ||   1
    }

    def "3: skynet"() {
        given:
        def result = RegexpTasks.skynet(input)

        expect:
        result == expectedResult

        where:
        input                                                         ||   expectedResult
        null                                                          ||   ""
        ""                                                            ||   ""
        "I need to understand the human mind"                         ||   "I need to understand the computer mind"
        "humanity"                                                    ||   "humanity"
        "Only a human can make the only right decision"               ||   "Only a computer can make the only right decision"
        "I`ll be back"                                                ||   "I`ll be back"
        "I need your clothes, your boots and your motorcycle, human"  ||   "I need your clothes, your boots and your motorcycle, computer"
        "Please, ask all humans, where is Sarah Connor"               ||   "Please, ask all humans, where is Sarah Connor"
    }

    def "4: removeDuplicates"() {
        given:
        def result = RegexpTasks.removeDuplicates(input)

        expect:
        result == expectedResult

        where:
        input               ||   expectedResult
        null                ||   ""
        ""                  ||   ""
        "attraction"        ||   "atraction"
        "buzzzz"            ||   "buz"
        "AaAaAa"            ||   "AaAaAa"
        "SSooss"            ||   "Sos"
    }

    def "5: isEmail"() {
        given:
        def result = RegexpTasks.isEmail(input)

        expect:
        result == expectedResult

        where:
        input                     ||   expectedResult
        null                      ||   false
        ""                        ||   false
        "NotAnEmail"              ||   false
        "@NotAnEmail"             ||   false
        "Ima Fool@example.com"    ||   false
        ".@example.com"           ||   false
        "pootietang.@example.com" ||   false
        "wo..oly@example.com"     ||   false
        ".wooly@example.com"      ||   false
        "spbu@spbu.ru"            ||   true
        "anna.vasilieva@spbu.ru"  ||   true
        "abit@itmo.ru"            ||   true

    }

    def "6: validateForDuplicates"() {
        given:
        def result = RegexpTasks.validateForDuplicates(input)

        expect:
        result == expectedResult

        where:
        input                                   || expectedResult
        null                                    || ""
        ""                                      || ""
        "This is a test"                        || "This is a test"
        "This is is a test"                     || "This is <strong>is</strong> a test"
        "I I don`t now how to do this homework" || "I <strong>I</strong> don`t now how to do this homework"
    }
}
