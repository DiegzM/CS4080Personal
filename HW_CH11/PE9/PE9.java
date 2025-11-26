package PE9;

public class PE9 {
    public static void main(String[] args) {
        Deque deque = new Deque(5);

        deque.addRear("A");
        deque.addRear("B");
        deque.addFront("C");
        System.out.println(deque.removeFront()); // Should print C
        System.out.println(deque.removeRear());  // Should print B

        deque.addFront("D");
        System.out.println(deque.removeFront()); // Should print D

        while (!deque.isEmpty()) {
            System.out.println(deque.removeFront()); // Should print A
        }
    }
}
