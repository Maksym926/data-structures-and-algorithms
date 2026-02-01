package DoublyLinkedList.Representation;

public class DoublyLinkedList {
    public DoublyLinkedListNode head;
    public DoublyLinkedListNode tail;
    public int length = 0;


    public DoublyLinkedList(){
        this.head = null;
        this.tail = null;
    }

    public void insertNode(int data){
        DoublyLinkedListNode node = new DoublyLinkedListNode(data);
        if(head == null){
            this.head = node;

        }
        else{
            node.prev = tail;
            this.tail.next = node;

        }
        this.tail = node;
        length++;
    }
    public int getLength(){
        return  length;
    }
    public void printLinkedList(){
        DoublyLinkedListNode node = head;
        while(node != null){
            System.out.println(node.data);
            node = node.next;
        }
    }
    public void getHead(){
        System.out.println("Head: " + head.data);
    }
    public void getTail(){
        System.out.println("Tail: " + tail.data);
    }

}
