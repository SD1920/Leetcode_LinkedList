/**
 * Problem Statement: Find the middle node of a linked list.
 * If there are two middle nodes (even length list), return the second one.
 */

public class FindingMiddleOfList {
    // ListNode definition as provided in the problem
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // Solution using fast and slow pointers
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    // Simple main method to test the solution
    public static void main(String[] args) {
        FindingMiddleOfList solution = new FindingMiddleOfList();

        // Create test list: 1->2->3->4->5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // Find middle node
        ListNode middle = solution.middleNode(head);
        System.out.println("Middle node value: " + middle.val);

        // Create test list with even length: 1->2->3->4->5->6
        head.next.next.next.next.next = new ListNode(6);

        // Find middle node for even length list
        middle = solution.middleNode(head);
        System.out.println("Middle node value (even length): " + middle.val);
    }
}