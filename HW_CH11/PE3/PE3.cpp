#include <iostream>

// Stack abstract data type using linked list
template <typename T>
struct Node {
    T data;
    Node* next;
    Node(T val) : data(val), next(nullptr) {}
};

template <typename T>
class Stack {
private:
    Node<T>* topNode; // Pointer to the top node
public:
    Stack() : topNode(nullptr) {}

    // Push an element onto the stack
    void push(T val) {
        Node<T>* newNode = new Node<T>(val);
        newNode->next = topNode;
        topNode = newNode;
    }

    // Pop an element from the stack
    T pop() {
        if (isEmpty()) {
            throw std::runtime_error("Stack underflow");
        }
        Node<T>* temp = topNode;
        T poppedValue = topNode->data;
        topNode = topNode->next;
        delete temp;
        return poppedValue;
    }

    // Peek at the top element of the stack
    T peek() const {
        if (isEmpty()) {
            throw std::runtime_error("Stack is empty");
        }
        return topNode->data;
    }

    // Check if the stack is empty
    bool isEmpty() const {
        return topNode == nullptr;
    }

    // Destructor to clean up memory
    ~Stack() {
        while (!isEmpty()) {
            pop();
        }
    }
};

// testing
int main() {
    Stack<int> stack;
    stack.push(10);
    stack.push(20);
    stack.push(30);

    std::cout << "Top element is: " << stack.peek() << std::endl; // 30

    std::cout << "Popped element is: " << stack.pop() << std::endl; // 30
    std::cout << "Top element is: " << stack.peek() << std::endl; // 20

    return 0;
}