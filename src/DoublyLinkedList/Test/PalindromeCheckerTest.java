package DoublyLinkedList.Test;

import DoublyLinkedList.Solutions.DoublyLinkedList;

public class PalindromeCheckerTest {
    public static void main(String[] args){
        DoublyLinkedList myList;

        System.out.println("Test 7: Odd-Length Non-Palindrome");
        myList = new DoublyLinkedList();
        myList.append(1);
        myList.append(2);
        myList.append(3);
        myList.append(4);
        myList.append(1);
        System.out.print("List: ");

        System.out.println("Expected: false");
        System.out.println("Actual: " + myList.isPalindrome());
        System.out.println();
    }
}
