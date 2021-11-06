package com.pb.zakharenko.hw6;
import java.util.Objects;

public class Dog extends Animal{
        private String fur;



    public Dog(String food, String location, String name, String fur) {
        super(food, location, name);
        this.fur = fur;
    }

    @Override
    public void makeNoise(String name) {

        System.out.println(name + " бреше.");
    }

    @Override
    public void eat(String name) {

        System.out.println(name + " їсть "+getFood());
    }




    @Override
    public int hashCode() {
        return super.hashCode();
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
