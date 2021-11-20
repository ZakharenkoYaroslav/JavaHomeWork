package com.pb.zakharenko.hw8;

import java.util.Scanner;

public class OnlineShop {
    public static void main(String[] args) {
        Auth auth = new Auth("login","password");
        Scanner scan = new Scanner(System.in);

        System.out.println("Для початку роботи, будь ласка, зареєструйтеся!");
        System.out.println("Логін може містити тільки англійські літери або цифри!");
        System.out.println("Введіть логін!");
        String tryLogin =scan.nextLine();

        System.out.println("Пароль може містити тільки англійські літери, цифри або знак підкреслення");
        System.out.println("Введіть пароль!");
        String tryPassword = scan.nextLine();
        System.out.println("Повторіть пароль!");
        String tryConfirmPassword = scan.nextLine();

        try {auth.signUp(tryLogin,tryPassword,tryConfirmPassword);}
        catch (WrongLoginException | WrongPasswordException e) {
            System.out.println("Помилки при реєстрації");
            e.getMessage();
            e.printStackTrace();
            System.exit(0);
        }


        auth.setLogin(tryLogin);
        auth.setPassword(tryPassword);
        System.out.println("Для входу на сайт, будь ласка, увійдіть в систему!");
        System.out.println("Введіть логін!");
        String tryLogin2 =scan.nextLine();
        System.out.println("Пароль може містити тільки англійські літери, цифри або знак підкреслення");
        System.out.println("Введіть пароль!");
        String tryPassword2 = scan.nextLine();
        try {
            auth.signIn(tryLogin2,tryPassword2);
        }
        catch (WrongLoginException e) {
            System.out.println("Помилки при вході в систему");
            e.getMessage();
            e.printStackTrace();
            System.exit(0);
        }

    }
}
