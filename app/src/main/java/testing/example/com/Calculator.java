package testing.example.com;

public class Calculator {
    public double sum(double a, double b) {
        return a + b;
    }

    public double substract(double a, double b) {
        return a - b;
    }

    public double divide(double a, double b) {
        if (b == 0)
            throw new IllegalArgumentException("被除数不能为0");
        return a / b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public static void main(String[] args) {
        Calculator mCalculator = new Calculator();
        System.out.println(mCalculator.divide(10, 0));
    }

}
