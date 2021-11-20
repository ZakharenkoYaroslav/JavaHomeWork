package com.pb.zakharenko.hw8;

public class Auth {
    private String login;
    private String password;

    public Auth(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void signUp (String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
//                       if (login.length() < 5 && login.length() > 20)
//             {
//                throw new WrongLoginExeption();
//             }
        boolean result = login.matches("[A-Za-z0-9]{5,20}");
        if (!result){
            throw new WrongLoginException("Логін може містити тільки латинські літери та цифри і мати довжину від 5 до 20 символів!");
        }
        else if (!password.matches("[A-Za-z_0-9]{5,}")) {
                    throw new WrongPasswordException("Пароль не відповідає вимогам! Може містити англійські літери, цифри та знак підкреслення, мати довжину не менше аніж 5 символів.");
        }
        else if (!password.equals(confirmPassword)){
            throw new WrongPasswordException("Введені паролі не відповідні один одному!");
        }
        else System.out.println("Вітаємо! Ви успішно зареєстровані!");
    }

    public void signIn (String login, String password) throws WrongLoginException {
        if (!login.equals(this.login) || !password.equals(this.password)){
            throw new WrongLoginException ("Помилка введеного логіну та паролю!");
        }
        else {
            System.out.println("Ви успішно увійшли в систему!");
        }
    }

}
