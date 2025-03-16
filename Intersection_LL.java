/**
 * Problem Statement:
 * -----------------
 * Given two singly linked lists that may or may not intersect, find the node at which they intersect.
 * An intersection occurs when both linked lists share the same node (by reference, not just value).
 * If the lists do not intersect, return null.
 *
 * Example:
 * List 1: 100 -> 13 -> 5 -> 189 -> 8500 -> 560 -> 369
 *                         ↑
 * List 2:      90 -> 93 -> 5
 *
 * In this example, the intersection point is at node with value 189.
 */

import java.util.*;

public class Intersection_LL {
    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     * Utility function to calculate the length of a linked list.
     *
     * @param head The head node of the linked list
     * @return The number of nodes in the linked list
     */
    public static int size(Node head) {
        Node temp = head;
        int size = 0;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        return size;
    }

    /**
     * Solution Approach:
     * 1. Find the lengths of both linked lists
     * 2. Calculate the difference in lengths
     * 3. Move the pointer of the longer list ahead by the difference
     * 4. Traverse both lists in parallel until finding the intersection
     *
     * Time Complexity: O(m + n) where m and n are the lengths of the two lists
     * Space Complexity: O(1) as we only use a constant amount of extra space
     *
     * @param head1 The head of the first linked list
     * @param head2 The head of the second linked list
     * @return The node where the two lists intersect, or null if there's no intersection
     */
    public static Node Intersection(Node head1, Node head2) {
        // Calculate sizes of both lists
        int size1 = size(head1);
        int size2 = size(head2);
        int diff = Math.abs(size1 - size2);

        Node temp1 = head1;
        Node temp2 = head2;

        // Adjust starting points to account for the difference in list lengths
        // This ensures we start comparing nodes that could potentially be the same
        if (size1 > size2) {
            // If first list is longer, advance its pointer
            for (int i = 0; i < diff; i++) {
                temp1 = temp1.next;
            }
        } else {
            // If second list is longer, advance its pointer
            for (int i = 0; i < diff; i++) {
                temp2 = temp2.next;
            }
        }

        // Now both pointers are equidistant from the end
        // Traverse both lists and check for intersection by comparing node references
        while (temp1 != null && temp2 != null) {
            // If the references are the same, we found the intersection
            if (temp1 == temp2) {
                return temp1;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        // If we reach here, no intersection was found
        return null;
    }

    public static void main(String[] args) {
        // Creating first linked list: 100 -> 13 -> 5 -> 189 -> 8500 -> 560 -> 369
        Node a = new Node(100);
        Node b = new Node(13);
        Node c = new Node(5);
        Node d = new Node(189);
        Node e = new Node(8500);
        Node f = new Node(560);
        Node g = new Node(369);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;

        // Creating second linked list: 90 -> 93 -> 5
        Node z = new Node(90);
        Node y = new Node(93);
        Node x = new Node(5);

        z.next = y;
        y.next = x;

        // Creating the intersection (x.next points to node d from the first list)
        x.next = d; // This makes the lists intersect at node with value 189

        // Finding intersection
        Node intersectionNode = Intersection(a, z);

        // Printing result
        if (intersectionNode != null) {
            System.out.println("Intersection at node with value: " + intersectionNode.data);
        } else {
            System.out.println("No intersection found");
        }
    }
}