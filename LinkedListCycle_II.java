/**
 * Problem Statement:
 * -----------------
 * Given a linked list, determine if the linked list has a cycle in it.
 * A cycle occurs when a node in the linked list can be reached again by
 * continuously following the next pointer.
 *
 * This problem is from LeetCode: Linked List Cycle (141)
 *
 * Example:
 * 3 -> 2 -> 0 -> -4
 *      ^           |
 *      |___________|
 *
 * The above linked list has a cycle, as -4 points back to 2.
 */

public class LinkedListCycle_II {
    /**
     * Definition for singly-linked list.
     */
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * Solution Approach:
     * Uses Floyd's Cycle-Finding Algorithm (also known as "tortoise and hare" algorithm)
     * - Use two pointers moving at different speeds
     * - If there's a cycle, the fast pointer will eventually catch up to the slow pointer
     * - If there's no cycle, the fast pointer will reach the end of the list
     *
     * Time Complexity: O(n) where n is the number of nodes in the linked list
     * Space Complexity: O(1) as we only use two pointers regardless of list size
     *
     * @param head The head of the linked list
     * @return true if the linked list has a cycle, false otherwise
     */
    public boolean hasCycle(ListNode head) {
        // Edge cases: empty list or single node list cannot have cycles
        if (head == null || head.next == null) {
            return false;
        }

        // Initialize two pointers: "slow" moves one step, "fast" moves two steps
        ListNode slow = head;
        ListNode fast = head;

        // Continue until fast pointer reaches end of list
        while (fast != null && fast.next != null) {
            // Move slow pointer one step forward
            slow = slow.next;
            // Move fast pointer two steps forward
            fast = fast.next.next;

            // If the two pointers meet, a cycle exists
            if (slow == fast) {
                return true;
            }
        }

        // If we exit the loop, fast pointer reached the end, so no cycle
        return false;
    }

    /**
     * Main method to demonstrate the cycle detection functionality
     * Creates two test cases:
     * 1. A linked list with a cycle
     * 2. A linked list without a cycle
     */
    public static void main(String[] args) {
        LinkedListCycle_II solution = new LinkedListCycle_II();

        // Test Case 1: Create a linked list with a cycle
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(0);
        ListNode n4 = new ListNode(-4);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n2;  // Creating a cycle by pointing back to n2

        System.out.println("Test Case 1 (List with cycle): " +
                solution.hasCycle(n1));  // Should print true

        // Test Case 2: Create a linked list without a cycle
        ListNode m1 = new ListNode(1);
        ListNode m2 = new ListNode(2);
        ListNode m3 = new ListNode(3);
        ListNode m4 = new ListNode(4);

        m1.next = m2;
        m2.next = m3;
        m3.next = m4;

        System.out.println("Test Case 2 (List without cycle): " +
                solution.hasCycle(m1));  // Should print false
    }
}