package org.example;

//  Оголошення та успадкування
public class InvalidInputException extends Exception {

    //  Конструктор класу
    public InvalidInputException(String message) {
        //  Виклик конструктора батьківського класу
        super(message);
    }
}