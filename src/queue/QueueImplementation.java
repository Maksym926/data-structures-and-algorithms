package queue;

import stack.StackImplementation;

public class QueueImplementation {
    class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
        }
    }
    private Node first;
    private Node last;
    private int length;
    public QueueImplementation(int data){
        Node node = new Node(data);
        first = node;
        last = node;
        length = 1;
    }
    public void getFirst(){
        System.out.println(first.data);
    }
    public void getLast(){
        System.out.println(last.data);
    }
    public void getLength(){
        System.out.println(length);
    }
    public void enqueue(int data){
        Node newNode = new Node(data);
        if (length == 0){
            first = newNode;
            last = newNode;
        }else{
            last.next = newNode;
            last = newNode;
        }
        length++;

    }
    public Node dequeue(){
        if(length ==0)return null;
        Node temp = first;
        if(length == 1){
            first = null;
            last = null;
        }else {

            first = first.next;
            temp.next = null;

        }
        length--;
        return temp;

    }



}
