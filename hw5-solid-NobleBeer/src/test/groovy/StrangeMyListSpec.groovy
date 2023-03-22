import spock.lang.Specification

class StrangeMyListSpec extends Specification {
    def "1: check empty size array"() {
        given:
        MyList myList = StrangeMyList.getStrangeList()

        expect:
        myList.size() == 0
    }

    def "2: check toArray of empty array"() {
        given:
        MyList myList = StrangeMyList.getStrangeList()

        expect:
        myList.toArray() == []
    }

    def "4: check add not even element into list and size eq 0"() {
        given:
        MyList myList = StrangeMyList.getStrangeList()

        when:
        myList.add(5)

        then:
        myList.size() == 0
    }

    def "5: check add even element into list and size eq 1"() {
        given:
        MyList myList = StrangeMyList.getStrangeList()

        when:
        myList.add(4)

        then:
        myList.size() == 1
    }

    def "6: check add not even element into list and toArray is correct"() {
        given:
        MyList myList = StrangeMyList.getStrangeList()

        when:
        myList.add(5)

        then:
        myList.toArray() == []
    }

    def "7: check add even element into list and toArray is correct"() {
        given:
        MyList myList = StrangeMyList.getStrangeList()

        when:
        myList.add(2)

        then:
        myList.toArray() == [2]
    }

    def "8: check add element into list and get method is correct"() {
        given:
        MyList myList = StrangeMyList.getStrangeList()

        when:
        myList.add(4)

        then:
        myList.get(0) == 4
    }

    def "9: check insert method for even element"() {
        given:
        MyList myList = StrangeMyList.getStrangeList()
        myList.add(2)
        myList.add(3)
        myList.add(4)
        myList.add(5)
        myList.add(6)
        myList.add(7)
        myList.add(8)

        when:
        myList.insert(10, 1)

        then:
        myList.toArray() == [2, 10, 4, 6, 8]
    }

    def "10: check insert method for not even element"() {
        given:
        MyList myList = StrangeMyList.getStrangeList()
        myList.add(2)
        myList.add(3)
        myList.add(4)
        myList.add(5)
        myList.add(6)
        myList.add(7)
        myList.add(8)

        when:
        myList.insert(9, 1)

        then:
        myList.toArray() == [2, 4, 6, 8]
    }

    def "11: check delete method for not dividing 3 and 5 element"() {
        given:
        MyList myList = StrangeMyList.getStrangeList()
        myList.add(2)
        myList.add(8)
        myList.add(10)
        myList.add(24)

        when:
        myList.delete(1)

        then:
        myList.toArray() == [2, 8, 10, 24]
    }

    def "12: check delete method for dividing 5 element"() {
        given:
        MyList myList = StrangeMyList.getStrangeList()
        myList.add(2)
        myList.add(8)
        myList.add(10)
        myList.add(24)

        when:
        myList.delete(2)

        then:
        myList.toArray() == [2, 8, 24]
    }

    def "13: check delete method for dividing 3 element"() {
        given:
        MyList myList = StrangeMyList.getStrangeList()
        myList.add(2)
        myList.add(8)
        myList.add(10)
        myList.add(14)
        myList.add(24)

        when:
        myList.delete(4)

        then:
        myList.toArray() == [2, 8, 10, 14]
    }

    def "14: check add first method for not even"() {
        given:
        MyList myList = StrangeMyList.getStrangeList()
        myList.add(2)
        myList.add(6)
        myList.add(10)

        when:
        myList.addFirst(5)

        then:
        myList.toArray() == [2, 6, 10]
    }

    def "15: check add first method for even"() {
        given:
        MyList myList = StrangeMyList.getStrangeList()
        myList.add(2)
        myList.add(6)
        myList.add(10)

        when:
        myList.addFirst(8)

        then:
        myList.toArray() == [8, 2, 6, 10]
    }
}
