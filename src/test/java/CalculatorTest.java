import org.example.Calculator;
import org.example.InvalidInputException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        // Ініціалізація об'єкта перед кожним тестом
        calculator = new Calculator();
    }

    // -------------------------------------------------------------
    //  ТЕСТИ НА ВЛАСНЕ ВИКЛЮЧЕННЯ (InvalidInputException)
    // -------------------------------------------------------------

    @Test
    @DisplayName("sqrt з від'ємного числа має викидати InvalidInputException")
    void testSqrtNegativeNumberThrowsInvalidInputException() {

        InvalidInputException exception = assertThrows(
                InvalidInputException.class,
                () -> calculator.sqrt(-9.0)
        );


        assertEquals("Помилка: Число під квадратним коренем не може бути меншим за 0!", exception.getMessage());
    }

    @Test
    @DisplayName("sqrt з нуля або додатного числа має працювати коректно")
    void testSqrtValidInput() throws InvalidInputException {
        assertEquals(3.0, calculator.sqrt(9.0), 0.0001);
        assertEquals(0.0, calculator.sqrt(0.0), 0.0001);
    }

    // -------------------------------------------------------------
    //  ТЕСТИ НА ДІЛЕННЯ НА НУЛЬ (ArithmeticException)
    // -------------------------------------------------------------

    @Test
    @DisplayName("Ділення на нуль має викидати ArithmeticException")
    void testDivideByZeroThrowsArithmeticException() {
        ArithmeticException exception = assertThrows(
                ArithmeticException.class,
                () -> calculator.divide(10.0, 0.0)
        );

        assertEquals("Помилка: Ділення на нуль неможливе!", exception.getMessage());
    }

    @Test
    @DisplayName("Звичайне ділення має повертати правильний результат")
    void testDivideValidNumbers() {
        assertEquals(2.5, calculator.divide(5.0, 2.0), 0.0001);
    }

    // -------------------------------------------------------------
    // ТЕСТИ БАЗОВИХ АРИФМЕТИЧНИХ ОПЕРАЦІЙ
    // -------------------------------------------------------------

    @Test
    @DisplayName("Перевірка додавання, віднімання та множення")
    void testBasicOperations() {
        assertEquals(5.0, calculator.add(2.0, 3.0), 0.0001);
        assertEquals(1.0, calculator.subtract(3.0, 2.0), 0.0001);
        assertEquals(6.0, calculator.multiply(2.0, 3.0), 0.0001);
    }
}