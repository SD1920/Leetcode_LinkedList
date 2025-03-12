import java.util.*;

public class Nth_NodeFromLast {
//    public static Node nthNode(Node head, int n) {
//        int size = 0;
//        Node temp = head;
//        while (temp != null) {
//            size++;
//            temp = temp.next;
//        }
//        if (n > size || n <= 0) return null;
//        temp = head;
//        for (int i = 0; i < size - n; i++) {
//            temp = temp.next;
//        }
//        return temp;
//    }

    public static Node nthNode_Optimized(Node head, int n) {
        Node fast = head, slow = head;
        for (int i = 0; i < n; i++) {
            if (fast == null) return null;
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public static Node removeNthNode_Optimized(Node head, int n) {
        Node dummy = new Node(0);
        dummy.next = head;
        Node fast = dummy;
        Node slow = dummy;

        for (int i = 0; i <= n; i++) {
            if (fast == null) return head;
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    public static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static class LinkedList {
        Node head;
        void display() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " -> ");
                temp = temp.next;
            }
            System.out.println("null");
        }
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();

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
        ll.head = a;

     /*   Node q = nthNode(a, 1);
        if (q != null) System.out.println(q.data);

        Node r = nthNode(a, 2);
        if (r != null) System.out.println(r.data);

        Node s = nthNode(a, 3);
        if (s != null) System.out.println(s.data);*/
/*
        Node p = nthNode_Optimized(a, 5);
        if (p != null) System.out.println(p.data);

        Node z = nthNode_Optimized(a, 4);
        if (z != null) System.out.println(z.data);

        Node y = nthNode_Optimized(a, 7);
        if (y != null) System.out.println(y.data);

        ll.display();*/

     /*   ll.head = removeNthNode_Optimized(ll.head, 6);
        ll.display();

        ll.head = removeNthNode_Optimized(ll.head, 1);
        ll.display();*/
ll.display();
        ll.head = removeNthNode_Optimized(ll.head, 7);
        ll.display();

        ll.head = removeNthNode_Optimized(ll.head, 1);
        ll.display();

    }
}
