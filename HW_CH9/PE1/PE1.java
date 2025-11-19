import java.util.Random;

public class PE1 {

    public static double calculatePassByReference(int iterations, int arraySize) {
        Random random = new Random();
        random.setSeed(System.nanoTime());
        double totalTime = 0.0;

        for (int iter = 0; iter < iterations; iter++) {
            int[] array = new int[arraySize];
            for (int i = 0; i < arraySize; i++) {
                array[i] = random.nextInt();
            } 
            double startTime = System.nanoTime();
            int[] array2 = array;
            double endTime = System.nanoTime();
            totalTime += (endTime - startTime) / 1_000_000.0; // Convert to milliseconds
        }
        return totalTime / iterations;  
    }

    public static double calcculatePassByValue(int iterations, int arraySize) {
        Random random = new Random();
        random.setSeed(System.nanoTime());
        double totalTime = 0.0;

        for (int iter = 0; iter < iterations; iter++) {
            int[] array = new int[arraySize];
            for (int i = 0; i < arraySize; i++) {
                array[i] = random.nextInt();
            } 
            double startTime = System.nanoTime();
            int[] array2 = array.clone();
            double endTime = System.nanoTime();
            totalTime += (endTime - startTime) / 1_000_000.0; // Convert to milliseconds
        }
        return totalTime / iterations;  
    }
    public static void main(String[] args) {
        int iterations = 1000;
        int arraySize = 10000;

        System.out.println("Calculating....");

        double avgTimeRef = calculatePassByReference(iterations, arraySize);
        double avgTimeVal = calcculatePassByValue(iterations, arraySize);

        System.out.printf("Average time for pass by reference: %.6f ms%n", avgTimeRef);
        System.out.printf("Average time for pass by value: %.6f ms%n", avgTimeVal);

        // Ratio (ref/val)
        System.out.printf("Ratio (ref/val): %.6f%n", avgTimeRef / avgTimeVal);
    }
}