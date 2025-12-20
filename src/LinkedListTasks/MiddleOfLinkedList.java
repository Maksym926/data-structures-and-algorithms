package LinkedListTasks;


import LinkedListTasks.LinkedListRepresentation.MySinglyLinkedList;
import LinkedListTasks.LinkedListRepresentation.MySinglyLinkedListNode;

public class MiddleOfLinkedList {
    public static void main(String[] args){
        MySinglyLinkedList linkedList = new MySinglyLinkedList();
        linkedList.insertValue(1);
        linkedList.insertValue(2);
        linkedList.insertValue(3);
        linkedList.insertValue(4);


        System.out.println(findTheMiddleElement(linkedList.head));

    }

    /*
    About task
    It is needed to find the middle node of the linked list.
    if the linked list has even number of nodes, the second middle node should be returned
     */

    /*
    Solution
    Create two pointers slow and fast, which start from head of the linked list
    Is idea id to move slow at one node at a time and fast at two nodes at a time

    When the fast pointer reaches the end of the list (null),
    the slow pointer will be positioned at the middle node.
    For even-length lists, this approach naturally returns
    the second middle node.

    Time complexity O(n)
    Spase complexity O(1)
     */
    private static Integer findTheMiddleElement(MySinglyLinkedListNode head){
        MySinglyLinkedListNode slow = head;
        MySinglyLinkedListNode fast = head;

        if(head == null)
            return null;

        while (fast!= null && fast.next != null){
            fast = fast.next.next;

            slow = slow.next;
        }

        return slow.data;
    }


}
