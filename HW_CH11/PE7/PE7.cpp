#include <iostream>
#include <stdexcept>

template <class ElemType>

// Write an abstract data type for a queue whose elements can be any primitive type

class Queue {
public:
    Queue(int maxSize) {
        this->maxSize = maxSize;
        front = 0;
        rear = -1;
        size = 0;
        data = new ElemType[maxSize];
    }

    ~Queue() {
        delete[] data;
    }

    void enqueue(ElemType value) {
        if (isFull()) {
            throw std::runtime_error("Queue overflow");
        }
        rear = (rear + 1) % maxSize;
        data[rear] = value;
        size++;
    }

    ElemType dequeue() {
        if (isEmpty()) {
            throw std::runtime_error("Queue underflow");
        }
        ElemType value = data[front];
        front = (front + 1) % maxSize;
        size--;
        return value;
    }
    
    ElemType peek() const {
        if (isEmpty()) {
            throw std::runtime_error("Queue is empty");
        }
        return data[front];
    }

    bool isEmpty() const {
        return size == 0;
    }

    bool isFull() const {
        return size == maxSize;
    }

private:
    int maxSize;
    int front;
    int rear;
    int size;
    ElemType* data;
};

int main() {
    Queue<int> q(5);
    q.enqueue(10);
    q.enqueue(20);
    std::cout << "Front element: " << q.peek() << std::endl; // Output: 10
    std::cout << "Dequeued: " << q.dequeue() << std::endl;   // Output: 10
    std::cout << "Front element: " << q.peek() << std::endl; // Output: 20
    return 0;
}