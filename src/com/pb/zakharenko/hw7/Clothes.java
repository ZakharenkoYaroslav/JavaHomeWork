package com.pb.zakharenko.hw7;

public abstract class Clothes {
    private Size clothesSize;
    private String price;
    private String colour;
    private String name;

    public Clothes(Size clothesSize, String price, String colour, String name) {
        this.clothesSize = clothesSize;
        this.price = price;
        this.colour = colour;
        this.name = name;
    }

    public Size getClothesSize() {
        return clothesSize;
    }

    public String getPrice() {
        return price;
    }

    public String getColour() {
        return colour;
    }

    public String getName() {
        return name;
    }
}
