import java.util.*;

public class Basics_LL {
    public static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node a = new Node(5);
        Node b = new Node(15);
        Node c = new Node(54);
        Node d = new Node(56);
        Node e = new Node(53456);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = null;

//        System.out.println(a);
//        System.out.println(a.next);
//        System.out.println(b);
//
//        System.out.println(b.data);
        Node temp = a;
        while(temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;

        }
    }
}