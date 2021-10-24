package com.pb.zakharenko.hw3;

import java.util.Scanner;

public class Array {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int operand1, sum, number;
        int[] array = new int[10];
        sum=0;
        number=-0;

        // Заполнение массива.
        for (int i = 0; i < array.length; i++) {
            System.out.println("Введіть ціле число");
            operand1 = scan.nextInt();
            array[i] = operand1;
        }

        // Вывод на экран значений элементов массива.
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

        // Расчёт суммы значений элементов массива.
        for (int i = 0; i < array.length; i++) {
            sum = sum + array[i];
        }
        System.out.println("Сумма элементов массива = " + sum);

        // Подсчёт количества положительных значений элементов массива.
        for (int i = 0; i < array.length; i++) {
            if (array[i]>0) {number = number + 1;}
        }
        System.out.println("Количество положительных элементов массива = " + number);

        //Сортировка массива.
        boolean swapped;
        swapped=false;
        int temp;

        for (int j = 1; j < array.length; j++) {
            do {
                for (int i = 1; i < array.length; i++) {
                    swapped = false;
                    if (array[i - 1] > array[i]) {
                        temp = array[i - 1];
                        array[i - 1] = array[i];
                        array[i] = temp;
                        swapped = true;
                    }

                }
            }
            while (swapped);

        }

        // Вывод на экран значений элементов массива.
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

    }
}
