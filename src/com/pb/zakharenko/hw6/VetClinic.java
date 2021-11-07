package com.pb.zakharenko.hw6;
import java.lang.reflect.Constructor;






public class VetClinic {
    public static void main(String[] args)  throws Exception {

        Dog dog = new Dog("собачий корм, м'ясо","мешкає разом з людиною або в населених" +
                " пунктах","собака","короткошерсна");
        Cat cat = new Cat ("кошачий корм, м'ясо, молоко, полює на гризунів","мешкає разом" +
                " з людиною або дикій природі","кішка","перська","Пенелопа");
        Horse horse = new Horse ("Трави, зерно, сіно","переважно мешкає з людиною, в природі" +
                " випасається в лугах","кінь","короткогривий");

        Class Veterinarian = Class.forName("com.pb.zakharenko.hw6.Veterinarian");

        // создание объекта через рефлексию
        Constructor constr = Veterinarian.getConstructor(new Class[]{});
        Object obj = constr.newInstance();

        if (obj instanceof Veterinarian) {
      //      for (Animal animal : animals)
//                ((Veterinarian) obj).treatAnimal(animal);
        }


        Animal[] animals = new Animal[] {dog, cat, horse};

        for (Animal a: animals)  {
            ((Veterinarian) obj).treatAnimal(a);
    }


    }
}
