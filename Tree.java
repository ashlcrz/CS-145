// Tree.java
// Ashling and Evan *DID EXTRA CREDIT*

import java.util.Stack;

// TreeNode class definition
class TreeNode<T extends Comparable<T>> {
    TreeNode<T> leftNode;  // left node  
    T data;                // node value
    TreeNode<T> rightNode; // right node

    // constructor initializes data and makes this a leaf node
    public TreeNode(T nodeData) { 
        data = nodeData;              
        leftNode = rightNode = null;  // node has no children
    }
}

// Tree class definition
public class Tree<T extends Comparable<T>> {
    private TreeNode<T> root;

    // constructor initializes an empty Tree
    public Tree() { 
        root = null; 
    }

    // insert a new node in the binary search tree
    public void insertNode(T insertValue) {
        if (root == null) {
            root = new TreeNode<>(insertValue); // create root node
        } else {
            insertNode(root, insertValue);
        }
    }

    // helper method to insert node iteratively
    private void insertNode(TreeNode<T> node, T insertValue) {
        while (true) {
            if (insertValue.compareTo(node.data) < 0) {
                if (node.leftNode == null) {
                    node.leftNode = new TreeNode<>(insertValue);
                    break;
                } else {
                    node = node.leftNode;
                }
            } else if (insertValue.compareTo(node.data) > 0) {
                if (node.rightNode == null) {
                    node.rightNode = new TreeNode<>(insertValue);
                    break;
                } else {
                    node = node.rightNode;
                }
            } else {
                break; // duplicate value, do nothing
            }
        }
    }

    // remove a node from the binary search tree
    public void remove(T value) {
        root = removeNode(root, value);
    }

    // helper method to remove a node
    private TreeNode<T> removeNode(TreeNode<T> node, T value) {
        if (node == null) return null;

        if (value.compareTo(node.data) < 0) {
            node.leftNode = removeNode(node.leftNode, value);
        } else if (value.compareTo(node.data) > 0) {
            node.rightNode = removeNode(node.rightNode, value);
        } else {
            if (node.leftNode == null) return node.rightNode;
            if (node.rightNode == null) return node.leftNode;

            TreeNode<T> minNode = findMin(node.rightNode);
            node.data = minNode.data;
            node.rightNode = removeNode(node.rightNode, minNode.data);
        }
        return node;
    }

    // helper method to find the minimum node
    private TreeNode<T> findMin(TreeNode<T> node) {
        while (node.leftNode != null) {
            node = node.leftNode;
        }
        return node;
    }

    // search for a node in the binary search tree
    public boolean search(T value) {
        return searchNode(root, value) != null;
    }

    // helper method to search for a node
    private TreeNode<T> searchNode(TreeNode<T> node, T value) {
        while (node != null) {
            if (value.compareTo(node.data) < 0) {
                node = node.leftNode;
            } else if (value.compareTo(node.data) > 0) {
                node = node.rightNode;
            } else {
                return node;
            }
        }
        return null;
    }

    // iterative pre-order traversal
    public void preorderTraversal() {
        if (root == null) return;
        Stack<TreeNode<T>> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode<T> node = stack.pop();
            System.out.printf("%s ", node.data);

            if (node.rightNode != null) {
                stack.push(node.rightNode);
            }
            if (node.leftNode != null) {
                stack.push(node.leftNode);
            }
        }
    }

    // iterative in-order traversal
    public void inorderTraversal() {
        Stack<TreeNode<T>> stack = new Stack<>();
        TreeNode<T> current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.leftNode;
            }
            current = stack.pop();
            System.out.printf("%s ", current.data);
            current = current.rightNode;
        }
    }

    // iterative post-order traversal
    public void postorderTraversal() {
        if (root == null) return;
        Stack<TreeNode<T>> stack1 = new Stack<>();
        Stack<TreeNode<T>> stack2 = new Stack<>();
        stack1.push(root);

        while (!stack1.isEmpty()) {
            TreeNode<T> node = stack1.pop();
            stack2.push(node);

            if (node.leftNode != null) {
                stack1.push(node.leftNode);
            }
            if (node.rightNode != null) {
                stack1.push(node.rightNode);
            }
        }

        while (!stack2.isEmpty()) {
            TreeNode<T> node = stack2.pop();
            System.out.printf("%s ", node.data);
        }
    }

    // print the tree structure
    public void outputTree(int totalSpace) {
        outputTreeHelper(root, totalSpace >= 0 ? totalSpace : 0, true);
    }

    // recursive method to print tree with dashed lines
    private void outputTreeHelper(TreeNode<T> currentNode, int spaces, boolean isRight) {
        if (currentNode != null) {
            outputTreeHelper(currentNode.rightNode, spaces + 5, true);

            for (int k = 0; k < spaces; k++) {
                System.out.print(" ");
            }
            if (spaces != 0) {
                System.out.print(isRight ? " /-- " : " \\-- ");
            }
            System.out.println(currentNode.data);

            outputTreeHelper(currentNode.leftNode, spaces + 5, false);
        }
    } 
}
