public abstract class MyList {
    public Node head;
    public Node tail;
    public int size = 0;

    static class Node {
        Node next;
        int data;

        Node(int data) {
            this.data = data;
        }
    }

    public abstract void add(int n);
    public abstract void addFirst(int n);
    public abstract void insert(int a, int i) throws Exception;
    public abstract void delete(int i) throws Exception;
    public abstract int get(int n);
    public abstract int size();
    public abstract int[] toArray();




}
