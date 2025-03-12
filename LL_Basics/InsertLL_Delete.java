public class InsertLL_Delete {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }


        @Override
        public String toString() {
            return Integer.toString(data);
        }
    }

    public static class linkedList {
        Node head = null;
        Node tail = null;
        int size;
        void InsertAtEnd(int data) {
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

        void InsertAtBeginning(int data) {
            Node temp = new Node(data);
            if(head == null) {
                head = tail = temp;
            } else {
                temp.next = head;
                head = temp;
            }
            size++;
        }

        void Insert(int position, int data) {
            if (position < 0 || position > size) {
                System.out.println("Invalid position. Valid positions: 0 to " + size);
                return;
            }

            if (position == 0) {
                InsertAtBeginning(data);
                return;
            } else if (position == size) {
                InsertAtEnd(data);
                return;
            }
            Node newNode = new Node(data);
            Node temp = head;
           for(int i = 0; i < position - 1; i++) {
               temp = temp.next;
           }
           newNode.next = temp.next;
           temp.next = newNode;
           size++;
        }

        void DeleteAt(int position) {
            if (position < 0 || position >= size) {
                System.out.println("Invalid position. Valid positions: 0 to " + (size - 1));
                return;
            }
            if(position == 0) {
                head = head.next;
                if(head == null) {
                    tail = null;
                }
                size--;
                return;
            }
            Node temp = head;
            for(int i = 1; i < position; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
            if (temp.next == null) {
                tail = temp;
            }
            size--;
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
        ll.InsertAtEnd(5);
        ll.InsertAtEnd(7);
        ll.InsertAtEnd(89);
        ll.Insert(0,142);
      //  ll.insertAtEnd(1485);
      //  ll.insertAtEnd(0);
        ll.Insert(0, 43);
         ll.Insert(1, 3);
        ll.Insert(2, 5);
        ll.Insert(3, 56);
        ll.Insert(3, 786);
        ll.Insert(8, 786);
        ll.Display();
        ll.DeleteAt(0);
        ll.Display();
        ll.DeleteAt(8);
        ll.Display();
        ll.DeleteAt(2);
        System.out.println(ll.tail);
        System.out.println(ll.head);
        ll.Display();
        System.out.println(ll.size);
    }
}