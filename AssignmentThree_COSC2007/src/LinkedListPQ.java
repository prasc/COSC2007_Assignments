public class LinkedListPQ implements PriorityQueueInterface {

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

    private Node head;


    public LinkedListPQ() {
        this.head = null;
    }


    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public int size() {
        int count = 0;
        Node curr = head;

        if (curr != null) count++;

        while (curr.next != null) {
            count++;
            curr = curr.next;
        }
        return count;
    }

    @Override
    public void insert(int key) {
        Node newNode = new Node(key, 0, null);
        Node curr = head;

        if (curr == null || key < curr.key) {
            newNode.next = head;
            head = newNode;
        } else {
            while (curr.next != null && key > curr.next.key) {
                curr = curr.next;
            }
            newNode.next = curr.next;
            curr.next = newNode;
        }
    }

    public int peek() {
        return head.item;
    }

    @Override
    public int delete() {
        if (size() == 0) throw new EmptyPQException("Queue is empty");

        int temp = peek();

        head = head.next;

        return temp;

    }

    @Override
    public void makeEmpty() {
        head = null;
    }


    @Override
    public int compareTo(Integer o) {
        return 0;
    }

}
