import java.lang.reflect.Array;

public class MyBinaryTree<T extends Number> {
    private Node<T> root;
    int size;

    static class Node<T extends Number> {
        private T data;
        private Node<T> leftChild;
        private Node<T> rightChild;

        public Node(T data) {
            this.data = data;
        }

        public Node<T> getLeftChild() {
            return leftChild;
        }

        public Node<T> getRightChild() {
            return rightChild;
        }

        public T getData() {
            return data;
        }
    }

    private boolean containsNode(Node<T> current, T data) {
        if (current == null) {
            return false;
        }
        if (data.doubleValue() == current.data.doubleValue()) {
            return true;
        }
        return data.doubleValue() < current.data.doubleValue()
                ? containsNode(current.getLeftChild(), data)
                : containsNode(current.getRightChild(), data);
    }

    public boolean contains(T data) {
        return containsNode(root, data);
    }

    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (root == null) {
            root = newNode;
        } else {
            Node<T> current = root;
            Node<T> parentNode;
            while (true) {
                parentNode = current;
                if (data.doubleValue() == current.getData().doubleValue()) {
                    return;
                } else if (data.doubleValue() < current.getData().doubleValue()) {
                    current = current.getLeftChild();
                    if (current == null) {
                        parentNode.leftChild = newNode;
                        size++;
                        return;
                    }
                } else {
                    current = current.getRightChild();
                    if (current == null) {
                        parentNode.rightChild = newNode;
                        size++;
                        return;
                    }
                }
            }
        }
        size++;
    }

    public void delete(T data) {
        root = deleteRecursive(root, data);
    }

    private Node<T> deleteRecursive(Node<T> current, T data) {
        if (current == null) {
            return null;
        }

        if (data.doubleValue() == current.data.doubleValue()) {
            if (current.leftChild == null && current.rightChild == null) {
                size--;
                return null;
            }if (current.rightChild == null) {
                size--;
                return current.leftChild;
            }
            if (current.leftChild == null) {
                size--;
                return current.rightChild;
            }
            T smallestData = findSmallestData(current.rightChild);
            current.data = smallestData;
            current.rightChild = deleteRecursive(current.rightChild, smallestData);
            return current;
        }
        if (data.doubleValue() < current.data.doubleValue()) {
            current.leftChild = deleteRecursive(current.leftChild, data);

            return current;
        }

        current.rightChild = deleteRecursive(current.rightChild, data);
        return current;
    }

    private T findSmallestData(Node<T> root) {
        return root.leftChild == null ? root.data : findSmallestData(root.leftChild);
    }

    public int size() {
        return size;
    }

    public T[] toArray(T[] array) {
        T[] answer = (T[]) Array.newInstance(array.getClass().getComponentType(), size);
        if (size != 0) {
            inOrder(root, answer, 0);
        }
        return answer;
    }

    private void inOrder(Node<T> current, T[] array, int i) {
        array[i] = current.data;
        if (current.leftChild != null) {
            if (2 * i + 1 < size) {
                inOrder(current.leftChild, array, 2 * i + 1);
            } else {
                int index = size;
                while (array[index - 1] != null) {
                    index--;
                }
                inOrder(current.leftChild, array, index - 1);
            }
        }
        if (current.rightChild != null) {
            if (2 * (i + 1) < size) {
                inOrder(current.rightChild, array, 2 * (i + 1));
            } else {
                int index = size;
                while (array[index - 1] != null) {
                    index--;
                }
                inOrder(current.rightChild, array, index - 1);
            }
        }
    }
}