public class Doubly {
    public static class Node {
        int val;
        Node next;
        Node prev;
        Node(int val) {
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }

    public static void Display(Node head) {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
        System.out.print("null");

    }
    public static Node insertAtIdx(Node head, int key) {
        Node t = new Node(50);
        Node temp = head;
        while(temp.next.val != key) {
            temp.next.prev = t;
            t.prev = temp;
            t.next = temp.next;
            temp.next = t;
        }
        return head;
    }

    public static void main(String[] args) {
        // 4 -> 10 -> 2 -> 99 -> 13
        Node a = new Node(4);
        Node b = new Node(10);
        Node c = new Node(2);
        Node d = new Node(99);
        Node e = new Node(13);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = null;
        b.prev = a;
        c.prev = b;
        d.prev = c;
        e.prev = d;
        a.prev = null;
Display(a);
insertAtIdx(a, 10);
        System.out.println();
Display(a);
    }
}