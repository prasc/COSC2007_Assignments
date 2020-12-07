public class TestPriorityQueues {
    public static void main(String[] args) {
        LinkedListPQ linkedListQueue = new LinkedListPQ();
        BinaryHeapPQ binaryHeapPQ = new BinaryHeapPQ();

        for (int i = 0; i < 10000; i++) {
            int random = (int) (Math.random() * (10000 - 50 + 1)) + 50 ;
            binaryHeapPQ.insert(random);
            linkedListQueue.insert(random);
        }

        System.out.println(binaryHeapPQ.size());
        System.out.println(linkedListQueue.size());

        System.out.println("Smallest item in LinkedList: " + linkedListQueue.peek());
        System.out.println("Smallest item in BinaryHeap: " + binaryHeapPQ.peek());
    }
}
