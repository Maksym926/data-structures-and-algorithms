package LinkedListTasks;

import LinkedListTasks.LoopedLinkedListRepresentation.MySinglyLinkedList;
import LinkedListTasks.LoopedLinkedListRepresentation.MySinglyLinkedListNode;

public class HasALoop {
    public static void main(String[] args){
        MySinglyLinkedList linkedList = new MySinglyLinkedList();

        linkedList.insertValue(1);
        linkedList.insertValue(2);
        linkedList.insertValue(3);
        linkedList.insertValue(4);

        System.out.println(isHasALoop(linkedList.head));

    }
    /*
    About task
    It is given a linked list, which has or not a loop inside
    A loop exists when a node’s next reference points to any previous node
    in the list, creating a cycle.
     */

    /**
     * Solution
     * Uses Floyd’s Cycle Detection Algorithm
     * create two pointers slow and past, at the beginning they point on head
     * The idea is two move slow pointer one node at a time and fast pointer moves two nodes at a time
     *
     * if fast reaches the slow pointer,meaning that a loop exists
     * but if fast reaches null, it means no loop inside
     *
     * Time complexity is O(n)
     * Space complexity is O(1)
     *
     */
    private static boolean isHasALoop(MySinglyLinkedListNode head){
        MySinglyLinkedListNode slow = head;
        MySinglyLinkedListNode fast = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            if(fast == slow)
                return true;
            slow = slow.next;
        }
        return false;
    }

}
