package stack;

public class StackImplementation {
    class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
        }
    }
    private Node top;
    private int height;
    public StackImplementation(int data){
        Node node = new Node(data);
        top = node;
        height = 1;
    }
    public void getTop(){
        System.out.println(top.data);
    }
    public void getHeight(){
        System.out.println(height);
    }
    public void printStack(){
        Node node = top;
        while(node != null){
            System.out.println(node.data);
            node = node.next;
        }
    }
    public void push(int data){
        Node node = new Node(data);
        if(top == null){
            top = node;
        }else{
            node.next = top;
            top = node;
        }
        height++;



    }
    public boolean isEmpty(){
        return top == null;
    }
    public Node pop(){
        if(isEmpty()) return null;
        Node temp = top;
        top = top.next;
        temp.next = null;
        height--;
        return temp;
    }

}
