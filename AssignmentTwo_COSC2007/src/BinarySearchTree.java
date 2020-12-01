public class BinarySearchTree {
    public Node root;
    private static Integer count = 0;

    public BinarySearchTree() {
        root = null;
    }

    public Node search(Node root, Character item) {
        item = Character.toLowerCase(item);

        if (root == null || root.getItem() == item) {       // base case
            return root;
        }

        if (item < root.getItem())
            return search(root.getLeftChild(), item);   // recursively search left child
        else
            return search(root.getRightChild(), item);  // recursively search right child
    }

    public void add(Character item) {
        if (search(root, item) != null) {
            System.out.println("Item '" + item + "' already exists");
            count = count.intValue() + 1;
            return;
        } else if (root == null) {
            count = count.intValue() + 1;
            Node newNode = new Node(item, count);
            root = newNode;
        }
        else {
            count = count.intValue() + 1;
            insert(root, item);
        }
    }

    private void insert(Node root, Character item) {
        Node newNode = new Node(item, count);

        if (item < root.getItem()) {
            if (root.getLeftChild() == null)
                root.setLeftChild(newNode);
            else
                insert(root.getLeftChild(), item);          // recursive call

        } else {
            if (root.getRightChild() == null)
                root.setRightChild(newNode);
            else
                insert(root.getRightChild(), item);            // recursive call
        }
    }


    public void remove(Character item) {
        removing(this.root, item);
    }

    private Node removing(Node root, Character item) {

        if(root == null) return root;

        if(item < root.getItem()) {                                     // If Item in on left side of current node
            root.setLeftChild(removing(root.getLeftChild(), item));     // recursively call function with left child of current node
        } else if(item > root.getItem()) {                              // If item is on right side of current node
            root.setRightChild(removing(root.getRightChild(), item));   // recursively call function with right child of current node
        } else {                                                        // Otherwise, we are on the current node to remove
            if(root.getLeftChild() == null && root.getRightChild() == null) {           // Check if node has no children (check if its a leaf node)
                System.out.println("The item "+ item + " is being deleted.");
                return null;
            } else if(root.getLeftChild() == null) {
                System.out.println("The item "+ item + " is being deleted.");           // Check if node only has right child because left is null
                return root.getRightChild();
            } else if(root.getRightChild() == null) {                                   // Check if node only has left child because right is null.
                System.out.println("The item "+ item + " is being deleted.");
                return root.getLeftChild();
            } else {
                                                                                        // If node has two children, block will be executed
                Character minValue = findMin(root.getRightChild());                     // Find min char in right subtree
                root.setItem(minValue);
                root.setRightChild(removing(root.getRightChild(), minValue));
                System.out.println("The item "+ item + " is being deleted.");
            }
        }

        return root;
    }

    public Character findMin(Node currNode) {
        while (currNode.getLeftChild() != null) {
            currNode = currNode.getLeftChild();
        }
        return currNode.getItem();
    }

    public Character findMax(Node currNode) {
        while (currNode.getRightChild() != null) {
            currNode = currNode.getRightChild();
        }
        return currNode.getItem();
    }

    public int height(Node currNode) {
        if (currNode == null) {
            return 0;
        } else {
            int leftCount = height(currNode.getLeftChild());
            int rightCount = height(currNode.getRightChild());
            if (leftCount > rightCount)
                return (leftCount + 1);
            else
                return (rightCount + 1);
        }
    }

    public void displayInOrder() {
        inOrder(root);
    }

    private void inOrder(Node root) {           // L N R
        if (root == null) {
            return;
        }

        inOrder(root.getLeftChild());
        System.out.print(root.getItem() + "(" + root.getCount() + ") ");
        inOrder(root.getRightChild());
    }


    public void displayPreOrder() {
        preOrder(root);
    }

    private void preOrder (Node root) {	// N L R
        if (root == null)
            return;

        System.out.print(root.getItem() + "(" + root.getCount() + ") ");
        preOrder(root.getLeftChild());
        preOrder(root.getRightChild());
    }

    public void displayPostOrder() {
        postOrder(root);
    }

    private void postOrder (Node root) {	// L R N
        if (root == null)
            return;

        postOrder(root.getLeftChild());
        postOrder(root.getRightChild());
        System.out.print(root.getItem() + "(" + root.getCount() + ") ");
    }

}


//    Recursively calculate height of left and right subtrees of a node and assign height to the node as max of the heights of two children plus 1.
