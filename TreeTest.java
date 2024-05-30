import java.util.Scanner;

public class TreeTest {
    public static void main(String[] args) {

        //testing
        Tree<Integer> tree = new Tree<>();

        tree.insertNode(50);
        tree.insertNode(50);
        tree.insertNode(30);
        tree.insertNode(70);
        tree.insertNode(20);
        tree.insertNode(40);
        tree.insertNode(60);
        tree.insertNode(80);

        System.out.println("Pre-order Traversal:");
        tree.preorderTraversal();

        System.out.println("\nIn-order Traversal:");
        tree.inorderTraversal();

        System.out.println("\nPost-order Traversal:");
        tree.postorderTraversal();
        
        System.out.println("\nTree Structure:");
        tree.outputTree(0);

        System.out.println("\nRemoving 70...");
        tree.remove(70);
        tree.outputTree(0);
        // user input
        Scanner scanner = new Scanner(System.in);

        System.out.println("Do you want to input values for a tree? (Y/N)");
        String input = scanner.nextLine();

        Tree<Integer> tree2 = new Tree<>();

        if (input.equalsIgnoreCase("Y")) {
            System.out.println("Enter the number of values you want to insert:");
            int count = scanner.nextInt();
            System.out.println("Enter the values:");
            for (int i = 0; i < count; i++) {
                int value = scanner.nextInt();
                tree2.insertNode(value);
            }
        } else {
            // Insert example values into the tree
            int[] values = {50, 30, 70, 20, 40, 60, 80};
            for (int value : values) {
                tree2.insertNode(value);
            }
        }

        // Perform and display different types of traversals
        System.out.println("Preorder traversal:");
        tree2.preorderTraversal();

        System.out.println("\n\nInorder traversal:");
        tree2.inorderTraversal();

        System.out.println("\n\nPostorder traversal:");
        tree2.postorderTraversal();

        // Print a depiction of the tree
        System.out.println("\n\nTree structure:");
        tree2.outputTree(0);

        scanner.close();
    }
}
