package com.pb.zakharenko.hw6;
import java.util.Objects;

public class Cat extends Animal{
    private String brit;
    private String nickname;

    public Cat(String brit,String nickname) {
        this.brit = brit;
        this.nickname = nickname;
        super("кошачий корм, м'ясо, молоко, полює на гризунів","мешкає разом з людиною або дикій природі","кішка");
    }



    @Override
    public void makeNoise(String name) {
        System.out.println(name + " нявкає.");
    }

    @Override
    public void eat(String name,String brit,String nickname) {
        System.out.println(name + " "+"породи "+brit+" за іменем "+nickname+" спить.");
    }


    @Override
    public int hashCode() {
        return Objects.hash(model, maxSpeed);
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
