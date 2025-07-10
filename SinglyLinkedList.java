import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class SinglyLinkedList {
    Node head = null;

    public void insertAtEnd(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public void insertAtBeginning(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
    }

    public void insertAtPosition(int value, int position) {
        Node newNode = new Node(value);
        if (position < 0) {
            System.out.println("Invalid position");
            return;
        }
        if (position == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }
        Node temp = head;
        for (int i = 0; i < position - 1; i++) {
            if (temp == null) {
                System.out.println("Position out of bounds");
                return;
            }
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Position out of bounds");
            return;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void delete(int value) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.data == value) {
            head = head.next;
            return;
        }
        Node current = head;
        while (current.next != null && current.next.data != value) {
            current = current.next;
        }
        if (current.next == null) {
            System.out.println("Value not found");
        } else {
            current.next = current.next.next;
        }
    }

    public void deleteAtPosition(int position) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (position < 0) {
            System.out.println("Invalid position");
            return;
        }
        if (position == 0) {
            head = head.next;
            return;
        }
        Node temp = head;
        for (int i = 0; i < position - 1; i++) {
            if (temp == null || temp.next == null) {
                System.out.println("Position out of bounds");
                return;
            }
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("Position out of bounds");
            return;
        }
        temp.next = temp.next.next;
    }

    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public Node reverse(Node head) {
        Node curr = head;
        Node temp;
        Node pre = null;
        while (curr != null) {
            temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        return pre;
    }

    public Node reverse() {
        return reverse(head);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        SinglyLinkedList list = new SinglyLinkedList();

        while (true) {
            System.out.println("\n---- Singly Linked List Operations ----");
            System.out.println("1. Insert at beginning");
            System.out.println("2. Insert at end");
            System.out.println("3. Insert at position (0-based)");
            System.out.println("4. Delete by value");
            System.out.println("5. Delete at position (0-based)");
            System.out.println("6. Display");
            System.out.println("7. Reverse list");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            int choice = s.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to insert at beginning: ");
                    int valBeg = s.nextInt();
                    list.insertAtBeginning(valBeg);
                    break;
                case 2:
                    System.out.print("Enter value to insert at end: ");
                    int valEnd = s.nextInt();
                    list.insertAtEnd(valEnd);
                    break;
                case 3:
                    System.out.print("Enter value to insert: ");
                    int valPos = s.nextInt();
                    System.out.print("Enter 0-based position to insert at: ");
                    int pos = s.nextInt();
                    list.insertAtPosition(valPos, pos);
                    break;
                case 4:
                    System.out.print("Enter value to delete: ");
                    int delVal = s.nextInt();
                    list.delete(delVal);
                    break;
                case 5:
                    System.out.print("Enter 0-based position to delete from: ");
                    int delPos = s.nextInt();
                    list.deleteAtPosition(delPos);
                    break;
                case 6:
                    list.display();
                    break;
                case 7:
                    list.head = list.reverse();
                    System.out.println("List reversed.");
                    break;
                case 8:
                    System.out.println("Exiting program.");
                    s.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
