package treeTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    Node root;

    class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }
    }

    public void insert(int value) {
        root = insert(root, value);
    }

    private Node insert(Node currentNode, int value) {
        if (currentNode == null) return new Node(value);
        if (value < currentNode.value) {
            currentNode.left = insert(currentNode.left, value);
        } else {
            currentNode.right = insert(currentNode.right, value);
        }
        return currentNode;
    }

    // Visits nodes level by level using a queue (FIFO).
    // Enqueue root, then for each dequeued node enqueue its children.
    public ArrayList<Integer> BFS() {
        ArrayList<Integer> res = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node removingNode = queue.remove();
            res.add(removingNode.value);
            if (removingNode.left != null) queue.add(removingNode.left);
            if (removingNode.right != null) queue.add(removingNode.right);
        }
        return res;
    }

    // Root → Left → Right
    // Visits current node first, then recurses into left and right subtrees.
    public ArrayList<Integer> DFSPreOrder() {
        ArrayList<Integer> results = new ArrayList<>();
        class Traverse {
            Traverse(Node currentNode) {
                results.add(currentNode.value);
                if (currentNode.left != null) new Traverse(currentNode.left);
                if (currentNode.right != null) new Traverse(currentNode.right);
            }
        }
        new Traverse(root);
        return results;
    }

    // Left → Right → Root
    // Recurses into both subtrees first, then visits current node.
    public ArrayList<Integer> DFSPostOrder() {
        ArrayList<Integer> results = new ArrayList<>();
        class Traverse {
            Traverse(Node currentNode) {
                if (currentNode.left != null) new Traverse(currentNode.left);
                if (currentNode.right != null) new Traverse(currentNode.right);
                results.add(currentNode.value);
            }
        }
        new Traverse(root);
        return results;
    }

    // Left → Root → Right
    // For a BST this always returns values in ascending sorted order.
    public ArrayList<Integer> DFSInOrder() {
        ArrayList<Integer> results = new ArrayList<>();
        class Traverse {
            Traverse(Node currentNode) {
                if (currentNode.left != null) new Traverse(currentNode.left);
                results.add(currentNode.value);
                if (currentNode.right != null) new Traverse(currentNode.right);
            }
        }
        new Traverse(root);
        return results;
    }
}
