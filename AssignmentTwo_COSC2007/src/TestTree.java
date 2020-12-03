import java.io.*;
import java.util.Scanner;

public class TestTree {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        BinarySearchTree tree = new BinarySearchTree();


        while (true) {
            System.out.println("Please enter the name of the file");
            String userInput = input.nextLine();

            try {
                File myObj = new File(userInput);
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNext()) {
                    String data = myReader.next();
                    tree.add(data.charAt(0));
                }
                myReader.close();

            } catch (FileNotFoundException e) {
                System.out.println("Invalid file name");
                System.out.println();
                break;
            }
        }

        tree.displayInOrder();
        System.out.println();

        System.out.println("The min value in the tree is: " + tree.findMin(tree.root));
        System.out.println("The max value in the tree is: " + tree.findMax(tree.root));
        System.out.println("The height of the tree is: " + tree.height(tree.root));


        System.out.println("Please enter the character you want to search for");
        String userInput = input.next();
       System.out.println(tree.search(userInput.charAt(0)) != null ? "The character " + userInput + " does exist" : "The character " + userInput + " does not exist");


        System.out.println("Please enter the character you want to remove");
        userInput = input.next();
        tree.remove(userInput.charAt(0));

        tree.displayInOrder();
        System.out.println();



    }

}


//        tree.add('b');
//        tree.add('c');
//        tree.add('d');
//        tree.add('e');
//        tree.add('f');
//        tree.add('g');
//        tree.add('z');
//        tree.add('a');
//        tree.add('B');      // Already exists
//
//        tree.remove('z');
//
//        System.out.println("The min value in the tree is: " + tree.findMin(tree.root));
//        System.out.println("The max value in the tree is: " + tree.findMax(tree.root));
//        System.out.println("The height of the tree is: " + tree.height(tree.root));
//
//
//        System.out.println("Preorder: ");
//        tree.displayPreOrder();
//        System.out.println();
//
//
//        System.out.println("Inorder: ");
//        tree.displayInOrder();
//        System.out.println();
//
//        System.out.println("Postorder: ");
//        tree.displayPostOrder();
//        System.out.println();