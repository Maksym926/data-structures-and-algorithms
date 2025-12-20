package LinkedListTasks;

import LinkedListTasks.LinkedListRepresentation.MySinglyLinkedList;
import LinkedListTasks.LinkedListRepresentation.MySinglyLinkedListNode;
import LinkedListTasks.LinkedListRepresentation.MySinglyLinkedListPrintHelper;

public class PartitionLinkedList {
    public static void main(String[] args){
        MySinglyLinkedList linkedList = new MySinglyLinkedList();
        linkedList.insertValue(3);
        linkedList.insertValue(8);
        linkedList.insertValue(5);
        linkedList.insertValue(10);
        linkedList.insertValue(2);
        linkedList.insertValue(1);
        MySinglyLinkedListNode res = partitionList(linkedList.head, 5);
        MySinglyLinkedListPrintHelper.printList(res,"\n");


    }

    /**
     * About task
     * Given linked list and number x
     * The linkedList should be partitioned according to the pattern nodes with values smaller than x go first and bigger numbers go second.
     * The order of the numbers doesn't change
     *
     * Note: tail of the linked list can't be used
     */

    /**
     * Solution
     * We use two head and tail nodes for bigger and smaller than x value
     *
     * in the loop, we take the node remember the next node and delete pointer of the current node to the next node,
     * then check if the value is smaller than x update smallerHead node if it's null if not update the smallerTail
     * the same thing with bigger node, we check if the value is bigger than x update biggerHead node if it's null if not update the biggerTail
     *
     * after loop, there are two nodes, with bigger and smaller numbers then the x
     *
     * if the smallerHead is null we return just biggerHead
     *
     * Otherwise, the smallerTail points to the biggerHead and we return smallerHead
     *
     * Time complexity O(n)
     * Space complexity O(1)
     */


    public static MySinglyLinkedListNode partitionList(MySinglyLinkedListNode head, int x){

        MySinglyLinkedListNode node = head;

        MySinglyLinkedListNode biggerHead = null;
        MySinglyLinkedListNode biggerTail = null;

        MySinglyLinkedListNode smallerHead = null;
        MySinglyLinkedListNode smollerTail = null;

        while(node!= null){
            MySinglyLinkedListNode next = node.next;
            node.next = null;
            if(node.data<x){
                if(smallerHead == null){
                    smallerHead = node;

                }
                else{
                    smollerTail.next = node;
                }
                smollerTail = node;

            }else{
                if(biggerHead == null){
                    biggerHead = node;

                }
                else{
                    biggerTail.next = node;
                }
                biggerTail = node;
            }
            node = next;

        }
        if(smallerHead == null){
            return biggerHead;
        }
        smollerTail.next = biggerHead;
        return smallerHead;




    }
}
