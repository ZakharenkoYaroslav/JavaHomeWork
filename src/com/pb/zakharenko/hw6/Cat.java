package com.pb.zakharenko.hw6;
import java.util.Objects;

public class Cat extends Animal{
    private String brit;
    private String nickname;

    public Cat(String food, String location, String name, String brit, String nickname) {
        super(food, location, name);
        this.brit = brit;
        this.nickname = nickname;
    }

    public String getBrit() {
        return brit;
    }

    @Override
    public void makeNoise(String name) {
        System.out.println(name + " нявкає.");
    }



    @Override
    public void eat(String name) {
        System.out.println(name + "  їсть корм.");
    }

    @Override
    public int hashCode() {
        return Objects.hash(brit, nickname);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal cat1 = (Animal) o;
        return getName() == cat1.getName() && Objects.equals(brit, ((cat1)o).getBrit);
    }

    @Override
    public String toString() {
        return getName()+" за sменем "+nickname+" породи "+brit;
    }
}
