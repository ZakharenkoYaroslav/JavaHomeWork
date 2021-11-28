package com.pb.zakharenko.hw10;

public class NumBox <T extends Number>{
    private T [] numbers;
    private int size;

    public NumBox(int size) {
        //this.numbers = numbers;
        numbers = (T[]) new Number[size];
    }

    public T[] getNumbers() {
        return numbers;
    }

    public int getSize() {
        return numbers.length;
    }



    public void add (T num) throws ArrayOutOfBoundExeption {
        if (length() > numbers.length ) {throw new ArrayOutOfBoundExeption("Масив вже заповнений! Неможливо додати новий елемент!"); }
        else {
            int currentIndex = length();
            this.numbers[currentIndex]=num;
        }

    }
    public T get (int index){
        return numbers[index];
    }

    public int length (){
        int count = 0;
        for(T i : numbers){
            if(!(i == null)){
                count++;
            }
        }
        return count;
    }


    public double average(){
        double sumOfArray=0;
        for (int i=0;i < numbers.length;i++){
            sumOfArray=sumOfArray+numbers[i].doubleValue();
        }
        return sumOfArray/numbers.length;
    }
    public double sum(){
        double sumOfArray=0;
        for (int i=0;i < numbers.length;i++){
            sumOfArray=sumOfArray+numbers[i].doubleValue();
        }
        return sumOfArray;
    }
    public T max (){
        T maxOfArray;
        maxOfArray=numbers[0];
        for (int i=0;i < numbers.length;i++){
            if (maxOfArray.doubleValue() >= numbers[i].doubleValue()) {}
            else {maxOfArray=numbers[i];}

        }
        return maxOfArray;
    }
}
