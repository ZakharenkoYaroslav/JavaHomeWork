package com.pb.zakharenko.hw11;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Person implements Serializable {
    private String name;
    private List<String> phone;
    private LocalDate dateOfBirth;
    private LocalDateTime timestamp;

    public Person(String name, List <String> phone, LocalDate dateOfBirth, LocalDateTime timestamp) {
        this.name = name;
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
        this.timestamp = timestamp;
    }

    public Person() {

    }

    public String getName() {
        return name;
    }

    public List <String> getPhone() {
        return phone;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setName(String name) {
        this.name = name;
        this.timestamp =  LocalDateTime.now();
    }

    public void setPhone(List <String> phone) {
        this.phone = phone;
        this.timestamp =  LocalDateTime.now();
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        this.timestamp =  LocalDateTime.now();
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
        this.timestamp =  LocalDateTime.now();
    }

    @Override
    public String toString() {
        return  "Person{" +
                "name='" + name + '\'' +
                ", phone='" + phone.toString() + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", timestamp="+ timestamp +
                '}' + "\n";
    }

}
