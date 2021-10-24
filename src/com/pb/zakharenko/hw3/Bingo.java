package com.pb.zakharenko.hw3;
import java.util.Random;
import java.util.Scanner;

public class Bingo {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scan = new Scanner(System.in);
        int operand1,i;
        int x = random.nextInt(101);
        i=0;
        operand1=1;
        while (operand1 !=x)  {


            System.out.println("Введіть ціле число");
            operand1 = scan.nextInt();
            i++;
            if (operand1 == 999) {
                break;
            }
            if (operand1 > x) {
                System.out.println("Загадане число менше!");
            }
            if (operand1 < x) {
                System.out.println("Загадане число більше!");
            }
            if (operand1 == x) {
                System.out.println("Ви відгадали загадане число!");
                System.out.println("Кількість використаних спроб - "+i);
            }

        }
    }
}
