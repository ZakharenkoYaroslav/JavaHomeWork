package com.pb.zakharenko.hw4;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

import static java.util.Arrays.*;

public class Anagram {
    public static String[] deleteComma (String str) {
        String[] result1;
        str=str.toLowerCase();
        String[] line=str.split(" ");
        for (int i=0;i<line.length;i++){
            int pos = line[i].indexOf(",");
            if (pos != -1)
            {  //вычленяем запятую из подстроки
                String attributeName= line[i].substring(0,pos);
                //вычленяем значение атрибута
                String value = line[i].substring(pos+1,line[i].length());
                result1[i] = attributeName+value;
            }
        }
        return result1;
    }

    public static void main(String[] args) {
        String string1, string2;
        Scanner scan = new Scanner(System.in);
        System.out.println("Введіть перше речення");
        string1 = scan.nextLine();
        System.out.println("Введіть друге речення");
        string2 = scan.nextLine();


        String[] lines1=deleteComma(string1);
        String[] lines2=deleteComma(string2);

        sort(lines1);
        sort(lines2);
        if(Arrays.equals(lines1, lines2))
            System.out.println(string1 + " є анаграмою речення "+string2);
        else
            System.out.println("Речення не є анаграмою");



    }
}
