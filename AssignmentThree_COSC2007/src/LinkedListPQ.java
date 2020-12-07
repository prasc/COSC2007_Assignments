public class LinkedListPQ implements PriorityQueueInterface {

    private class Node {
        int priority;
        Node next;

        public Node(int priority, Node next) {
            this.priority = priority;
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


        if (curr != null) {
            count++;

            while (curr.next != null) {
                count++;
                curr = curr.next;
            }
        }


        return count;
    }

    @Override
    public void insert(int priority) {
        Node newNode = new Node(priority, null);
        Node curr = head;

        if (head == null) {
            head = newNode;
        } else if (priority < head.priority) {
            newNode.next = head;
            head = newNode;
        } else {
            while (curr.next!= null && curr.next.priority < priority) {
                curr = curr.next;
            }
            newNode.next = curr.next;
            curr.next = newNode;

        }

    }

    public int peek() {
        return head.priority;
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
