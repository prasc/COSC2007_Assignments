public class TestTwoThreeTree {

    public static void main(String[] args) {
        TwoThreeTree newTree = new TwoThreeTree();

        newTree.insert("Lord of The Rings", "test");
        newTree.insert("The Outsiders", "test");
        newTree.insert("Harry Potter", "test");
        newTree.insert("The Matrix", "test");
        newTree.insert("Home Alone", "test");
        newTree.insert("1984", "test");
        newTree.insert("Tommy Boy", "test");

        newTree.inOrderDisplay(newTree.root);

        System.out.println();
        newTree.delete("Harry Potter");
        newTree.inOrderDisplay(newTree.root);
        System.out.println();
        System.out.println("Searching for 1984: " + newTree.search("1984"));
        System.out.println("Searching for random book: " + newTree.search("random book"));

        System.out.println();
        System.out.println("Display pre-order: ");
        newTree.preOrderDisplay(newTree.root);
    }
}

