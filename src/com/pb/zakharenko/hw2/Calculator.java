package com.pb.zakharenko.hw2;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int operand1, operand2;
        String sign;
        double result;
        System.out.println("Введіть перше ціле число");
        operand1 = scan.nextInt();
        System.out.println("Введіть друге ціле число");
        operand2 = scan.nextInt();
        System.out.println("Введіть знак операції. Може бути тільки +, -, *, /");
        sign = scan.next();

        switch (sign) {
            case "+":
                result = operand1+operand2;
                System.out.println("Результат ="+result);
                break;
            case "-":
                result = operand1-operand2;
                System.out.println("Результат ="+result);
                break;
            case "*":
                result = operand1*operand2;
                System.out.println("Результат ="+result);
                break;
            case "/":
                if (operand2==0) {
                System.out.println("На нуль ділити не можна!");
                break;
            }
                result = (double) operand1/operand2;
                System.out.println("Результат ="+result);
                break;
            default:
                System.out.println("Введено некоректний знак операції!");
        }

    }
}
