package com.pb.zakharenko.hw7;

public class Atelier {
    public static void main(String[] args) {

    Pants pants = new Pants(Size.XXS,"100","чорні");
    Skirt skirt = new Skirt(Size.XS,"200","блакитна");
    Tie tie = new Tie(Size.S,"250","червоний");
    Tshirt tshirt = new Tshirt(Size.M,"150","біла");

    Clothes[] clothes = new Clothes[] {pants, skirt, tie, tshirt};
    dressMan(clothes);
        System.out.println();
    dressWoman(clothes);
    }
    public static void dressMan (Clothes[] clothes){
        for (Clothes clothes1 : clothes) {
            if (clothes1 instanceof ManClothes) {
                System.out.println("Чоловічий одяг - "+clothes1.getName()+", "+clothes1.getClothesSize()+", ціна: "+clothes1.getPrice()+", колір: "+ clothes1.getColour());
            }
        }
    }


    public static void dressWoman (Clothes[] clothes){
        for (Clothes clothes1 : clothes) {
            if (clothes1 instanceof WomenClothes) {
                System.out.println("Жіночий одяг - "+clothes1.getName()+", "+clothes1.getClothesSize()+", ціна: "+clothes1.getPrice()+", колір: "+ clothes1.getColour());
            }
        }
    };
}
