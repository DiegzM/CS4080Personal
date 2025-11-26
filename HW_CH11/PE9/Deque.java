package PE9;

public class Deque {
    private Object[] data;
    private int front;
    private int rear;
    private int size;

    public Deque(int capacity) {
        data = new Object[capacity];
        front = 0;
        rear = 0;
        size = 0;
    }

    // Add an element to the front of the deque
    public void addFront(Object item) {
        if (size == data.length) {
            throw new IllegalStateException("Deque is full");
        }
        front = (front - 1 + data.length) % data.length;
        data[front] = item;
        size++;
    }

    // Add an element to the rear of the deque
    public void addRear(Object item) {
        if (size == data.length) {
            throw new IllegalStateException("Deque is full");
        }
        data[rear] = item;
        rear = (rear + 1) % data.length;
        size++;
    }

    // Remove an element from the front of the deque
    public Object removeFront() {
        if (isEmpty()) {
            throw new IllegalStateException("Deque is empty");
        }
        Object item = data[front];
        front = (front + 1) % data.length;
        size--;
        return item;
    }

    // Remove an element from the rear of the deque
    public Object removeRear() {
        if (isEmpty()) {
            throw new IllegalStateException("Deque is empty");
        }
        rear = (rear - 1 + data.length) % data.length;
        Object item = data[rear];
        size--;
        return item;
    }  

    // Check if the deque is empty
    public boolean isEmpty() {
        return size == 0;
    }
}

