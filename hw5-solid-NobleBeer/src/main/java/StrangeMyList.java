public class StrangeMyList {
    public static MyList getStrangeList() {
        MyList strangeList = new MyList() {

            @Override
            public void add(int n) {
                if (n % 2 == 0) {
                    Node newNode = new Node(n);

                    if (size == 0) {
                        head = newNode;
                    } else {
                        tail.next = newNode;
                    }

                    size++;
                    tail = newNode;
                }
            }

            @Override
            public void addFirst(int n) {
                if (n % 2 == 0) {
                    Node newNode = new Node(n);

                    if (size != 0) {
                        newNode.next = head;
                    }

                    head = newNode;
                    size++;
                }
            }

            @Override
            public void insert(int a, int i) {
                if (i > 0 && i < size && size > 0 && a % 2 == 0) {
                    Node newNode = new Node(a);
                    Node current = head;

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

            @Override
            public void delete(int i) {
                if (i > 0 && i < size && size > 0) {
                    Node current = head;

                    if (i == 0) {
                        if (current.data % 3 == 0 || current.data % 5 == 0) {
                            head = head.next;
                            size--;
                            return;
                        }
                    }

                    int j = 1;

                    while (current.next != null && j != i) {
                        current = current.next;
                        j++;
                    }

                    if (current.next.data % 3 == 0 || current.next.data % 5 == 0) {
                        current.next = current.next.next;

                        size--;
                    }
                }
            }

            @Override
            public int get(int i) {
                if (head == null || 0 > i || i > size) {
                    return 0;
                } else {
                    int j = 0;
                    Node current = head;

                    while (current.next != null && j == i) {
                        current = current.next;
                        j++;
                    }

                    return current.data;
                }
            }

            @Override
            public int size() {
                return size;
            }

            @Override
            public int[] toArray() {
                int[] array = new int[size];
                Node a = head;

                for (int i = 0; i < size; i++) {
                    array[i] = a.data;
                    a = a.next;
                }

                return array;
            }
        };
        return strangeList;
    }
}
