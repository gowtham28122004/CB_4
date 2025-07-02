import java.util.*;

public class DoublyLinkedList {
    private Node head = null;
    private Node tail = null;

    class Node {
        int data;
        Node pre, next;

        Node(int d) {
            data = d;
            pre = next = null;
        }
    }

    public void insertAtBegin(int d) {
        Node newNode = new Node(d);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.pre = newNode;
            head = newNode;
        }
    }

    public void insertAtEnd(int d) {
        Node newNode = new Node(d);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.pre = tail;
            tail = newNode;
        }
    }

    public void insertAtPosition(int pos, int d) {
        Node newNode = new Node(d);
        if (pos == 0) {
            insertAtBegin(d);
            return;
        }

        Node temp = head;
        int count = 0;

        while (temp != null && count < pos - 1) {
            temp = temp.next;
            count++;
        }

        if (temp == null || temp.next == null) {
            insertAtEnd(d);
            return;
        }

        newNode.next = temp.next;
        newNode.pre = temp;
        temp.next.pre = newNode;
        temp.next = newNode;
    }

    public void deleteAtBegin() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.pre = null;
        }
    }

    public void deleteAtEnd() {
        if (tail == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.pre;
            tail.next = null;
        }
    }

    public void deleteElement(int value) {
        Node temp = head;

        while (temp != null && temp.data != value) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Element not found.");
            return;
        }

        if (temp == head) {
            deleteAtBegin();
        } else if (temp == tail) {
            deleteAtEnd();
        } else {
            temp.pre.next = temp.next;
            temp.next.pre = temp.pre;
        }
    }

    public void deleteAtPosition(int pos) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (pos == 0) {
            deleteAtBegin();
            return;
        }

        Node temp = head;
        int count = 0;

        while (temp != null && count < pos) {
            temp = temp.next;
            count++;
        }

        if (temp == null) {
            System.out.println("Position out of range.");
            return;
        }

        if (temp == tail) {
            deleteAtEnd();
        } else {
            temp.pre.next = temp.next;
            temp.next.pre = temp.pre;
        }
    }

    // Display Methods
    public void printForward() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void printBackward() {
        Node temp = tail;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.pre;
        }
        System.out.println();
    }

    // Main Method for Testing
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.insertAtBegin(5);
        dll.insertAtBegin(7);
        dll.insertAtEnd(6);
        dll.insertAtPosition(1, 10);
        dll.insertAtPosition(0, 20);
        dll.insertAtPosition(10, 99);

        System.out.println("Forward traversal:");
        dll.printForward();

        System.out.println("Backward traversal:");
        dll.printBackward();

        // Testing Deletions
        dll.deleteAtBegin();
        System.out.println("After deleting at beginning:");
        dll.printForward();

        dll.deleteAtEnd();
        System.out.println("After deleting at end:");
        dll.printForward();

        dll.deleteElement(10);
        System.out.println("After deleting element 10:");
        dll.printForward();

        dll.deleteAtPosition(1);
        System.out.println("After deleting at position 1:");
        dll.printForward();
    }
}
