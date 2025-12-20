package LinkedListTasks.LoopedLinkedListRepresentation;

public class MySinglyLinkedListPrintHelper {
    public static void printList(MySinglyLinkedListNode node, String sep) {
        while (node != null) {
            System.out.print(node.data);

            node = node.next;

            if (node != null) {
                System.out.print(sep);
            }
        }
    }
}
