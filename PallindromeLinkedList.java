/**
 * Problem: Palindrome Linked List
 *
 * Description:
 * Given the head of a singly linked list, determine if the linked list is a palindrome.
 * A palindrome reads the same forward and backward.
 *
 * Example:
 * Input: head = [1,2,2,1]
 * Output: true
 *
 * Input: head = [1,2]
 * Output: false
 *
 * Approach:
 * 1. Find the middle of the linked list using slow and fast pointers
 * 2. Reverse the second half of the linked list
 * 3. Compare the first half with the reversed second half
 * 4. If all values match, it's a palindrome
 */
public class PallindromeLinkedList {

    // Definition for singly-linked list
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        // Test case 1: [1,2,2,1] - should return true
        ListNode test1 = createLinkedList(new int[]{1, 2, 2, 1});
        System.out.println("Test case 1 - [1,2,2,1]: " + (new Solution().isPalindrome(test1) ? "Palindrome" : "Not Palindrome"));

        // Test case 2: [1,2] - should return false
        ListNode test2 = createLinkedList(new int[]{1, 2});
        System.out.println("Test case 2 - [1,2]: " + (new Solution().isPalindrome(test2) ? "Palindrome" : "Not Palindrome"));

        // Test case 3: [1] - should return true
        ListNode test3 = createLinkedList(new int[]{1});
        System.out.println("Test case 3 - [1]: " + (new Solution().isPalindrome(test3) ? "Palindrome" : "Not Palindrome"));

        // Test case 4: [1,2,3,2,1] - should return true
        ListNode test4 = createLinkedList(new int[]{1, 2, 3, 2, 1});
        System.out.println("Test case 4 - [1,2,3,2,1]: " + (new Solution().isPalindrome(test4) ? "Palindrome" : "Not Palindrome"));
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

    // Solution class moved inside PallindromeLinkedList to use the same ListNode class
    static class Solution {
        /**
         * Helper method to reverse a linked list
         * @param head The head of the linked list to reverse
         * @return The new head of the reversed linked list
         */
        public ListNode reverseList(ListNode head) {
            ListNode curr = head;   // Current node we're processing
            ListNode prev = null;   // Previous node (starts as null)
            ListNode agla = null;   // Next node ("agla" means "next" in Hindi)

            while(curr != null) {
                // Store next node
                agla = curr.next;

                // Reverse the link
                curr.next = prev;

                // Move pointers one step forward
                prev = curr;
                curr = agla;
            }

            return prev;  // New head of the reversed list
        }

        /**
         * Determines if a linked list is a palindrome
         * @param head The head of the linked list
         * @return true if the linked list is a palindrome, false otherwise
         */
        public boolean isPalindrome(ListNode head) {
            // Edge case: empty list or single node is a palindrome
            if (head == null || head.next == null) {
                return true;
            }

            // Step 1: Find the middle of the linked list
            ListNode slow = head;  // Moves one step at a time
            ListNode fast = head;  // Moves two steps at a time

            // When fast reaches the end, slow will be at the middle
            while(fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }

            // Step 2: Reverse the second half of the linked list
            // 'slow' is at the middle node, so reverse everything after it
            ListNode secondHalfReversed = reverseList(slow.next);
            slow.next = secondHalfReversed;  // Connect to the reversed half

            // Step 3: Compare the first half with the reversed second half
            ListNode firstHalfPtr = head;
            ListNode secondHalfPtr = secondHalfReversed;

            while(secondHalfPtr != null) {
                // If values don't match, it's not a palindrome
                if(secondHalfPtr.val != firstHalfPtr.val) {
                    return false;
                }

                // Move both pointers forward
                secondHalfPtr = secondHalfPtr.next;
                firstHalfPtr = firstHalfPtr.next;
            }

            // If we made it through the comparison without returning false, it's a palindrome
            return true;
        }
    }
}