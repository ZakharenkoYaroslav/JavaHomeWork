package com.pb.zakharenko.hw6;
use Veterinarian;


public class VetClinic {
    public static void main(String[] args) {

        Dog dog = new Dog("короткошерсна");
        Cat cat = new Cat("перська","Пенелопа");
        Horse horse = new Horse("короткогрива");



        Animal[] animals = new Animal[] {dog, cat, horse};
        System.out.println("----------------------");
        for (Animal a: animals)  {
        Veterinarian.treatAnimal(a);
    }


    }
}
