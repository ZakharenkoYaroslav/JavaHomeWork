package com.pb.zakharenko.hw6;

import java.lang.reflect.Constructor;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {

        Class Veterinarian = Class.forName("Animal.Veterinarian");
        // создание объекта через рефлексию
        Constructor constr = Veterinarian .getConstructor(new Class[]{String.class});
        Object obj = constr.newInstance("Петров");

        public static void treatAnimal(Animal animal){
            System.out.println(animal.getName());
            System.out.println(animal.getLocation);
            System.out.println(animal.getFood);
        }

    }



    }