package com.pb.zakharenko.hw6;
import java.lang.reflect.Constructor;






public class VetClinic {
    public static void main(String[] args)  throws Exception {

        Dog dog = new Dog("короткошерсна");
        Cat cat = new Cat("перська","Пенелопа");
        Horse horse = new Horse("короткогрива");

        Class Veterinarian = Class.forName("com.pb.zakharenko.hw6.Veterinarian");
        // создание объекта через рефлексию
        Constructor constr = Veterinarian.getConstructor(new Class[]{String.class});
        Object obj = constr.newInstance("Ветеринар");

        if (obj instanceof Veterinarian) {
            for (Animal animal : animals)
                ((Veterinarian) obj).treatAnimal(animal);
        }


        Animal[] animals = new Animal[] {dog, cat, horse};
        System.out.println("----------------------");
        for (Animal a: animals)  {
        Veterinarian.treatAnimal(a);
    }


    }
}
