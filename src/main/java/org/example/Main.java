package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            Calculator calculator = new Calculator();
            System.out.println("Калькулятор");
            System.out.print("Оберіть операцію (+, -, *, /, sqrt): ");
            String operation = scanner.nextLine().trim();

            if (operation.equalsIgnoreCase("sqrt")) {
                System.out.print("Введіть число: ");
                // Якщо користувач введе рядок (наприклад, "abc"), викличеться InputMismatchException
                double num = scanner.nextDouble();

                // Якщо num < 0, метод sqrt() викине ваше власне виключення InvalidInputException
                double result = calculator.sqrt(num);
                System.out.println("Результат: " + result);

            } else {
                System.out.print("Введіть перше число: ");
                double num1 = scanner.nextDouble();

                System.out.print("Введіть друге число: ");
                double num2 = scanner.nextDouble();

                double result = switch (operation) {
                    case "+" -> calculator.add(num1, num2);
                    case "-" -> calculator.subtract(num1, num2);
                    case "*" -> calculator.multiply(num1, num2);
                    case "/" ->
                        // Якщо num2 == 0, метод divide() викине ArithmeticException
                            calculator.divide(num1, num2);
                    default ->
                        // Якщо введено неіснуючу операцію — викликаємо власне виключення
                            throw new InvalidInputException("Помилка: Введено непідтримувану операцію '" + operation + "'!");
                };
                System.out.println("Результат: " + result);
            }
        } catch (InputMismatchException e) {
            System.out.println("Помилка некоректного вводу: Введено рядок замість числа.");

            // Ділення на нуль (ArithmeticException)
        } catch (ArithmeticException | InvalidInputException e) {
            System.out.println(e.getMessage());

        } catch (Exception e) {
            System.out.println("Критична помилка: " + e.getMessage());

        } finally {
            System.out.println("----------------------------------------");
            System.out.println("Обробку запиту завершено.");
        }
    }
}