package com.pb.zakharenko.hw7;

public class Tie extends Clothes implements ManClothes {


    public Tie(Size clothesSize, String price, String colour) {
        super(clothesSize, price, colour,"Краватка");

    }


    @Override
    public void dressMan() {
        System.out.println("Товар - "+getName()+", розмір - "+getClothesSize()+", ціна - "+getPrice()+", колір - "+getColour());
    }
}
