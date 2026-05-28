package BinarySearchTree;



public class BinarySearchTree {

    Node root;

    class Node{
        int value;
        Node left;
        Node right;
        public Node(int value){
            this.value = value;
        }
    }

    public boolean insert(int value){
        Node newNode = new Node(value);
        if(root == null){
            root = newNode;
            return true;
        }

        Node current = root;
        while (true){
            if(current.value == value) return false;
            if(current.value < value){
                if (current.right == null){
                    current.right = newNode;
                    return true;
                }
                current = current.right;


            }
            else {
                if(current.left == null){
                    current.left = newNode;
                    return true;
                }
                current = current.left;
            }

        }


    }
    public boolean contains(int value){
        Node current = root;
        while (current!=null){
            if(current.value == value) return true;
            if(current.value < value){
                current = current.right;
            }
            else {
                current = current.left;
            }

        }
        return false;
    }





}
