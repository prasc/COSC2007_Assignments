public class TestPriorityQueues {
    public static void main(String[] args) {
        LinkedListPQ linkedListQueue = new LinkedListPQ();

        linkedListQueue.insert(10);
        linkedListQueue.insert(5);
        linkedListQueue.insert(50);
        linkedListQueue.insert(2);
        linkedListQueue.insert(7);

        System.out.println("Size is: " + linkedListQueue.size());
    }
}
