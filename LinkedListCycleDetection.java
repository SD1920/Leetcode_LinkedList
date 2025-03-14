/**
 * Problem: Linked List Cycle II (LeetCode 142)
 *
 * Given the head of a linked list, return the node where the cycle begins.
 * If there is no cycle, return null.
 *
 * To solve this, we use Floyd's Tortoise and Hare algorithm (slow and fast pointers)
 * to detect if a cycle exists and then find the starting point of the cycle.
 */

/**
 * Definition for singly-linked list.
 */

/**
 * Input: head = [3,2,0,-4], pos = 1
 * Output: tail connects to node index 1
 * Explanation: There is a cycle in the linked list, where tail connects to the second node.
 */

/**
 * Input: head = [1,2], pos = 0
 * Output: tail connects to node index 0
 * Explanation: There is a cycle in the linked list, where tail connects to the first node.
 */

/**
 * Input: head = [1], pos = -1
 * Output: no cycle
 * Explanation: There is no cycle in the linked list.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class LinkedListCycleDetection {
    public ListNode detectCycle(ListNode head) {
        // Edge cases: empty list or single node (can't have a cycle)
        if (head == null || head.next == null) {
            return null;
        }

        // Initialize slow and fast pointers (tortoise and hare)
        ListNode slow = head;
        ListNode fast = head;

        // First phase: detect if there's a cycle
        // The fast pointer moves twice as fast as the slow pointer
        // If they meet, there is a cycle
        while (fast != null && fast.next != null) {
            slow = slow.next;          // Move slow pointer by 1 step
            fast = fast.next.next;     // Move fast pointer by 2 steps

            if (slow == fast) {
                // Cycle detected! Break out of the loop
                break;
            }
        }

        // If fast pointer reached end of list, there's no cycle
        if (fast == null || fast.next == null) {
            return null;
        }

        // Second phase: find the start of the cycle
        // Mathematical proof shows that if we reset one pointer to head
        // and keep the other at the meeting point, then move both at the
        // same pace, they will meet at the start of the cycle
        ListNode temp = head;
        while (temp != slow) {
            temp = temp.next;
            slow = slow.next;
        }

        // When they meet again, that's the start of the cycle
        return slow;
    }

    // Main method to test the solution
    public static void main(String[] args) {
        // Create a sample linked list with a cycle: 3 -> 2 -> 0 -> -4 -> (points back to 2)
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;  // Creates cycle pointing back to node2

        LinkedListCycleDetection solution = new LinkedListCycleDetection();
        ListNode result = solution.detectCycle(node1);

        if (result != null) {
            System.out.println("Cycle starts at node with value: " + result.val);
        } else {
            System.out.println("No cycle found");
        }
    }
}