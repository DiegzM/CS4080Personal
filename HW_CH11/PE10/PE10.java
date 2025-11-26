package PE10;
public class PE10 {
    public static void main(String[] args) {
        RationalNumber r1 = new RationalNumber(1, 2); // 1/2
        RationalNumber r2 = new RationalNumber(3, 4); // 3/4

        RationalNumber sum = r1.add(r2);
        System.out.println("Sum: " + sum); // Should print 5/4

        RationalNumber difference = r1.subtract(r2);
        System.out.println("Difference: " + difference); // Should print -1/4

        RationalNumber product = r1.multiply(r2);
        System.out.println("Product: " + product); // Should print 3/8

        RationalNumber quotient = r1.divide(r2);
        System.out.println("Quotient: " + quotient); // Should print 2/3

        RationalNumber r3 = new RationalNumber(2, 4); // 2/4 which simplifies to 1/2
        System.out.println("r1 equals r3: " + r1.equals(r3)); // Should print true
    }
}
