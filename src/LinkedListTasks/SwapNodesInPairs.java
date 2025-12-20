package LinkedListTasks;

import LinkedListTasks.LinkedListRepresentation.MySinglyLinkedListNode;

public class SwapNodesInPairs {
    /**
     * About task
     * Given the linked list,
     * and it's needed to swap two adjacent nodes,
     * if linked list has odd number of nodes we leave last element as it is
     *
     * Solution
     * This task uses three pointer prevNode, first and second
     * The first and second nodes represents two nodes to be swapped
     * The prevNode points on the node before first node and is required to reconnect the swapped nodes correctly
     *
     * At the beginning prevNode equals to dummy node which is points on head node, dummy node is needed to swap two first elements correctly
     *
     * The swapping is performed until first pointer reaches the null(when we have even linked list) or first.next reaches the null(when we have odd linked list)
     *
     * During each swap
     *  Node with first pointer updated to point on the Node after the second pointer
     *  Node with second pointer updated to point on node which points on node with first pointer
     *  Node with prevNode pointer updated to point on node with second pointer
     *
     * Then move to prevNode and first pointers on one node further and repeat the same action again
     *
     * Time complexity O(n)
     * Space complexity O(1)
     *
     */
    public void swapPairs(MySinglyLinkedListNode head) {
        if(head == null)return;
        MySinglyLinkedListNode dummy = new MySinglyLinkedListNode(0);
        dummy.next = head;
        MySinglyLinkedListNode prevNode = dummy;
        MySinglyLinkedListNode first = head;
        while(first != null && first.next != null){
            MySinglyLinkedListNode second = first.next;
            first.next = second.next;
            second.next = first;
            prevNode.next = second;

            prevNode = first;
            first = first.next;
        }
        head = dummy.next;
    }
}
