package PE5;

// Write an abstract data type for complex numbers, including operations for addition, subtraction, 
// multiplication, division, extraction of each of the parts of a complex number, and construction 
// of a complex number from two floating-point constants, variables, or expressions

public class ComplexNumber {
    private double real;
    private double imaginary;

    // Constructor
    public ComplexNumber(String number) {
        String[] parts = number.split("\\+");
        this.real = Double.parseDouble(parts[0].trim());
        this.imaginary = Double.parseDouble(parts[1].replace("i", "").trim());
    }

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    // Addition
    public ComplexNumber add(ComplexNumber other) {
        return new ComplexNumber(this.real + other.real, this.imaginary + other.imaginary);
    }

    // Subtraction
    public ComplexNumber subtract(ComplexNumber other) {
        return new ComplexNumber(this.real - other.real, this.imaginary - other.imaginary);
    }

    // Multiplication
    public ComplexNumber multiply(ComplexNumber other) {
        double realPart = this.real * other.real - this.imaginary * other.imaginary;
        double imaginaryPart = this.real * other.imaginary + this.imaginary * other.real;
        return new ComplexNumber(realPart, imaginaryPart);
    }

    // Division
    public ComplexNumber divide(ComplexNumber other) {
        double denominator = other.real * other.real + other.imaginary * other.imaginary;
        double realPart = (this.real * other.real + this.imaginary * other.imaginary) / denominator;
        double imaginaryPart = (this.imaginary * other.real - this.real * other.imaginary) / denominator;
        return new ComplexNumber(realPart, imaginaryPart);
    }

    // Setters and Getters
    public double getReal() {
        return real;
    }
    public double getImaginary() {
        return imaginary;
    }
    public void setReal(double real) {
        this.real = real;
    }
    public void setImaginary(double imaginary) {
        this.imaginary = imaginary;
    }
}