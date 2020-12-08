public class TestPriorityQueues {
    public static void main(String[] args) {
        LinkedListPQ linkedListQueue = new LinkedListPQ();
        BinaryHeapPQ binaryHeapPQ = new BinaryHeapPQ();

        for (int i = 0; i < 10000; i++) {
            int random = (int) (Math.random() * (50000 - 0 + 1));
            binaryHeapPQ.insert(random);
            linkedListQueue.insert(random);
        }

        System.out.println("Size of LinkedList priority queue is: " + linkedListQueue.size());
        System.out.println("Size of BinaryHeap priority queue is: " + binaryHeapPQ.size());


        System.out.println("Smallest item in LinkedList: " + linkedListQueue.peek());
        System.out.println("Smallest item in BinaryHeap: " + binaryHeapPQ.peek());

        linkedListQueue.delete();
        System.out.println("Smallest item in LinkedList after delete: " + linkedListQueue.peek());
        binaryHeapPQ.delete();
    }
}
