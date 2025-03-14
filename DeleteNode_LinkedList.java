/**
 * LeetCode Problem: Delete Node in a Linked List
 *
 * Problem Description:
 * Write a function to delete a node in a singly-linked list.
 * You will not be given access to the head of the list,
 * instead you will be given access only to the node to be deleted.
 *
 * The given node will not be the tail and it is guaranteed to be a valid node in the linked list.
 *
 * Constraints:
 * - The node to be deleted is in the list and is not a tail node
 * - The number of nodes in the linked list is in the range [2, 1000]
 * - -1000 <= Node.val <= 1000
 */
public class DeleteNode_LinkedList {

    /**
     * Definition for singly-linked list.
     */
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * Solution class containing the method to delete a node
     */
    static class Solution {
        /**
         * Deletes a node from a singly linked list without access to the head.
         *
         * Approach:
         * Since we cannot access the previous node (which would be needed to
         * properly delete this node), we use a clever technique:
         * 1. Copy the value from the next node to the current node
         * 2. Skip the next node by updating the current node's next pointer
         *
         * This essentially makes the current node become the next node,
         * and removes the next node from the linked list.
         *
         * Time Complexity: O(1) - constant time operation
         * Space Complexity: O(1) - no extra space used
         *
         * @param node The node to be deleted (not the tail node)
         */
        public void deleteNode(ListNode node) {
            // Copy the value from the next node to the current node
            node.val = node.next.val;

            // Skip the next node by updating the current node's next pointer
            node.next = node.next.next;
        }
    }

    /**
     * Helper method to print the linked list
     */
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

    /**
     * Main method to demonstrate the solution
     */
    public static void main(String[] args) {
        // Create a sample linked list: 4 -> 5 -> 1 -> 9

        /**
         * Example 1:
         * Input: head = [4,5,1,9], node = 5
         * Output: [4,1,9]
         * Explanation: You are given the second node with value 5, the linked list should become 4 -> 1 -> 9 after calling your function.
         */

        /**
         * Example 2:
         * Input: head = [4,5,1,9], node = 1
         * Output: [4,5,9]
         * Explanation: You are given the third node with value 1, the linked list should become 4 -> 5 -> 9 after calling your function.
         */
        ListNode head = new ListNode(4);
        head.next = new ListNode(5);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(9);

        // Print the original list
        System.out.println("Original List:");
        printList(head);

        // Get the node to delete (node with value 5)
        ListNode nodeToDelete = head.next;

        // Delete the node
        Solution solution = new Solution();
        solution.deleteNode(nodeToDelete);

        // Print the modified list
        System.out.println("List after deleting node with value 5:");
        printList(head);
    }
}