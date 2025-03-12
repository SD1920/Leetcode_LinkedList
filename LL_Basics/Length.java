import java.util.*;

public class Length {
  //l  static int count = 0;

    public static int FindLength(Node head) {
       int count = 0;
       while (head != null) {
           count++;
           head = head.next;
       }
       return count;
    }

    public static int FindLengthR(Node head) {
        if(head == null) return 0;
        else return 1 + FindLengthR(head.next);
    }


    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        Node a = new Node(5);
        Node b = new Node(15);
        Node c = new Node(54);
        Node d = new Node(56);
        Node e = new Node(53456);
        Node f = new Node(564);
        Node g = new Node(444);
        Node h = new Node(56);
        Node i = new Node(563222);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;
        g.next = h;
        h.next = i;

        i.next = null;
        System.out.println((FindLength(a)));
        System.out.println(FindLengthR(a));

    }
}