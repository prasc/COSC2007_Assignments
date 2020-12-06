public class BinaryHeapPQ implements PriorityQueueInterface {
    private Node[] heap;
    private static final int MAX_SIZE = 50;

    private class Node {
        int key;
        int item;
        Node next;

        public Node(int key, int item, Node next) {
            this.key = key;
            this.item = item;
            this.next = next;
        }
    }

    public BinaryHeapPQ() {
        heap = new Node[MAX_SIZE];
    }

    @Override
    public void insert(int x) {
        Node newNode = new Node()
    }

    @Override
    public int delete() {
        return 0;
    }


    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }


    @Override
    public void makeEmpty() {

    }

    @Override
    public int compareTo(Integer o) {
        return 0;
    }
}
