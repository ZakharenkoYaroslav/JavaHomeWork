package com.pb.zakharenko.hw6;

public class Veterinarian {
    public Veterinarian() {
    }

    public void treatAnimal(Animal animal) {
        System.out.println("-----------------------------------------");
        System.out.println("Назва тварини: "+animal.getName());
        System.out.println("Локація тварини: "+animal.getLocation());
        System.out.println("Харчування тварини: "+animal.getFood());
    }
}
