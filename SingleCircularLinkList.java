import java.util.*;

public class SingleCircularLinkList {
    Node head, tail;
    int count = 0;

    class Node {
        int data;
        Node next;

        public Node(int d) {
            data = d;
            next = null;
        }
    }

    public void insertAtBegin(int d) {
        Node ob = new Node(d);
        if (head == null) {
            head = tail = ob;
            tail.next = head;
        } else {
            ob.next = head;
            head = ob;
            tail.next = head;
        }
        count++;
    }

    public void insertAtEnd(int d) {
        Node ob = new Node(d);
        if (head == null) {
            head = tail = ob;
            tail.next = head;
        } else {
            tail.next = ob;
            tail = ob;
            tail.next = head;
        }
        count++;
    }

    public void insertAtPos(int d, int p) {
        if (p < 0 || p > count) {
            System.out.println("Invalid Position");
            return;
        }
        if (p == 0) {
            insertAtBegin(d);
            return;
        }
        if (p == count) {
            insertAtEnd(d);
            return;
        }

        Node c = head;
        for (int i = 0; i < p - 1; i++) {
            c = c.next;
        }
        Node ob = new Node(d);
        ob.next = c.next;
        c.next = ob;
        count++;
    }

    public void deleteAtBegin() {
        if (head == null) {
            System.out.println("List is Empty");
            return;
        }
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            tail.next = head;
        }
        count--;
    }

    public void deleteAtEnd() {
        if (head == null) {
            System.out.println("List is Empty");
            return;
        }
        if (head == tail) {
            head = tail = null;
        } else {
            Node c = head;
            while (c.next != tail) {
                c = c.next;
            }
            c.next = head;
            tail = c;
        }
        count--;
    }

    public void deleteAtPos(int p) {
        if (p < 0 || p >= count) {
            System.out.println("Invalid Position");
            return;
        }
        if (p == 0) {
            deleteAtBegin();
            return;
        }
        if (p == count - 1) {
            deleteAtEnd();
            return;
        }

        Node c = head;
        for (int i = 0; i < p - 1; i++) {
            c = c.next;
        }
        c.next = c.next.next;
        count--;
    }

    public void display() {
        if (head == null) {
            System.out.println("List is Empty");
            return;
        }
        Node temp = head;
        System.out.print("List: ");
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

    public static void main(String[] args) {
        SingleCircularLinkList list = new SingleCircularLinkList();

        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.insertAtPos(25, 2);
        list.display();

        list.deleteAtBegin();
        list.display();

        list.deleteAtEnd();
        list.display();

        list.deleteAtPos(1);
        list.display();
    }
}
