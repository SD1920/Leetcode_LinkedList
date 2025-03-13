

/**
 * Question:
 * Given a singly linked list, the twin sum of a node is defined as the sum of a node
 * and its twin, where twins are pairs from the first and second halves of the list.
 * The list is guaranteed to have an even number of nodes.
 * Our goal is to find the maximum twin sum in the linked list.
 *
 * Example:
 * Input: [5, 4, 2, 1]
 * Twin pairs: (5,1), (4,2)
 * Sums: 5+1 = 6, 4+2 = 6
 * Output: 6 (maximum twin sum)
 */

/**
 * Definition for singly-linked list.
 * Represents a node in a singly linked list.
 */
/*
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
*/

public class Max_TwinSum_LinkedList {
    // Helper method to reverse a linked list
    public ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        ListNode agla = null; // 'agla' means 'next' in Hindi

        // Iterate through the list, reversing the pointers
        while (curr != null) {
            agla = curr.next; // Store the next node
            curr.next = prev; // Reverse the link
            prev = curr; // Move 'prev' to the current node
            curr = agla; // Move to the next node
        }

        return prev; // 'prev' will be the new head after reversal
    }

    // Method to find the maximum twin sum in the linked list
    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // Find the middle of the linked list using slow and fast pointers
        while (fast.next.next != null) {
            slow = slow.next;      // Moves one step
            fast = fast.next.next; // Moves two steps
        }

        // Reverse the second half of the linked list
        slow.next = reverse(slow.next);

        int maxSum = 0;
        ListNode head1 = head;    // Pointer to the first half
        ListNode head2 = slow.next; // Pointer to the reversed second half

        // Calculate the maximum twin sum
        while (head2 != null) {
            int sum = head1.val + head2.val;
            if (maxSum < sum) {
                maxSum = sum; // Update maxSum if the current sum is greater
            }
            head1 = head1.next; // Move to next node in the first half
            head2 = head2.next; // Move to next node in the reversed second half
        }

        return maxSum; // Return the maximum twin sum found
    }

    // Simple test method to demonstrate the algorithm
    public static void main(String[] args) {
        // Example Linked List: [5,4,2,1]
        ListNode head = new ListNode(5, new ListNode(4, new ListNode(2, new ListNode(1))));

        Max_TwinSum_LinkedList solution = new Max_TwinSum_LinkedList();
        int result = solution.pairSum(head);

        System.out.println("Maximum Twin Sum: " + result); // Expected Output: 6 (5+1=6)
    }
}
