package com.pb.zakharenko.hw5;

import javax.swing.plaf.nimbus.State;
import java.util.Date;

/**
 * Класс описывающий книги
 */
public class Book {

    private String name;
    private String Author;
    private String YearOfPublish;


    public String getYearOfPublish() {
        return YearOfPublish;
    }

    public String getAuthor() {
        return Author;
    }

    public String getName() {
        return name;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYearOfPublish(String yearOfPublish) {
        YearOfPublish = yearOfPublish;
    }

}
