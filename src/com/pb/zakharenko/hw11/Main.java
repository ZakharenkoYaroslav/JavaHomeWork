package com.pb.zakharenko.hw11;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.pb.zakharenko.hw3.Array;
import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;

import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class Main  {
    public static void main(String[] args) throws Exception {


        ObjectMapper mapper = new ObjectMapper();
        // pretty printing (json с отступами)
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        // для работы с полями типа LocalDate
        SimpleModule module = new SimpleModule();
        module.addSerializer(LocalDate.class, new LocalDateSerializer());
        module.addDeserializer(LocalDate.class, new LocalDateDeserializer());
        module.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer());
        module.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer());

        mapper.registerModule(module);

        List <String> phone1 = new ArrayList<>();
        List<String> p1 = Arrays.asList("+380503900101", "+380673900101", "+380933900101");
        phone1.addAll(p1);
        List <String> phone2 = new ArrayList<> ();
        List<String> p2 = Arrays.asList("+380503800101","+380673800101","+380933800101");
        phone2.addAll(p2);
        List <String> phone3 = new ArrayList<> ();
        List<String> p3 = Arrays.asList("+3234345", "+32343456", "+323434567");
        phone3.addAll(p3);
        List <String> phone4 = new ArrayList<> ();
        List<String> p4 = Arrays.asList("+5454545", "+54545456", "+545454567");
        phone4.addAll(p4);


        List<Person> persons = Arrays.asList(
                new Person("Orwell D.",phone1,LocalDate.of(1984, 1, 1),LocalDateTime.now()),
                new Person("Rand A.",phone2,LocalDate.of(1930, 10, 23),LocalDateTime.now()),
                new Person("Kipling J.R.", phone3, LocalDate.of(1936, 1, 18),LocalDateTime.now()),
                new Person("Fleming I.", phone4, LocalDate.of(1908, 5, 28),LocalDateTime.now())
        );


        String personsJson =  mapper.writeValueAsString(persons);
        //System.out.println(personsJson);

        Path path = Paths.get("phoneBook.json");
        // saveToFile (path,personsJson);
        //String text =readFromFile(path);
        //System.out.println(text);
        System.out.println();
        while (true) {
            String choise = menu();
            System.out.println();
            System.out.println();

            switch (choise) {
                case "0":
                    System.exit(0);
                    break;
                case "1":
                    System.out.println();
                    System.out.println("Введіть ПІБ нового контакту");
                    System.out.println();
                    Scanner scan2 = new Scanner(System.in);
                    String newName = scan2.nextLine();
                    System.out.println();
                    System.out.println("Введіть номера телефонів через кому");
                    System.out.println();
                    List<String> phone = new ArrayList<>();
                    //String phoneLine = scan2.next();
                    String[] phones = scan2.nextLine().split(",");
                    for (int count = 0; phones.length > count; count++) {
                        phone.add(phones[count].trim());
                    }
                    System.out.println();
                    System.out.println("Введіть рік народження");
                    int year = scan2.nextInt();
                    System.out.println();
                    System.out.println("Введіть місяць народження цифрою від 1 до 12");
                    int month = scan2.nextInt();
                    System.out.println();
                    System.out.println("Введіть число народження цифрою від 1 до 31");
                    int day = scan2.nextInt();
                    LocalDate dayOfBirthday =LocalDate.of(year,month,day);
                    Person newPerson = new Person(newName, phone, LocalDate.of(year, month, day), LocalDateTime.now());
                    System.out.println(newPerson);
                    try {
                    persons.add(new Person (newName, phone, dayOfBirthday, LocalDateTime.now()));

                        System.out.println("Контакт успішно додано!");}
                    catch (Exception e) {
                            e.printStackTrace();
                            System.out.println("String: " + e);
                        }
                        System.out.println();

                    break;
                case "2":
                    System.out.println(persons);
                    System.out.println("Введіть індекс елементу який бажаєте видалити від 0 до останнього");
                    Scanner scan3 = new Scanner(System.in);
                    int index = scan3.nextInt();
                    try {
                        persons.remove(index);
                        System.out.println("Контакт успішно видалено!");}
                    catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("String: " + e);
                    }
                    System.out.println();
                    break;
                case "3":
                    System.out.println("Пошук відбувається за ПІБ");
                    System.out.println("Будь ласка, введіть текст для пошуку!");
                    System.out.println();
                    Scanner scan4 = new Scanner(System.in);
                    String substring = scan4.next().trim();
                    Array ar1 = new Array();
                    System.out.println(persons.toArray()[0]);
                    //            for (int i=0;i<persons.toArray().length;i++){

                    //}
                    break;
                case "4":
                    System.out.println();
                    System.out.println();
                    break;
                case "5":
                    break;
                case "6":
                    saveToFile (path,personsJson);
                    System.out.println("Контакти успішно збережено до файлу!");
                    break;
                case "7":
                    String text =readFromFile(path);
                    System.out.println(text);
                    System.out.println("Контакти успішно завантажено з файлу!");

                    break;

            }
        }
    }
    public static void saveToFile (Path path, String text){
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write(text);
            System.out.println();
            System.out.println("Write to file \"" + path.toAbsolutePath() + "\" done!");
            System.out.println();



        }
        catch (Exception ex) {
            System.out.println("Error with file write: " + ex);
        }
    }

    public static String menu () {
        System.out.println();
        System.out.println("Оберіть потрібну дію!");
        System.out.println("1 - додавання контакту, 2 - видалення контакту, 3 - пошук контакту, 4 - виведення всіх контактів з сортуванням, 5 - редагування контакту, 6 - запис даних в файл, 7 - завантаження даних з файлу, 0 - вихід");
        Scanner scan = new Scanner(System.in);
        String choise = scan.next();
        return  choise;
    }

    public static  String readFromFile (Path path) {
            String result="";
            try (Scanner scan2 = new Scanner(path)) {

                while (scan2.hasNext()) {
                String line = scan2.nextLine();
                //System.out.println(line);
                result = result + line+"\n";
                                    }
            }
            catch (Exception ex) {
                System.out.println("Error with file write: " + ex);
            }
        System.out.println();
        return result;
    }

}
