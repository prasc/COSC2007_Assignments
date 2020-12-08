public class BinaryHeapPQ implements PriorityQueueInterface {
    private Integer[] heap;
    private static final int MAX_SIZE = 11000;
    private static int size = 0;

    public BinaryHeapPQ() {
        heap = new Integer[MAX_SIZE];
    }


    public int peek() {
        return heap[0];
    }

    @Override
    public void insert(int priority) {
        heap[size] = priority;
        bubbleUp(size);
        size++;
    }

    private void bubbleUp(int size) {
        int parent = (size - 1) / 2;

        if (heap[parent] > heap[size]) {
            int temp = heap[parent];
            heap[parent] = heap[size];
            heap[size] = temp;
            bubbleUp(parent);
        }
    }


    @Override
    public int delete() {
        int temp = heap[0];                 // we're removing the root highest priority (smallest key value) item.

        heap[0] = heap[size - 1];           // root = last element in the queue
        size--;                             // removing last element from queue

        bubbleDown(0);                  // calling bubble down with root

        return temp;
    }

    private void bubbleDown(int i) {
        Integer leftChild = i * 2 + 1;
        Integer rightChild = i * 2 + 2;

        if (leftChild == null && rightChild == null) {
            return;                     // nothing is broken
        } else if (leftChild != null && rightChild == null) {       // only leftChild exists

            if (heap[i] > heap[leftChild]) {                        // parent is bigger than leftChild
                int temp = heap[leftChild];
                heap[leftChild] = heap[i];
                heap[i] = temp;                                     // swap them
                bubbleDown(leftChild);                                    // recursively call function with leftChild
            }

        } else if (rightChild != null && leftChild == null) {

            if (heap[i] > heap[rightChild]) {
                int temp = heap[rightChild];
                heap[rightChild] = heap[i];
                heap[i] = temp;
                bubbleDown(rightChild);
            }

        } else if (leftChild != null && rightChild != null) {        // both children exists
            int min = 0;

            if (heap[leftChild] <= heap[rightChild]) {
                min = leftChild;
            } else {
                min = rightChild;
            }

            // int min = heap[leftChild] <= heap[rightChild] ? leftChild : rightChild;

            if (heap[i] > heap[min]) {
                int temp = heap[min];
                heap[min] = heap[i];
                heap[i] = temp;
                bubbleDown(min);
            }
        }
    }


    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void makeEmpty() {
        for (int i = 0; i < size; i++) {
            heap[i] = null;
        }
        size = 0;
    }

    @Override
    public int compareTo(Integer o) {
        return 0;
    }
}




