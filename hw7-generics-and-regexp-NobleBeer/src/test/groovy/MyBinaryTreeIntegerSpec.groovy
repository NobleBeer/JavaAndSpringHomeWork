import spock.lang.Specification

class MyBinaryTreeIntegerSpec extends Specification {
    def "1: check empty size array"() {
        given:
        MyBinaryTree<Integer> tree = new MyBinaryTree()

        expect:
        tree.size() == 0
    }

    def "2: check toArray of empty array"() {
        given:
        MyBinaryTree<Integer> tree = new MyBinaryTree<>()

        expect:
        tree.toArray(new Integer[0]) == []
    }

    def "4: check add element into tree and size eq 1"() {
        given:
        MyBinaryTree<Integer> tree = new MyBinaryTree<>()

        when:
        tree.add(5)

        then:
        tree.size() == 1
    }

    def "5: check add element into tree and toArray is correct"() {
        given:
        MyBinaryTree<Integer> tree = new MyBinaryTree<>()

        when:
        tree.add(5)

        then:
        tree.toArray(new Integer[0]) == [5]
    }

    def "6: check add elements into tree and toArray is correct"() {
        given:
        MyBinaryTree<Integer> tree = new MyBinaryTree<>()

        when:
        tree.add(5)
        tree.add(7)
        tree.add(3)
        tree.add(9)
        tree.add(4)
        tree.add(2)

        then:
        tree.toArray(new Integer[0]) == [5, 3, 7, 2, 4, 9]
    }

    def "7: check delete method last node"() {
        given:
        MyBinaryTree<Integer> tree = new MyBinaryTree<>()
        tree.add(5)
        tree.add(7)
        tree.add(3)
        tree.add(9)
        tree.add(4)
        tree.add(2)

        when:
        tree.delete(9)

        then:
        tree.toArray(new Integer[0]) == [5, 3, 7, 2, 4]
    }

    def "8: check delete method node with one child"() {
        given:
        MyBinaryTree<Integer> tree = new MyBinaryTree<>()
        tree.add(5)
        tree.add(7)
        tree.add(3)
        tree.add(9)
        tree.add(4)
        tree.add(2)

        when:
        tree.delete(7)

        then:
        tree.toArray(new Integer[0]) == [5, 3, 9, 2, 4]
    }

    def "9: check delete method node with two child"() {
        given:
        MyBinaryTree<Integer> tree = new MyBinaryTree<>()
        tree.add(5)
        tree.add(7)
        tree.add(3)
        tree.add(9)
        tree.add(4)
        tree.add(2)

        when:
        tree.delete(3)

        then:
        tree.toArray(new Integer[0]) == [5, 4, 7, 2, 9]
    }

    def "9: check delete method root"() {
        given:
        MyBinaryTree<Integer> tree = new MyBinaryTree<>()
        tree.add(5)
        tree.add(7)
        tree.add(3)
        tree.add(9)
        tree.add(4)
        tree.add(2)

        when:
        tree.delete(5)

        then:
        tree.toArray(new Integer[0]) == [7, 3, 9, 2, 4]
    }

    def "10: check contains method"() {
        given:
        MyBinaryTree<Integer> tree = new MyBinaryTree<>()
        tree.add(5)
        tree.add(7)
        tree.add(3)
        tree.add(9)
        tree.add(4)
        tree.add(2)

        expect:
        tree.contains(5)
        tree.contains(7)
        tree.contains(3)
        tree.contains(9)
        tree.contains(4)
        tree.contains(2)
    }
}