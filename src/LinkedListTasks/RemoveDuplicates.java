package LinkedListTasks;

import LinkedListTasks.LinkedListRepresentation.MySinglyLinkedList;
import LinkedListTasks.LinkedListRepresentation.MySinglyLinkedListNode;
import LinkedListTasks.LinkedListRepresentation.MySinglyLinkedListPrintHelper;

public class RemoveDuplicates {
    public static void main(String[] args){
        MySinglyLinkedList linkedList = new MySinglyLinkedList();
        linkedList.insertValue(1);
        linkedList.insertValue(2);
        linkedList.insertValue(3);
        linkedList.insertValue(1);
        linkedList.insertValue(2);
        linkedList.insertValue(1);
        MySinglyLinkedListNode result = removeDuplicates(linkedList.head);

        MySinglyLinkedListPrintHelper.printList(result, "\n");
    }


    /**
     * About task
     * Given the linked list, that may have duplicates
     * the method should return linked list without duplicates in the same order
     */
    /**
     * Solution
     * The idea is to use two pointers first pointer represents origin node and second represents potential duplicate
     *
     * The first pointer (origin) selects the current node.
     * The second pointer (potentialDuplicate) scans the remaining
     * nodes to check for duplicates of the origin node.
     * A third pointer (prevNode) keeps track of the node before
     * potentialDuplicate to allow removal of duplicates.
     *
     *For each origin node, all nodes are compared to it
     * If duplicate is found we remove it by pointing prevNode to the node after potentialDuplicate node
     *
     * Time complexity O(n^2)
     * Space complexity O(1)
     */
    private static MySinglyLinkedListNode removeDuplicates(MySinglyLinkedListNode head){
        MySinglyLinkedListNode origin = head;

        while (origin != null){
            MySinglyLinkedListNode prevNode = origin;
            MySinglyLinkedListNode potentialDuplicate = origin.next;
            while (potentialDuplicate != null ){
                if(origin.data == potentialDuplicate.data){
                    prevNode.next = potentialDuplicate.next;
                    potentialDuplicate = potentialDuplicate.next;
                }else {
                    prevNode = potentialDuplicate;
                    potentialDuplicate = potentialDuplicate.next;
                }

            }

            origin = origin.next;



        }
        return head;



    }
}
