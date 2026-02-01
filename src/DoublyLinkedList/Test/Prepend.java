package DoublyLinkedList.Test;

import DoublyLinkedList.Solutions.DoublyLinkedList;


public class Prepend {

    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.insertNode(1);
        doublyLinkedList.insertNode(2);
        doublyLinkedList.insertNode(3);
        doublyLinkedList.insertNode(4);
        doublyLinkedList.insertNode(5);
        doublyLinkedList.prepend(10);
    }


}
