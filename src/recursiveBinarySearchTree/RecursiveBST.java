package recursiveBinarySearchTree;

public class RecursiveBST {
    Node root;

    class Node {
        int value;
        Node right;
        Node left;

        public Node(int value) {
            this.value = value;
        }
    }

    // Recursively searches the tree for a value.
    // Goes left if value is smaller, right if larger.
    // Returns false when we fall off the tree (null), true when found.
    private boolean rContains(Node currentNode, int value) {
        if (currentNode == null) return false;
        if (currentNode.value == value) return true;

        if (value < currentNode.value) {
            return rContains(currentNode.left, value);
        } else {
            return rContains(currentNode.right, value);
        }
    }

    // Recursively inserts a value into the correct BST position.
    // Base case: null spot found — create and return the new node.
    // The assignment (currentNode.left/right = rInsert(...)) re-links
    // the returned node back into the tree on the way up.
    private Node rInsert(Node currentNode, int value) {
        if (currentNode == null) return new Node(value);

        if (value < currentNode.value) {
            currentNode.left = rInsert(currentNode.left, value);
        } else {
            currentNode.right = rInsert(currentNode.right, value);
        }
        return currentNode;
    }

    // Recursively deletes a node with the given value. Three cases:
    // 1. Leaf node (no children)       → return null to remove it
    // 2. One child                     → replace node with that child
    // 3. Two children                  → replace value with in-order successor
    //    (minimum of right subtree), then delete that successor from the right subtree
    public Node deleteNode(Node currentNode, int value) {
        if (currentNode == null) return null;

        if (value < currentNode.value) {
            currentNode.left = deleteNode(currentNode.left, value);
        } else if (value > currentNode.value) {
            currentNode.right = deleteNode(currentNode.right, value);
        } else {
            // Node to delete found
            if (currentNode.left == null && currentNode.right == null) {
                return null;
            } else if (currentNode.left == null) {
                currentNode = currentNode.right;
            } else if (currentNode.right == null) {
                currentNode = currentNode.left;
            } else {
                // Find the smallest value in the right subtree (in-order successor)
                // and copy it here, then delete it from the right subtree
                int subTreeMin = findMinimumValue(currentNode.right);
                currentNode.value = subTreeMin;
                currentNode.right = deleteNode(currentNode.right, subTreeMin);
            }
        }
        return currentNode;
    }

    // Finds the minimum value in a subtree by going left until there is no left child.
    private int findMinimumValue(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node.value;
    }

    // Builds a height-balanced BST from a sorted array.
    // Always picks the middle element as the root so both halves are equal in size,
    // then recursively does the same for the left and right subarrays.
    private Node sortedArrayToBST(int[] nums, int left, int right) {
        Node bst = null;
        if (right >= left) {
            int mid = (left + right) / 2;
            bst = new Node(nums[mid]);
            bst.left = sortedArrayToBST(nums, left, mid - 1);
            bst.right = sortedArrayToBST(nums, mid + 1, right);
        }
        return bst;
    }

    // Swaps left and right children at every node recursively,
    // producing a mirror image of the original tree.
    private Node invertTree(Node node) {
        if (node == null) return null;
        Node temp = node.left;
        node.left = node.right;
        node.right = temp;
        invertTree(node.left);
        invertTree(node.right);
        return node;
    }

    public void deleteNode(int value) {
        root = deleteNode(root, value);
    }

    public void rInsert(int value) {
        root = rInsert(root, value);
    }

    public boolean rContains(int value) {
        return rContains(root, value);
    }

    public void sortedArrayToBST(int[] nums) {
        root = sortedArrayToBST(nums, 0, nums.length - 1);
    }

    public void invertTree() {
        root = invertTree(root);
    }
}
