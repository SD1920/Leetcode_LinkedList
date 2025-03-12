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

    // Function to get the size of the linked list
    public static int size(Node head) {
        Node temp = head;
        int size = 0;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        return size;
    }

    // Function to find the intersection point; return type changed to Node
    public static Node Intersection(Node head1, Node head2) {
        int size1 = size(head1);
        int size2 = size(head2);
        int diff = Math.abs(size1 - size2);

        Node temp1 = head1;
        Node temp2 = head2;

        // Move the pointer of the longer list ahead by the difference
        if (size1 > size2) {
            for (int i = 0; i < diff; i++) {
                temp1 = temp1.next;
            }
        } else {
            for (int i = 0; i < diff; i++) {
                temp2 = temp2.next;
            }
        }

        // Traverse both lists and check for intersection by comparing references
        while (temp1 != null && temp2 != null) {
            if (temp1 == temp2) {
                return temp1;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return null; // No intersection found
    }

    public static void main(String[] args) {
        // Creating first linked list
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

        // Creating second linked list
        Node z = new Node(90);
        Node y = new Node(93);
        Node x = new Node(5);

        z.next = y;
        y.next = x;

        x.next = d; // Intersection happens here

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
