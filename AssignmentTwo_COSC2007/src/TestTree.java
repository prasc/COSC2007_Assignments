
public class TestTree {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        tree.add('b');
        tree.add('c');
        tree.add('d');
        tree.add('e');
        tree.add('f');
        tree.add('g');
        tree.add('z');
        tree.add('a');
        tree.add('B');      // Already exists

        tree.remove('z');

        System.out.println("The min value in the tree is: " + tree.findMin(tree.root));
        System.out.println("The max value in the tree is: " + tree.findMax(tree.root));
        System.out.println("The height of the tree is: " + tree.height(tree.root));


        System.out.println("Preorder: ");
        tree.displayPreOrder();
        System.out.println();


        System.out.println("Inorder: ");
        tree.displayInOrder();
        System.out.println();

        System.out.println("Postorder: ");
        tree.displayPostOrder();
        System.out.println();


    }

}
