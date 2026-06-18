package recursiveBinarySearchTree;



public class RecursiveBST {
    Node root;
    class Node{
        int value;
        Node right;
        Node left;
        public Node (int value){
            this.value = value;

        }
    }
    private boolean rContains(Node currentNode, int value){
        if(currentNode == null) return false;
        if(currentNode.value == value) return true;

        if(value < currentNode.value){
            return rContains(currentNode.left, value);
        }else{
            return rContains(currentNode.right, value);
        }

    }
    private Node rInsert(Node currentNode, int value){
        if(currentNode == null) return new Node(value);

        if(value < currentNode.value){
            currentNode.left = rInsert(currentNode.left, value);
        }else{
            currentNode.right = rInsert(currentNode.right, value);
        }
        return currentNode;
    }
    public Node deleteNode(Node currentNode, int value){
        if(currentNode == null) return null;
        if(value < currentNode.value){
            currentNode.left = deleteNode(currentNode.left, value);
        } else if (value > currentNode.value) {
            currentNode.right = deleteNode(currentNode.right, value);
        }
        else {

            if(currentNode.left == null && currentNode.right == null){
                return null;
            }
            else if(currentNode.left == null ){
                currentNode = currentNode.right;
            }else if(currentNode.right == null){
                currentNode = currentNode.left;
            }else{
                int subTreeMin = findMinimumValue(currentNode.right);
                currentNode.value = subTreeMin;
                currentNode.right = deleteNode(currentNode.right, subTreeMin);
            }





        }
        return currentNode;
    }
    private int findMinimumValue(Node node){
        while(node.left != null){
            node = node.left;

        }
        return node.value;


    }
    public void deleteNode(int value){
        deleteNode(root, value);
    }
    public void rInsert(int value){
        if(root == null) root = new Node(value);
        rInsert(root, value);
    }
    public boolean rContains(int value){
        return rContains(root, value);
    }
    private Node sortedArrayToBST(int[] nums, int left, int right){
        Node bst = null;
        if(right >= left){
            int mid = (left + right) / 2;
            bst = new Node(nums[mid]);
            bst.left = sortedArrayToBST(nums, left, mid - 1);
            bst.right = sortedArrayToBST(nums, mid+1, right);
        }
        return bst;
    }
    public void sortedArrayToBST(int[] nums){
        root = sortedArrayToBST(nums, 0, nums.length - 1);
    }
    private Node invertTree(Node node){
        if(node == null) return null;
        Node temp = node.left;
        node.left = node.right;
        node.right = temp;
        invertTree(node.left);
        invertTree(node.right);
        return node;
    }
    public void invertTree(){
        root = invertTree(root);
    }
}
