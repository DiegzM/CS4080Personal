package PE6;

public class TenCharacterQueue {
    private static class Node {
        String name;
        Node next;
        Node(String name) {
            if (name.length() > 10) {
                throw new IllegalArgumentException("Name exceeds 10 characters");
            }
            this.name = name;
            this.next = null;
        }
    }
    private Node front;
    private Node rear;

    // Constructor
    public TenCharacterQueue() {
        this.front = null;
        this.rear = null;
    }

    // Enqueue method
    public void enqueue(String name) {
        Node newNode = new Node(name);
        if (empty()) {
            front = rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
    }

    // Dequeue method
    public String dequeue() {
        if (empty()) {
            throw new IllegalStateException("Queue is empty");
        }
        String name = front.name;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return name;
    }

    // Check if the queue is empty
    public boolean empty() {
        return front == null;
    }
}   