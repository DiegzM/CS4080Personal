package PE4;

public class StackClass {
    // Node class to represent each element in the stack
    private static class Node {
        int value;
        Node next;
        
        Node(int value, Node nextNode) {
            this.value = value;
            this.next = nextNode;
        }
    }
    private Node top;

    // Constructor to initialize an empty stack
    public StackClass() {
        this.top = null;
    }

    // Method to push an element onto the stack
    public void push(int value) {
        Node newNode = new Node(value, top);
        top = newNode;
    }

    // Method to pop an element from the stack
    public void pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        top = top.next;
    }

    // Get the top element of the stack without removing it
    public int top() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return top.value;
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return top == null;
    }

}