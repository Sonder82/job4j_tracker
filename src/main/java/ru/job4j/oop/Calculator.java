package ru.job4j.oop;

public class Calculator {

    private static int x =  5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public static int minus(int a) {
        return x - a;
    }

    public int divide(int a) {
        return x / a;
    }

    public int sumAllOperation(int a) {
        return sum(10) + multiply(5) + minus(4) + divide(5);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int rslMult = calculator.multiply(5);
        int rslSum = sum(10);
        int rslMinus = minus(4);
        int rslDivide = calculator.divide(5);
        int rslAll = calculator.sumAllOperation(10);
        System.out.println(rslMult);
        System.out.println(rslSum);
        System.out.println(rslMinus);
        System.out.println(rslDivide);
        System.out.println(rslAll);
    }
}
