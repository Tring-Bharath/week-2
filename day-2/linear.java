// import java.util.*;
// class linear
// {
//     public static void main(String args[])
//     {
//         Stack a=new Stack<>();
//         System.out.println(a.isEmpty());
//         a.push(1);
//         a.push(2);
//         a.push(3);
//         a.push(4);
//         System.out.println(a);
//         System.out.println(a.peek());
//         System.out.println(a.pop());
//         System.out.println(a.peek());
//         System.out.println(a);
//         System.out.println(a.isEmpty());
//     }
// }
class Node {
    int data;
    Node next;
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}
class Stack {
    private Node top;
    public Stack() {
        this.top = null;
    }
    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top; 
        top = newNode; 
    }
    public boolean isEmpty() {
        return top == null;
    }
    public int pop() {
        if (isEmpty()) {
            return -1;
        }
        int poppedValue = top.data;
        top = top.next;
        return poppedValue;
    }
    public int peek() {
        if (isEmpty()) {
            return -1;
        }
        return top.data;
    }
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }
        Node temp = top;
        System.out.print("Stack: ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}
public class linear {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.display();
        System.out.println();
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        stack.display();
    }
}
