package com.pb.zakharenko.hw4;
import java.util.Scanner;

public class CapitalLetter {
    static String toUppercase (String a) {
        Char c=a.charAt(0);
        String b=a.substring(1,a.length());
        c.toUpperCase();
        a=c+b;
        return a;
    }

    public static void main(String[] args) {
        String operand1, operand2;
        Scanner scan = new Scanner(System.in);
        System.out.println("Введіть фразу з декількох слів");
        operand1 = scan.nextStr();
        String[] Parts = operand1.split("-");
        String[] Parts2;
        int i=0;
        do {
        Parts2=toUppercase(Parts[i]);
        i++;
        }
        while (i < Parts.length);
        int j=0;
        do {
            operand2=operand2+Parts2[j];
            j++;
        }
        while (j< Parts2.length);

        System.out.println("Оригінальний текст:  " + operand1);
        System.out.println("Змінений текст: " + operand2);
    }

}
