package DoublyLinkedList.Test;

import DoublyLinkedList.Solutions.DoublyLinkedList;



public class RemoveLastNode {
    public static void main(String[] args){
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.append(1);
        doublyLinkedList.append(2);
        doublyLinkedList.append(3);
        doublyLinkedList.append(4);
        doublyLinkedList.append(5);
//        doublyLinkedList.getHead();
//        doublyLinkedList.getTail();
        System.out.println(doublyLinkedList.removeLast().data);
    }



}
