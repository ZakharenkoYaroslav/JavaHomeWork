package com.pb.zakharenko.hw4;
import java.util.Scanner;

public class CapitalLetter {
    static String toUppercase (String a) {
        String b=a.substring(1,a.length());
        String d=a.toUpperCase();
        String c=d.substring(0,1);
        a=c+b;
        return a;
    }

    public static void main(String[] args) {
        String operand1, operand2;
        Scanner scan = new Scanner(System.in);
        System.out.println("Введіть фразу з декількох слів");
        operand1 = scan.nextLine();
        String[] Parts = operand1.split(" ");
        String[] Parts2;
        int i=0;
        do {
        Parts[i]=toUppercase(Parts[i]);
        i++;
        }
        while (i < Parts.length);
        operand2="";
        int j=0;
        do {
            operand2=operand2+" "+Parts[j];
            j++;
        }
        while (j< Parts.length);

        System.out.println("Оригінальний текст:  " + operand1);
        System.out.println("Змінений текст: " + operand2);
    }

}
