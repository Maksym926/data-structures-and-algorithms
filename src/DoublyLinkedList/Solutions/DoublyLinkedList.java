package DoublyLinkedList.Solutions;

public class DoublyLinkedList {
    public DoublyLinkedListNode head;
    public DoublyLinkedListNode tail;
    public int length = 0;

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
    /**
     * Task: Remove the last node of the DoublyLinkedList
     *
     * Solution
     * First of all we assign tail to a temp variable
     * Then we check how many elements in the list:
     * if list is empty, the null is returned
     * if list contains one element, method returns this element and clear head and tail pointers
     * Otherwise, make tail point to the previous element and assign next element from tail as null
     * After assign previous element from temp to null, decrease the length and return null
     */
    public DoublyLinkedListNode removeLast(){

        DoublyLinkedListNode temp = tail;
        if(length == 0)
            return null;
        else if(length == 1){
            head = null;
            tail = null;
        }
        else{
            tail = tail.prev;
            tail.next = null;
            temp.prev = null;
        }


        length--;
        return temp;

    }

    /**
     * Task add the new node to front of th list and make it as a head node
     *
     * Solution
     * First of all, the new node with received value is created, then we check the length of the list.
     * if length equals to 0, the new node becomes a head
     * In other case set the prev attribute of the head node to the new node and set next attribute of the new node to the head
     * Finally, set new node as a head and increase length of list on one
     *
     */
    public void prepend(int i){
        DoublyLinkedListNode node = new DoublyLinkedListNode(i);
        if(length == 0){
            this.head = node;
            this.tail = node;
        }
        else{
            this.head.prev = node;
            node.next = this.head;
            this.head = node;
        }
        length++;
    }


}
