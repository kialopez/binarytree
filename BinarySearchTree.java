import java.util.Scanner;

class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

public class BinarySearchTree {
    Node root;

    BinarySearchTree() {
        root = null;
    }

    void insert(int key) {
        root = insertRec(root, key);
    }

    Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.data)
            root.left = insertRec(root.left, key);
        else if (key > root.data)
            root.right = insertRec(root.right, key);

        return root;
    }

    void inorder() {
        inorderRec(root);
    }

    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.data + " ");
            inorderRec(root.right);
        }
    }

    void preorder() {
        preorderRec(root);
    }

    void preorderRec(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    void postorder() {
        postorderRec(root);
    }

    void postorderRec(Node root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.print(root.data + " ");
        }
    }

    void displayArray() {
        System.out.println("1-D Array Representation:");
        displayArrayRec(root, 0);
        System.out.println();
    }

    void displayArrayRec(Node root, int index) {
        if (root != null) {
            System.out.println("Index: " + index + ", Element: " + root.data);
            displayArrayRec(root.left, 2 * index + 1);
            displayArrayRec(root.right, 2 * index + 2);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinarySearchTree tree = new BinarySearchTree();
        boolean continueLoop = true;
        while (continueLoop) {
            System.out.println("Enter an integer to insert into the binary search tree:");
            int value = scanner.nextInt();
            tree.insert(value);
            System.out.println("Binary Search Tree after inserting " + value + ":");
            tree.displayArray();
            System.out.println("Inorder Traversal:");
            tree.inorder();
            System.out.println("\nPreorder Traversal:");
            tree.preorder();
            System.out.println("\nPostorder Traversal:");
            tree.postorder();
            System.out.println("\nDo you want to try again? (yes/no)");
            String choice = scanner.next();
            if (!choice.equalsIgnoreCase("yes")) {
                continueLoop = false;
            }
        }
        scanner.close();
    }
}
