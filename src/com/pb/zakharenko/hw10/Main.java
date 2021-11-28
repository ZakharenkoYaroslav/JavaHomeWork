package com.pb.zakharenko.hw10;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        NumBox <Float> num1 = new NumBox<>(10);
        NumBox <Double> num2 = new NumBox<>(20);

        for (int i=0;i < (num1.getSize());i++){

            Float num = random.nextFloat();
            try{
            num1.add(num);}
            catch (ArrayOutOfBoundExeption a){
                System.out.println("В масиві недостаньо місця для додавання елементу!");
                a.getMessage();
                a.printStackTrace();
                System.exit(0);
            }
            System.out.println(num+" зберігається в масиві з індексом "+i);
        }
        System.out.println();

        Float testNum = num1.get(6);
        System.out.println(testNum+" хранится в массив с индексом "+6);
        System.out.println("Довжина масиву:");
        System.out.println(num1.length());
        System.out.println();
        System.out.println("Середенє значення в масиві:");
        System.out.println(num1.average());
        System.out.println();
        System.out.println("Сума значень масиву:");
        System.out.println(num1.sum());
        System.out.println();
        System.out.println("Максимальне значення в масиві:");
        System.out.println(num1.max());
        System.out.println();


        // работа со вторым массивом

        for (int i=0;i < num2.getSize();i++){
            Double num = random.nextDouble();
            try {
            num2.add(num);}
            catch (ArrayOutOfBoundExeption a) {
                System.out.println("В масиві недостаньо місця для додавання елементу!");
                a.getMessage();
                a.printStackTrace();
                System.exit(0);
            }
            System.out.println(num+" записано в масив з індексом "+i);
        }
        System.out.println();

        Double testNum2 = num2.get(6);
        System.out.println(testNum2+" зберігається в масиві з індексом "+6);
        System.out.println();
        System.out.println("Довжина масиву:");
        System.out.println(num2.length());
        System.out.println();
        System.out.println("Середенє значення в масиві:");
        System.out.println(num2.average());
        System.out.println();
        System.out.println("Сума значень масиву:");
        System.out.println(num2.sum());
        System.out.println();
        System.out.println("Максимальне значення в масиві:");
        System.out.println(num2.max());
        System.out.println();



    }
}
