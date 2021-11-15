package com.pb.zakharenko.hw7;

public class Tshirt extends Clothes implements ManClothes, WomenClothes {


    public Tshirt(Size clothesSize, String price, String colour) {
        super(clothesSize, price, colour, "Сорочка");
    }

    public Tshirt(Size clothesSize, String price, String colour, String name) {
        super(clothesSize, price, colour, name);
    }

    @Override
    public void dressMan() {
        System.out.println("Товар - "+getName()+", розмір - "+getClothesSize()+", ціна - "+getPrice()+", колір - "+getColour());
    }

    @Override
    public void dressWomen() {
        System.out.println("Товар - "+getName()+", розмір - "+getClothesSize()+", ціна - "+getPrice()+", колір - "+getColour());
    }
}
