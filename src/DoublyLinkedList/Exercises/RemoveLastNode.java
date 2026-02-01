package DoublyLinkedList.Exercises;

import DoublyLinkedList.Representation.*;
public class RemoveLastNode {
    public static void main(String[] args){
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.insertNode(1);
        doublyLinkedList.insertNode(2);
        doublyLinkedList.insertNode(3);
        doublyLinkedList.insertNode(4);
        doublyLinkedList.insertNode(5);
//        doublyLinkedList.getHead();
//        doublyLinkedList.getTail();
        System.out.println(removeLast(doublyLinkedList).data);
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
    public static DoublyLinkedListNode removeLast(DoublyLinkedList doublyLinkedList){
        int length = doublyLinkedList.getLength();
        DoublyLinkedListNode tail = doublyLinkedList.tail;
        DoublyLinkedListNode head = doublyLinkedList.head;
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


        doublyLinkedList.length--;
        return temp;

    }
}
