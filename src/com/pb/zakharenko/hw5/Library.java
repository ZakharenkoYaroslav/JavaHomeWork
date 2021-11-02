package com.pb.zakharenko.hw5;


/**
 * Класс описывающий библиотеку
 */

public class Library {

    public static void main(String[] args) {

        Book book1 = new Book();
        Book book2 = new Book();
        Book book3 = new Book();

        book1.setName("1984");
        book1.setAuthor("G. Orwell");
        book1.setYearOfPublish("01.1943");

        book2.setName("Дракон");
        book2.setAuthor("Е.Шварц");
        book2.setYearOfPublish("01.1942");

        book3.setName("Тот самый Мюнхаузен");
        book3.setAuthor("Г.Горин");
        book3.setYearOfPublish("01.1980");

        Reader reader1 = new Reader();
        Reader reader2 = new Reader();
        Reader reader3 = new Reader();

        reader1.setPIB("Гонта І.І.");
        reader1.setFaculty("Історичний");
        reader1.setDayOfBirth("01.01.1760");
        reader1.setNumberReaderCertificate("1");
        reader1.setPhoneNumber("+380503330101");

        reader2.setPIB("Шевченко Т.Г.");
        reader2.setFaculty("Літературний");
        reader2.setDayOfBirth("09.03.1814");
        reader2.setNumberReaderCertificate("2");
        reader2.setPhoneNumber("+380503330102");

        reader3.setPIB("Лук'яненко Л.Г.");
        reader3.setFaculty("Державний");
        reader3.setDayOfBirth("24.08.1928");
        reader3.setNumberReaderCertificate("3");
        reader3.setPhoneNumber("+380503330103");

        reader1.takeBook(3);
        reader1.takeBook(book1.getName(),book2.getName(),book3.getName());
        reader1.takeBook(book1,book2,book3);

        reader1.returnBook(3);
        reader1.returnBook(book1.getName(),book2.getName(),book3.getName());
        reader1.returnBook(book1,book2,book3);

    }
}
