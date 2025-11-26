package PE6;

public class PE6 {
    public static void main(String[] args) {
        TenCharacterQueue queue = new TenCharacterQueue();

        // Enqueue names
        queue.enqueue("Alice");
        queue.enqueue("Bob");
        queue.enqueue("Catherine");

        // Dequeue names and print them
        System.out.println("Dequeued: " + queue.dequeue()); // Should print Alice
        System.out.println("Dequeued: " + queue.dequeue()); // Should print Bob

        // Enqueue another name
        queue.enqueue("David");

        // Dequeue remaining names and print them
        System.out.println("Dequeued: " + queue.dequeue()); // Should print Catherine
        System.out.println("Dequeued: " + queue.dequeue()); // Should print David

        // test long name
        try {
            queue.enqueue("Alexanderson");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); // Should print name exceeds 10 characters
        }
    }
}
