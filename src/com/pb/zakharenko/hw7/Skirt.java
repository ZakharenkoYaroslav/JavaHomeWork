package com.pb.zakharenko.hw7;

public class Skirt extends Clothes implements WomenClothes {


    public Skirt(Size clothesSize, String price, String colour) {
        super(clothesSize, price, colour, "Спідниця");
    }


    @Override
    public void dressWomen() {
        System.out.println("Товар - "+getName()+", розмір - "+getClothesSize()+", ціна - "+getPrice()+", колір - "+getColour());
    }
}
