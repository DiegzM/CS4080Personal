package PE4;

// Test the stackclass
public class PE4 {
    public static void main(String[] args) {
        StackClass stack = new StackClass();
        
        // Push elements onto the stack
        stack.push(10);
        stack.push(20);
        stack.push(30);

        // Pop an element from the stack
        stack.pop();
        // Get the top element
        System.out.println("Top element: " + stack.top()); // Should print 20
    }
}
