package LinkedListTasks;

import LinkedListTasks.LinkedListRepresentation.MySinglyLinkedList;
import LinkedListTasks.LinkedListRepresentation.MySinglyLinkedListNode;

public class BinaryToDecimalLL {
    public static void main(String[] args){
        MySinglyLinkedList linkedList = new MySinglyLinkedList();
        linkedList.insertValue(0);
        linkedList.insertValue(1);
        linkedList.insertValue(1);
        linkedList.insertValue(1);
        System.out.println(binaryToDecimal(linkedList.head));


    }


    /**
     * About task
     * It is given a linked list where all the numbers are either going to be 0 or 1
     * program should convert binary number, represented by the linked list, into its decimal equivalent
     *
     * For instance:
     * 1->1->1->1 represents the binary number 1111, which equals to 15 in decimal
     *
     */

    /**
     * solution 1(Assumes that linked list stores the binary number in reverse order)
     *
     * Steps
     * 1) check if linked list not null
     * 2) create two instances for tracking the total sum and power
     * 3) while loop works until it reaches the end of the linked list
     * 4) if the data in the node equals to 1 we shift bit 1 left by power positions, which equals 2^power
     * 4) if the data in the node is other number we increase the power
     * 5) in the end we switch to further node
     * 6) return total sum
     *
     * Time complexity is O(n)
     * Space complexity is O(1)
     *
     */
    private static int binaryToDecimal(MySinglyLinkedListNode head){
        MySinglyLinkedListNode node = head;
        if(node == null)
            return 0;

        int sum = 0;
        int power = 0;
        while (node != null){
            if(node.data == 1){
                sum += (1 << power);
            }
            power++;
            node = node.next;
        }
        return sum;
    }
    /**
     * solution 2 (Assumes that linked list store the binary number in normal order)
     *
     * Steps:
     * 1) check if linked list not null
     * 2) create two instances for tracking the total sum
     * 3) while loop works until it reaches the end of the linked list
     * 4) et the beginning double the sum
     * 5) if the data in the node equals to 1 add 1 to the sum
     * 4) in other case we switch to the next node
     * 5) return total sum
     *
     * Time complexity is O(n)
     * Space complexity is O(1)
     */
    public int binaryToDecimal2(MySinglyLinkedListNode head){
        if(head == null) return 0;

        int sum = 0;
        while(head!=null){
            sum += sum;
            if(head.data == 1){
                sum++;
            }
            head = head.next;
        }
        return sum;

    }
}
