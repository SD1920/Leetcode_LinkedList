/**
 * Problem: Delete the Middle Node of a Linked List (LeetCode 2095)
 *
 * You are given the head of a linked list. Delete the middle node, and return the head of the modified linked list.
 *
 * The middle node of a linked list of size n is the ⌊n / 2⌋th node from the start using 0-based indexing.
 * For example, the middle node of a linked list with 5 nodes is the node at index 2.
 */

/**
 * Definition for singly-linked list.
 */

/**
 * Input: head = [1,3,4,"7",1,2,6]
 * Output: [1,3,4,1,2,6]
 * Explanation:
 * The above figure represents the given linked list. The indices of the nodes are written below.
 * Since n = 7, node 3 with value 7 is the middle node, which is quoted.
 * We return the new list after removing this node.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class DeleteMiddleNode {

    public ListNode deleteMiddle(ListNode head) {
        // Edge case: empty list or list with a single node
        if (head == null || head.next == null) {
            return null;
        }

        // Initialize pointers
        ListNode fast = head;      // Will move twice as fast
        ListNode slow = head;      // Will end up at the middle node
        ListNode prev = null;      // Will track the node before slow

        // Find the middle node using the fast and slow pointer technique
        // When fast reaches the end, slow will be at the middle
        while (fast != null && fast.next != null) {
            fast = fast.next.next;  // Move fast pointer by 2 steps
            prev = slow;            // Update prev to current slow before moving
            slow = slow.next;       // Move slow pointer by 1 step
        }

        // At this point, slow is at the middle node
        // Delete the middle node by bypassing it
        prev.next = prev.next.next;

        return head;
    }

    // Helper method to print the linked list (for testing)
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Helper method to create a linked list from an array
    public static ListNode createLinkedList(int[] values) {
        if (values == null || values.length == 0) {
            return null;
        }

        // Create the head node
        ListNode head = new ListNode(values[0]);
        ListNode current = head;

        // Create the rest of the nodes
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }

        return head;
    }

    // Main method to test the solution
    public static void main(String[] args) {
        // Create a sample linked list using the helper method
        int[] values = {1, 3, 4, 7, 1, 2, 6};
        ListNode head = createLinkedList(values);

        System.out.println("Original List:");
        printList(head);

        DeleteMiddleNode solution = new DeleteMiddleNode();
        ListNode result = solution.deleteMiddle(head);

        System.out.println("List after deleting middle node:");
        printList(result);

        // Test with even length list
        System.out.println("\nTesting with even length list:");
        int[] evenValues = {1, 2, 3, 4, 5, 6};
        ListNode evenHead = createLinkedList(evenValues);

        System.out.println("Original List:");
        printList(evenHead);

        ListNode evenResult = solution.deleteMiddle(evenHead);

        System.out.println("List after deleting middle node:");
        printList(evenResult);

        // Test with single node
        System.out.println("\nTesting with single node list:");
        ListNode singleNode = new ListNode(1);

        System.out.println("Original List:");
        printList(singleNode);

        ListNode singleResult = solution.deleteMiddle(singleNode);

        System.out.println("List after deleting middle node:");
        printList(singleResult);
    }
}