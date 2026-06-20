package treeTraversal;

public class Main {
    public static void main(String[] args) {
        // Tree:      47
        //           /  \
        //          21  76
        //         /  \
        //        18  27
        BinaryTree tree = new BinaryTree();
        tree.insert(47);
        tree.insert(21);
        tree.insert(76);
        tree.insert(18);
        tree.insert(27);

        System.out.println("BFS:           " + tree.BFS());           // [47, 21, 76, 18, 27]
        System.out.println("DFS PreOrder:  " + tree.DFSPreOrder());   // [47, 21, 18, 27, 76]
        System.out.println("DFS PostOrder: " + tree.DFSPostOrder());  // [18, 27, 21, 76, 47]
        System.out.println("DFS InOrder:   " + tree.DFSInOrder());    // [18, 21, 27, 47, 76]
    }
}
