public class Implementation {
    public static class Node {
        int data;
        Node next;
       // int size;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

  public static class linkedList {
        Node head = null;
        Node tail = null;
        int size;
        void insertAtEnd(int data) {
            Node temp = new Node(data);
            if (head == null) {
                head = temp;
              //  tail = temp;
            } else {
                tail.next = temp;
              //  tail = temp;
            }
            tail = temp;
            size++;
        }

        void insertAtBeginning(int data) {
            Node temp = new Node(data);
            if(head == null) {
                head = tail = temp;
            }
            else {
                temp.next = head;
               head = temp;
            }
                size++;
        }
       void Display() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + "->");
                temp = temp.next;
            }
           System.out.println("null");
       }
  }
    public static void main(String[] args) {
        linkedList ll = new linkedList();
        ll.insertAtEnd(5);
        ll.insertAtEnd(7);
        ll.insertAtEnd(89);
        ll.insertAtEnd(142);
        ll.insertAtEnd(1485);
        ll.insertAtEnd(0);
        ll.insertAtBeginning(-89500);
        ll.insertAtBeginning(-45201);
        ll.insertAtBeginning(-500);
        ll.insertAtBeginning(85520);
        ll.insertAtBeginning(33339500);

        ll.Display();
        System.out.println(ll.size);

    }


}
