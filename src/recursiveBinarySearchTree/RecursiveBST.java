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
}
