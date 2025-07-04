import java.util.*;

public class Stack {
    Node top = null;
    int count = 0;

    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return -1;
        }
        return top.data;
    }

    public void push(int d) {
        Node ob = new Node(d);
        ob.next = top;
        top = ob;
        count++;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return -1;
        }
        int t = top.data;
        top = top.next;
        count--;
        return t;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return;
        }
        Node temp = top;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public int size() {
        return count;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Stack st = new Stack();
        boolean loop = true;

        while (loop) {
            System.out.println("\n1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Is Empty");
            System.out.println("5. Display");
            System.out.println("6. Size");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int n = s.nextInt();
            switch (n) {
                case 1:
                    System.out.print("Enter value to push: ");
                    st.push(s.nextInt());
                    break;
                case 2:
                    System.out.println("Popped: " + st.pop());
                    break;
                case 3:
                    System.out.println("Top: " + st.peek());
                    break;
                case 4:
                    System.out.println(st.isEmpty() ? "Yes, empty" : "No, not empty");
                    break;
                case 5:
                    st.display();
                    break;
                case 6:
                    System.out.println("Current size: " + st.size());
                    break;
                case 7:
                    loop = false;
                    break;
                default:
                    System.out.println("Invalid Option");
            }
        }
        s.close();
    }
}
