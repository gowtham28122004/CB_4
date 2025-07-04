import java.util.*;

public class DoublyCircularLinkList {
    Node head, tail;
    int count = 0;

    class Node {
        int data;
        Node next;
        Node pre;

        public Node(int d) {
            data = d;
            next = pre = null;
        }
    }

    public void insertAtBegin(int d) {
        Node ob = new Node(d);
        if (head == null) {
            head = tail = ob;
            head.next = head;
            head.pre = head;
        } else {
            ob.next = head;
            ob.pre = tail;
            tail.next = ob;
            head.pre = ob;
            head = ob;
        }
        count++;
    }

    public void insertAtEnd(int d) {
        Node ob = new Node(d);
        if (head == null) {
            head = tail = ob;
            head.next = head;
            head.pre = head;
        } else {
            ob.pre = tail;
            ob.next = head;
            tail.next = ob;
            head.pre = ob;
            tail = ob;
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

        Node curr = head;
        for (int i = 0; i < p; i++) {
            curr = curr.next;
        }

        Node ob = new Node(d);
        ob.next = curr;
        ob.pre = curr.pre;
        curr.pre.next = ob;
        curr.pre = ob;
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
            head.pre = tail;
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
            tail = tail.pre;
            tail.next = head;
            head.pre = tail;
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

        Node curr = head;
        for (int i = 0; i < p; i++) {
            curr = curr.next;
        }
        curr.pre.next = curr.next;
        curr.next.pre = curr.pre;
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
        DoublyCircularLinkList list = new DoublyCircularLinkList();

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
