package org.example;

public class Calculator {

    // Додавання
    public double add(double a, double b) {
        return a + b;
    }

    // Віднімання
    public double subtract(double a, double b) {
        return a - b;
    }

    // Множення
    public double multiply(double a, double b) {
        return a * b;
    }

    // Ділення з перевіркою на 0
    public double divide(double a, double b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Помилка: Ділення на нуль неможливе!");
        }
        return a / b;
    }

    // Метод квадратного кореня
    public double sqrt(double a) throws InvalidInputException {
        if (a < 0) {
            throw new InvalidInputException("Помилка: Число під квадратним коренем не може бути меншим за 0!");
        }
        return Math.sqrt(a);
    }
}
