import java.util.*;

class Queue {
    Node front, rear;
    int count;

    class Node {
        int data;
        Node next;

        public Node(int d) {
            data = d;
            next = null;
        }
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void enqueue(int d) {
        Node ob = new Node(d);
        if (isEmpty()) {
            front = rear = ob;
        } else {
            rear.next = ob;
            rear = ob;
        }
        count++;
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }
        int t = front.data;
        front = front.next;
        if (front == null) rear = null;
        count--;
        return t;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }
        return front.data;
    }

    public int size() {
        return count;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return;
        }
        Node t = front;
        while (t != null) {
            System.out.print(t.data + " -> ");
            t = t.next;
        }
        System.out.println("NULL");
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Queue q = new Queue();
        boolean loop = true;

        while (loop) {
            System.out.println("\n1.Enqueue\n2.Dequeue\n3.Peek\n4.Display\n5.Size\n6.Exit");
            System.out.print("Enter choice: ");
            int ch = s.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter value to enqueue: ");
                    q.enqueue(s.nextInt());
                    break;
                case 2:
                    System.out.println("Dequeued: " + q.dequeue());
                    break;
                case 3:
                    System.out.println("Front: " + q.peek());
                    break;
                case 4:
                    q.display();
                    break;
                case 5:
                    System.out.println("Queue size: " + q.size());
                    break;
                case 6:
                    loop = false;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }

        s.close();
    }
}
