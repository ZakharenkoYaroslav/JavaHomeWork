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

    public String getBrit() {
        return brit;
    }

    @Override
    public void makeNoise(String name) {
        System.out.println(name + " нявкає.");
    }

    @Override
    public void eat(String name,String brit,String nickname) {
        System.out.println(name + " "+"породи "+brit+" за іменем "+nickname+" їсть.");
    }


    @Override
    public int hashCode() {
        return Objects.hash(brit, nickname);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal cat1 = (Animal) o;
        return getName() == cat1.getName() && Objects.equals(brit, cat1.getBrit);
    }

    @Override
    public String toString() {
        return getName()+" за sменем "+nickname+" породи "+brit;
    }
}
