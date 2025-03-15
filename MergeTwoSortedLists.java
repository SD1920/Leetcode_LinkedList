/**
 * Problem: Merge Two Sorted Lists
 *
 * Description:
 * You are given the heads of two sorted linked lists list1 and list2.
 * Merge the two lists into one sorted list. The list should be made by
 * splicing together the nodes of the first two lists.
 * Return the head of the merged linked list.
 *
 * Example:
 * Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 *
 * Input: list1 = [], list2 = []
 * Output: []
 *
 * Input: list1 = [], list2 = [0]
 * Output: [0]
 *
 * Approach:
 * 1. Create a dummy head node
 * 2. Iterate through both lists, always choosing the node with smaller value
 * 3. After one list is exhausted, append the remainder of the other list
 * 4. Return dummy.next as the head of the merged list
 */
public class MergeTwoSortedLists {

    // Definition for singly-linked list
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        // Test case 1: list1 = [1,2,4], list2 = [1,3,4] -> [1,1,2,3,4,4]
        ListNode list1 = createLinkedList(new int[]{1, 2, 4});
        ListNode list2 = createLinkedList(new int[]{1, 3, 4});

        System.out.println("Test Case 1:");
        System.out.print("List 1: ");
        printList(list1);
        System.out.print("List 2: ");
        printList(list2);

        ListNode merged1 = new Solution().mergeTwoLists(list1, list2);
        System.out.print("Merged: ");
        printList(merged1);

        // Test case 2: list1 = [], list2 = [] -> []
        ListNode list3 = createLinkedList(new int[]{});
        ListNode list4 = createLinkedList(new int[]{});

        System.out.println("\nTest Case 2:");
        System.out.print("List 1: ");
        printList(list3);
        System.out.print("List 2: ");
        printList(list4);

        ListNode merged2 = new Solution().mergeTwoLists(list3, list4);
        System.out.print("Merged: ");
        printList(merged2);

        // Test case 3: list1 = [], list2 = [0] -> [0]
        ListNode list5 = createLinkedList(new int[]{});
        ListNode list6 = createLinkedList(new int[]{0});

        System.out.println("\nTest Case 3:");
        System.out.print("List 1: ");
        printList(list5);
        System.out.print("List 2: ");
        printList(list6);

        ListNode merged3 = new Solution().mergeTwoLists(list5, list6);
        System.out.print("Merged: ");
        printList(merged3);
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
        if (head == null) {
            System.out.println("Empty list");
            return;
        }

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
         * Merges two sorted linked lists into one sorted linked list
         * @param list1 The head of the first sorted linked list
         * @param list2 The head of the second sorted linked list
         * @return The head of the merged sorted linked list
         */
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            // Create a dummy head node with arbitrary value (1000)
            // This simplifies the merging process by avoiding null checks
            ListNode head = new ListNode(1000);

            // Pointer for building the result list
            ListNode temp = head;

            // Pointers for traversing the input lists
            ListNode t1 = list1;
            ListNode t2 = list2;

            // Process both lists until at least one is exhausted
            while(t1 != null && t2 != null) {
                if(t1.val > t2.val) {
                    // If t2's value is smaller, add t2 to the result
                    temp.next = t2;
                    temp = t2;      // Move result pointer
                    t2 = t2.next;   // Move t2 pointer
                }
                else {
                    // If t1's value is smaller or equal, add t1 to the result
                    temp.next = t1;
                    temp = t1;      // Move result pointer
                    t1 = t1.next;   // Move t1 pointer
                }
            }

            // After one list is exhausted, append the remainder of the other list
            if(t1 == null) {
                temp.next = t2;  // Append remaining nodes from list2
            }
            else {
                temp.next = t1;  // Append remaining nodes from list1
            }

            // Return the merged list (skip the dummy head)
            return head.next;
        }
    }
}