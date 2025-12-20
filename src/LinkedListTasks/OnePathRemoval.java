package LinkedListTasks;

import LinkedListTasks.LinkedListRepresentation.MySinglyLinkedList;
import LinkedListTasks.LinkedListRepresentation.MySinglyLinkedListNode;
import LinkedListTasks.LinkedListRepresentation.MySinglyLinkedListPrintHelper;





public class OnePathRemoval {
    public static void main(String[] args){
        MySinglyLinkedList linkedList = new MySinglyLinkedList();
        linkedList.insertValue(5);
        linkedList.insertValue(6);
        linkedList.insertValue(7);
        linkedList.insertValue(8);
        MySinglyLinkedListNode res =removeKthNodeFromEnd(linkedList.head, 2);
        MySinglyLinkedListPrintHelper printer = new MySinglyLinkedListPrintHelper();
        printer.printList(res, "\n");

    }

    /**
     * About task
     * Given a linked list and the index k (counted from the end).
     * remove the k-th node from the end of the list and return
     * the modified linked list
     */

    /**
     * Solution
     * Create tree pointer prev, slow and fast
     * Slow pointer represents the node which will be deleted
     * Prev pointer is node before pointer on which points slow pointer
     *
     * Let's move fast pointer on k steps forward,
     * then we will start to move the prev node, slow node and fast node together until fast reaches null
     * When fast reaches null slow pointer will point on the correct node, which should be deleted
     *
     * if the slow pointer points on the first node, the head becomes head.next
     *
     * Otherwise, prev node points on the node which is next to slow
     *
     * Time complexity is O(n)
     * Space complexity is O(1)
     */
    public static MySinglyLinkedListNode removeKthNodeFromEnd(MySinglyLinkedListNode head, int k) {

        if(head == null)
            return null;
        MySinglyLinkedListNode prev = null;
        MySinglyLinkedListNode slow = head;
        MySinglyLinkedListNode fast = head;
        for(int i = 0; i < k + 1; i++){
            if(fast == null){
                return head;
            }
            fast = fast.next;
        }

        while (fast != null){
            fast = fast.next;
            prev = slow;
            slow = slow.next;
        }
        if(prev == null){
            return head.next;
        }

        prev.next = slow.next;

        return head;






    }
}