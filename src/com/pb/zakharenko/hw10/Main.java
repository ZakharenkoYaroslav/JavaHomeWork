package com.pb.zakharenko.hw10;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        NumBox <Float> num1 = new NumBox<>(10);
        NumBox <Double> num2 = new NumBox<>(20);

        for (int i=0;i < (num1.getNumbers().length);i++){

            Float num = random.nextFloat();
            try{
            num1.add(num);}
            catch (ArrayOutOfBoundExeption a){
                System.out.println("В масиві недостаньо місця для додавання елементу!");
                a.getMessage();
                a.printStackTrace();
                System.exit(0);
            }
            System.out.println(num+" записано в массив с индексом "+i);
        }

        Float testNum = num1.get(9);
            System.out.println(testNum+" хранится в массив с индексом "+9);
        System.out.println(num1.length());
        System.out.println(num1.average());
        System.out.println(num1.sum());
        System.out.println(num1.max());


        // работа со вторым массивом

        for (int i=0;i < num2.getNumbers().length;i++){
            Double num = random.nextDouble();
            try {
            num2.add(num);}
            catch (ArrayOutOfBoundExeption a) {
                System.out.println("В масиві недостаньо місця для додавання елементу!");
                a.getMessage();
                a.printStackTrace();
                System.exit(0);
            }
            System.out.println(num+" записано в массив с индексом "+i);
        }
        int x2 = random.nextInt();
        Double testNum2 = num2.get(x2);
        System.out.println(testNum2+" хранится в массив с индексом "+x2);
        System.out.println(num2.length());
        System.out.println(num2.average());
        System.out.println(num2.sum());
        System.out.println(num2.max());


    }
}
