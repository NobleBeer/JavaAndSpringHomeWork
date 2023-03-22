public class LinkedMyList extends MyList {
    /**
     * Очень, очень плохой код! А исправлять очень лень
     * В методе add() сложность равна константе, функция линейна,
     * проходит только одно значение, циклы отсутствуют. Следовательно, сложность - О(1).
     */
    public void add(int n) {
        Node newNode = new Node(n);
        if (size == 0) {
            head = newNode;
        } else {
            tail.next = newNode;
        }

        size++;
        tail = newNode;
    }

    /**
     * В методе addFirst() сложность равна константе, функция линейна,
     * проходит только одно значение, циклы отсутствуют. Следовательно, сложность - О(1).
     */
    public void addFirst(int n) {
        Node newNode = new Node(n);

        if (size != 0) {
            newNode.next = head;
        }

        head = newNode;
        size++;
    }

    /**
     * В методе insert() сложность равна n -> зависит от количества данных, функция НЕлинейна,
     * проходит n значений, присутствует цикл while, который и усложняет. Следовательно, сложность - О(n), но
     * в случае, если работаем с первым элементом, сложность в лучшем случае можно оценить как O(1).
     */
    public void insert(int a, int i) throws Exception {
        Node newNode = new Node(a);
        Node current = head;

        if (i < 0) {
            throw new Exception("bruuuh");
        } else if (i < size) {
            if (i == 0) {
                newNode.next = head;
                head = newNode;
            } else {
                int j = 1;

                while (current.next != null && j != i) {
                    current = current.next;
                    j++;
                }

                newNode.next = current.next;
                current.next = newNode;

                if (current == tail) {
                    tail = newNode;
                }
            }
            size++;
        }
    }

    /**
     * В методе delete() сложность равна n -> зависит от количества данных, функция НЕлинейна,
     * проходит n значений, присутствует цикл while, который и усложняет. Следовательно, сложность - О(n), но
     * в случае, если работаем с первым элементом или имеем исходный список размера 1, сложность
     * в лучшем случае можно оценить как O(1).
     */
    public void delete(int i) throws Exception {

        if (size == 0 || i < 0) {
            throw new Exception("bruuuh");
        } else if (i < size) {
            if (i == 0) {
                head = head.next;
                size--;
                return;
            }

            Node current = head;
            int j = 1;

            while (current.next != null && j != i) {
                current = current.next;
                j++;
            }

            current.next = current.next.next;

            size--;
        }
    }

    /**
     * В методе get() сложность равна n -> зависит от количества данных, функция НЕлинейна,
     * проходит n значений, присутствует цикл while, который и усложняет алгоритм. Следовательно, сложность - О(n).
     */
    public int get(int i) {
        if (head == null || i < 0 || i > size) {
            return 0;
        } else {
            int j = 0;
            Node current = head;

            while (current.next != null && j != i) {
                current = current.next;
                j++;
            }

            return current.data;
        }
    }

    /**
     * Сложность О(1). Этот хитрый шпиён вшит в add'ы и delete
     */
    public int size() {
        return size;
    }

    /**
     * В методе toArray() сложность равна n -> зависит от количества входящих элементов, функция НЕлинейна,
     * проходит n значений, присутствует цикл for(), который и усложняет алгоритм. Следовательно, сложность - О(n).
     */
    public int[] toArray() {
        int[] array = new int[size];
        Node a = head;

        for (int i = 0; i < size; i++) {
            array[i] = a.data;
            a = a.next;
        }

        return array;
    }
}
