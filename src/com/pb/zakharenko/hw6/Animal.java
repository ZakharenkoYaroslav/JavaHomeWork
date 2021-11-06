package com.pb.zakharenko.hw6;

public class Animal {
    private String food;
    private String location;
    private String name;

    public Animal(String food, String location, String name) {
        this.food = food;
        this.location = location;
        this.name = name;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void sleep (String name) {
        System.out.println(name + " спить.");
    }

    public void makeNoise (String name) {
        System.out.println(name + " видає звуки.");
    }

    public void eat (String name) {
        System.out.println(name + " їсть їжу.");
    }

}
