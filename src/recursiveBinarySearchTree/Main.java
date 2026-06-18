package recursiveBinarySearchTree;

public class Main {
    public static void main(String[] args){
        RecursiveBST BST = new RecursiveBST();

        // Test rInsert
        BST.rInsert(9);
        BST.rInsert(4);
        BST.rInsert(20);
        BST.rInsert(1);
        BST.rInsert(6);
        BST.rInsert(15);
        BST.rInsert(170);

        // Test rContains
        System.out.println("Contains 6: " + BST.rContains(6));    // true
        System.out.println("Contains 99: " + BST.rContains(99));  // false

        // Test deleteNode - leaf node
        BST.deleteNode(1);
        System.out.println("Contains 1 after delete: " + BST.rContains(1)); // false

        // Test deleteNode - node with one child
        BST.deleteNode(20);
        System.out.println("Contains 20 after delete: " + BST.rContains(20)); // false
        System.out.println("Contains 15 still there: " + BST.rContains(15)); // true

        // Test deleteNode - node with two children
        BST.deleteNode(4);
        System.out.println("Contains 4 after delete: " + BST.rContains(4));  // false
        System.out.println("Contains 6 still there: " + BST.rContains(6));   // true
    }
}
