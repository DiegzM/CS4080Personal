package PE2;

public class PE2 {
    public static void main(String[] args) {
        double j = 0;
        double k = (j + 13) / 27;
        
        while (true) {
            if (k > 10) {
                break;
            }
            k += 1.2;
            double i = 3 * (int)k - 1;
        }
        System.out.println("Program executed successfully!");

    }
}