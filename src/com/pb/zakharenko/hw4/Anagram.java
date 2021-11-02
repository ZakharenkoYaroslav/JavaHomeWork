package com.pb.zakharenko.hw4;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

import static java.util.Arrays.*;

public class Anagram {
    public static String deleteComma (String str) {
        String result1;
        str=str.toLowerCase();
        int pos;
        do {
        //находим индекс первого вхождения символа "," в подстроке
        pos = str.indexOf(",");
        if (pos !=-1) {//вычленяем имя атрибута из подстроки
        String attributeName= str.substring(0,pos);
        //вычленяем значение атрибута
        String value = str.substring(pos+1,str.length());
       str=attributeName+value;} }
        while (pos !=-1);

        return str;
    }

    public static void main(String[] args) {
        String string1, string2;
        Scanner scan = new Scanner(System.in);
        System.out.println("Введіть перше речення");
        string1 = scan.nextLine();
        System.out.println("Введіть друге речення");
        string2 = scan.nextLine();


        String lines1=deleteComma(string1);
        String lines2=deleteComma(string2);

        String lines11=lines1.replaceAll(" ","");
        String lines21=lines2.replaceAll(" ","");
        char[] lines12=lines11.toCharArray();
        char[] lines22=lines21.toCharArray();

        sort(lines12);
        sort(lines22);
        if(Arrays.equals(lines12, lines22))
            System.out.println(string1 + " є анаграмою речення "+string2);
        else
            System.out.println("Речення не є анаграмою");



    }
}
