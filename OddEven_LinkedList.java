import java.util.Scanner;

/**Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.

 The first node is considered odd, and the second node is even, and so on.

 Note that the relative order inside both the even and odd groups should remain as it was in the input.
 **/

// example 1 : Input: head =  [1, 2, 3, 4, 5] => Output : [1, 3, 5, 2, 4]
// example 2 : Input: head =  [2,1,3,5,6,4,7] => Output : [2,3,6,7,1,5,4]

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class OddEven_LinkedList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;  // Edge case handling

        ListNode odd = head, even = head.next, evenHead = even; // pointer declared pointing to oddHead & evenHead respectively

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenHead;  // Connecting odd list to even list

        return head;
    }

    // Helper method to print the linked list
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Main method for testing the solution with user input
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the list elements separated by spaces (e.g., '1 2 3 4 5'):");
        String input = scanner.nextLine();
        String[] tokens = input.trim().split("\\s+");

        // Create linked list from user input
        ListNode head = null;
        ListNode tail = null;
        for (String token : tokens) {
            int value = Integer.parseInt(token);
            ListNode newNode = new ListNode(value);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = tail.next;
            }
        }

        System.out.print("Input List: ");
        printList(head);

        OddEven_LinkedList solution = new OddEven_LinkedList();
        ListNode result = solution.oddEvenList(head);

        System.out.print("Reordered List (Odd nodes followed by Even nodes): ");
        printList(result);

        scanner.close();
    }
}
