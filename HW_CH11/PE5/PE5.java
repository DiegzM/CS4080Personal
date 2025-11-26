package PE5;

public class PE5 {
    public static void main(String[] args) {
        ComplexNumber num1 = new ComplexNumber(4.0, 5.0);
        ComplexNumber num2 = new ComplexNumber(2.0, 3.0);

        ComplexNumber sum = num1.add(num2);
        ComplexNumber difference = num1.subtract(num2);
        ComplexNumber product = num1.multiply(num2);
        ComplexNumber quotient = num1.divide(num2);

        System.out.println("Num1: " + num1.getReal() + " + " + num1.getImaginary() + "i");
        System.out.println("Num2: " + num2.getReal() + " + " + num2.getImaginary() + "i");
        System.out.println("Sum: " + sum.getReal() + " + " + sum.getImaginary() + "i");
        System.out.println("Difference: " + difference.getReal() + " + " + difference.getImaginary() + "i");
        System.out.println("Product: " + product.getReal() + " + " + product.getImaginary() + "i");
        System.out.println("Quotient: " + quotient.getReal() + " + " + quotient.getImaginary() + "i");
    }
}
