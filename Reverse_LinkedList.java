/**
 * Problem: Reverse Linked List
 *
 * Description:
 * Given the head of a singly linked list, reverse the list and return the reversed list.
 *
 * Example:
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 *
 * Approach:
 * Use three pointers to iteratively reverse the linked list in place:
 * - prev: points to the previous node (which will become the next node in the reversed list)
 * - curr: points to the current node being processed
 * - agla: temporarily stores the next node before we modify curr.next
 */
public class Reverse_LinkedList {

    // Definition for singly-linked list
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        // Test case 1: [1,2,3,4,5] -> [5,4,3,2,1]
        ListNode test1 = createLinkedList(new int[]{1, 2, 3, 4, 5});
        System.out.println("Original list: ");
        printList(test1);

        ListNode reversed1 = new Solution().reverseList(test1);
        System.out.println("Reversed list: ");
        printList(reversed1);

        // Test case 2: [1,2] -> [2,1]
        ListNode test2 = createLinkedList(new int[]{1, 2});
        System.out.println("\nOriginal list: ");
        printList(test2);

        ListNode reversed2 = new Solution().reverseList(test2);
        System.out.println("Reversed list: ");
        printList(reversed2);

        // Test case 3: [1] -> [1]
        ListNode test3 = createLinkedList(new int[]{1});
        System.out.println("\nOriginal list: ");
        printList(test3);

        ListNode reversed3 = new Solution().reverseList(test3);
        System.out.println("Reversed list: ");
        printList(reversed3);
    }

    // Helper method to create a linked list from an array
    public static ListNode createLinkedList(int[] values) {
        if (values == null || values.length == 0) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        for (int val : values) {
            current.next = new ListNode(val);
            current = current.next;
        }

        return dummy.next;
    }

    // Helper method to print a linked list
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }

    // Solution class
    static class Solution {
        /**
         * Reverses a linked list
         * @param head The head of the linked list to reverse
         * @return The new head of the reversed linked list
         */
        public ListNode reverseList(ListNode head) {
            ListNode curr = head;   // Current node we're processing
            ListNode prev = null;   // Previous node (starts as null)
            ListNode agla = null;   // Next node ("agla" means "next" in Hindi)

            while(curr != null) {
                // Store next node before we change the pointer
                agla = curr.next;

                // Reverse the pointer
                curr.next = prev;

                // Move pointers one step forward
                prev = curr;
                curr = agla;
            }

            return prev;  // New head of the reversed list
        }
    }
}