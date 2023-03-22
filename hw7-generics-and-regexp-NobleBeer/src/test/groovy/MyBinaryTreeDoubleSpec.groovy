import spock.lang.Specification

class MyBinaryTreeDoubleSpec extends Specification {
    def "1: check empty size array"() {
        given:
        MyBinaryTree<Double> tree = new MyBinaryTree()

        expect:
        tree.size() == 0
    }

    def "2: check toArray of empty array"() {
        given:
        MyBinaryTree<Double> tree = new MyBinaryTree<>()

        expect:
        tree.toArray(new Double[0]) == []
    }

    def "4: check add element into tree and size eq 1"() {
        given:
        MyBinaryTree<Double> tree = new MyBinaryTree<>()

        when:
        tree.add(5.2)

        then:
        tree.size() == 1
    }

    def "5: check add element into tree and toArray is correct"() {
        given:
        MyBinaryTree<Double> tree = new MyBinaryTree<>()

        when:
        tree.add(5.2D)

        then:
        tree.toArray(new Double[0]) == [5.2]
    }

    def "6: check add elements into tree and toArray is correct"() {
        given:
        MyBinaryTree<Double> tree = new MyBinaryTree<>()

        when:
        tree.add(5.2D)
        tree.add(7.8D)
        tree.add(3.0D)
        tree.add(9.0D)
        tree.add(4.0D)
        tree.add(2.0D)

        then:
        tree.toArray(new Double[0]) == [5.2, 3.0, 7.8, 2.0, 4.0, 9.0]
    }

    def "7: check delete method last node"() {
        given:
        MyBinaryTree<Double> tree = new MyBinaryTree<>()
        tree.add(5.2D)
        tree.add(7.8D)
        tree.add(3.0D)
        tree.add(9.0D)
        tree.add(4.0D)
        tree.add(2.0D)

        when:
        tree.delete(9.0D)

        then:
        tree.toArray(new Double[0]) == [5.2, 3.0, 7.8, 2.0, 4.0]
    }

    def "8: check delete method node with one child"() {
        given:
        MyBinaryTree<Double> tree = new MyBinaryTree<>()
        tree.add(5.2D)
        tree.add(7.8D)
        tree.add(3.0D)
        tree.add(9.0D)
        tree.add(4.0D)
        tree.add(2.0D)

        when:
        tree.delete(7.8D)

        then:
        tree.toArray(new Double[0]) == [5.2, 3.0, 9.0, 2.0, 4.0]
    }

    def "9: check delete method node with two child"() {
        given:
        MyBinaryTree<Double> tree = new MyBinaryTree<>()
        tree.add(5.2D)
        tree.add(7.8D)
        tree.add(3.0D)
        tree.add(9.0D)
        tree.add(4.0D)
        tree.add(2.0D)

        when:
        tree.delete(3.0D)

        then:
        tree.toArray(new Double[0]) == [5.2, 4.0, 7.8, 2.0, 9.0]
    }

    def "9: check delete method root"() {
        given:
        MyBinaryTree<Double> tree = new MyBinaryTree<>()
        tree.add(5.2D)
        tree.add(7.8D)
        tree.add(3.0D)
        tree.add(9.0D)
        tree.add(4.0D)
        tree.add(2.0D)

        when:
        tree.delete(5.2D)

        then:
        tree.toArray(new Double[0]) == [7.8, 3.0, 9.0, 2.0, 4.0]
    }

    def "10: check contains method"() {
        given:
        MyBinaryTree<Double> tree = new MyBinaryTree<>()
        tree.add(5.2D)
        tree.add(7.8D)
        tree.add(3.0D)
        tree.add(9.0D)
        tree.add(4.0D)
        tree.add(2.0D)

        expect:
        tree.contains(5.2D)
        tree.contains(7.8D)
        tree.contains(3.0D)
        tree.contains(9.0D)
        tree.contains(4.0D)
        tree.contains(2.0D)
    }
}
