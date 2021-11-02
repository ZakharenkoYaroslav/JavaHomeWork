package com.pb.zakharenko.hw5;

import java.util.Date;

public class Reader {

    private String PIB;
    private String numberReaderCertificate;
    private String faculty;
    private String dayOfBirth;
    private String phoneNumber;


    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public String getNumberReaderCertificate() {
        return numberReaderCertificate;
    }

    public String getFaculty() {
        return faculty;
    }

    public String getPIB() {
        return PIB;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }


    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public void setPIB(String PIB) {
        this.PIB = PIB;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public void setNumberReaderCertificate(String numberReaderCertificate) {
        this.numberReaderCertificate = numberReaderCertificate;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void takeBook (int count) {
        System.out.println("Петров взяв "+count+" книги");
    }

    public void takeBook (String...names) {
        String namesOfBooks ="";
        for (String name : names) {
            namesOfBooks=namesOfBooks+name+" ";
        }
        System.out.println("Петров взяв книги: "+namesOfBooks);
    }

    public void takeBook (Book... books) {
        String namesOfBooks ="Петров взяв книги: ";
        for (Book theBook : books) {
            namesOfBooks=namesOfBooks+theBook.getName()+" ("+theBook.getAuthor()+" "+theBook.getYearOfPublish()+"), ";
        }
        System.out.println(namesOfBooks);
    }

    public void returnBook (int count) {
        System.out.println("Петров повернув "+count+" книги");
    }
    public void returnBook (String...names) {
        String namesOfBooks ="";
        for (String name : names) {
            namesOfBooks=namesOfBooks+name+" ";
        }
        System.out.println("Петров повернув книги: "+namesOfBooks);
    }

    public void returnBook (Book... books) {
        String namesOfBooks ="Петров повернув книги: ";
        for (Book theBook : books) {
            namesOfBooks=namesOfBooks+theBook.getName()+" ("+theBook.getAuthor()+" "+theBook.getYearOfPublish()+"), ";
        }
        System.out.println(namesOfBooks);
    }
}


