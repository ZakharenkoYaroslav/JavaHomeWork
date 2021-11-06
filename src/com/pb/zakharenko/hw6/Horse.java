package com.pb.zakharenko.hw6;
import java.util.Objects;

public class Horse extends Animal{
    private String mane;

    public Horse(String mane) {
        this.mane = mane;
        super ("Трави, зерно, сіно","переважно мешкає з людиною, в природі випасається в лугах","кінь");
    }


    @Override
    public void makeNoise(String name) {
        System.out.println(name + " ірже.");
    }

    @Override
    public void eat(String name) {
        System.out.println(name + " випасається на лузі.");
    }



    @Override
    public int hashCode() {
        return Objects.hash(getName(),mane);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal horse1 = (Animal) o;
        return getName() == horse1.getName() && Objects.equals(mane, horse1.mane);
    }

    @Override
    public String toString() {
        return getName()+" з"+mane +" гривою";
    }
}