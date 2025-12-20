package LinkedListTasks;

import LinkedListTasks.LinkedListRepresentation.MySinglyLinkedListNode;

public class ReverseBetween {

    /**
     * About task
     * Given a linked list and two indexes which represent boundaries where elements should be reversed
     * The method should return the linked list where elements are reversed within given range
     */

    /**
     * Solution:
     *
     * This approach uses three pointers prevNode, currentNode, and moveNode.
     * The prevNode points to the node before the sublist that will be reversed.
     * The currentNode points to the first node of the sublist being reversed.
     * The moveNode is used to move nodes one by one to the front of the sublist.
     *
     * A dummy node is used to simplify edge cases, especially when the
     * reversal starts at the first node of the linked list (m = 0).
     * The dummy node points to the head of the list.
     *
     * First, prevNode is moved to the node just before the lower boundary (m).
     * Then, currentNode is positioned at the lower boundary node.
     *
     * To reverse the sublist, the algorithm performs (n - m) iterations.
     * In each iteration:
     * - moveNode is set to the node after currentNode.
     * - currentNode.next is updated to skip moveNode.
     * - moveNode is inserted immediately after prevNode.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */


    public void reverseBetween(MySinglyLinkedListNode head, int m, int n) {
        MySinglyLinkedListNode dummy = new MySinglyLinkedListNode(0);
        dummy.next = head;
        MySinglyLinkedListNode prevNode = dummy;

        MySinglyLinkedListNode currentNode = head;

        if (m < n) {

            for (int i = 0; i < m; i++) {
                prevNode = prevNode.next;


            }
            currentNode = prevNode.next;

            for (int j = 0; j < n - m; j++) {
                MySinglyLinkedListNode moveNode = currentNode.next;
                currentNode.next = moveNode.next;
                moveNode.next = prevNode.next;
                prevNode.next = moveNode;


            }

            head = dummy.next;
        }
    }
}
