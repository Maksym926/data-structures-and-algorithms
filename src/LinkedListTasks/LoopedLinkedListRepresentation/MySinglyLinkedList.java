package LinkedListTasks.LoopedLinkedListRepresentation;

public class MySinglyLinkedList{
    public MySinglyLinkedListNode head;
    public MySinglyLinkedListNode tail;

    public MySinglyLinkedList(){
        this.head = null;
        this.tail = null;
    }

    public void insertValue(int value){
        MySinglyLinkedListNode node = new MySinglyLinkedListNode(value);
        if(head == null){
            head =  node;
        }
        else{
            this.tail.next = node;

        }
        this.tail = node;
        tail.next = head; // create a loop in a Linked List


    }

}
