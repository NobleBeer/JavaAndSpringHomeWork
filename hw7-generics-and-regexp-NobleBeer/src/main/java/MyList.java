public abstract class MyList<T> {
    public int size = 0;

    static class Node<T> {
        Node<T> next;
        T data;

        Node(T data) {
            this.data = data;
        }
    }

    public abstract void add(T n);
    public abstract void addFirst(T n);
    public abstract void insert(T a, int i) throws Exception;
    public abstract void delete(int i) throws Exception;
    public abstract T get(int i);
    public abstract int size();
    public abstract T[] toArray(T[] array);

}
