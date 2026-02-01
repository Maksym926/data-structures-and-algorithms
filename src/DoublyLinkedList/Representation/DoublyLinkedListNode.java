package DoublyLinkedList.Representation;

public class DoublyLinkedListNode {
    public int data;
    public DoublyLinkedListNode next;
    public DoublyLinkedListNode prev;

    public DoublyLinkedListNode(int data){
        this.data = data;
        next = null;
        prev = null;
    }
}
