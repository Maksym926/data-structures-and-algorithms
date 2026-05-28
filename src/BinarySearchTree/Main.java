package BinarySearchTree;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(4);
        binarySearchTree.insert(2);
        binarySearchTree.insert(3);
        System.out.println(binarySearchTree.root.left.right.value);

        System.out.println(binarySearchTree.contains(4));
    }
}
