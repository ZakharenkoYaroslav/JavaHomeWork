package com.pb.zakharenko.hw12;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.pb.zakharenko.hw11.LocalDateSerializer;
import com.pb.zakharenko.hw11.LocalDateTimeSerializer;
import com.pb.zakharenko.hw11.Person;

import java.io.BufferedWriter;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {


        ObjectMapper mapper = new ObjectMapper();
        // pretty printing (json с отступами)
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        //mapper.enable(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES);
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


        List<com.pb.zakharenko.hw11.Person> persons = new ArrayList<>(Arrays.asList(
                new com.pb.zakharenko.hw11.Person("Orwell D.",phone1,LocalDate.of(1984, 1, 1),LocalDateTime.now()),
                new com.pb.zakharenko.hw11.Person("Rand A.",phone2,LocalDate.of(1930, 10, 23),LocalDateTime.now()),
                new com.pb.zakharenko.hw11.Person("Kipling J.R.", phone3, LocalDate.of(1936, 1, 18),LocalDateTime.now()),
                new com.pb.zakharenko.hw11.Person("Fleming I.", phone4, LocalDate.of(1908, 5, 28),LocalDateTime.now())
        ));


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
                case "-1":
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
                    com.pb.zakharenko.hw11.Person newPerson = new com.pb.zakharenko.hw11.Person(newName, phone, LocalDate.of(year, month, day), LocalDateTime.now());
                    System.out.println(newPerson);
                    try {
                    persons.add(new com.pb.zakharenko.hw11.Person(newName, phone, dayOfBirthday, LocalDateTime.now()));

                        System.out.println("Контакт успішно додано!");}
                    catch (Exception e) {
                            e.printStackTrace();
                            System.out.println("String: " + e);
                        }
                        System.out.println();

                    break;
                case "2":
                    System.out.println(persons);

                    System.out.println("Введіть індекс елементу який бажаєте видалити від 0 до останнього або введіть -1 для виходу");
                    Scanner scan3 = new Scanner(System.in);
                    int index = scan3.nextInt();
                    if (index == -1) {break;}
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
                    ArrayList<Integer> ar1 = new ArrayList<>();


                    for (int i=0;i<persons.toArray().length;i++){
                        String test =persons.get(i).getName();
                        if (persons.get(i).getName().toLowerCase().contains(substring.toLowerCase())) {
                            ar1.add(i);
                        }
                    }
                    System.out.println("Ваш рядок був знайдений в наступних записах");
                    System.out.println();
                    for (int i=0; i<ar1.size();i++) {
                        System.out.println("індекс елементу = " +ar1.get(i));
                        System.out.println(persons.get(ar1.get(i)));
                    }

                    break;
                case "4":
                    System.out.println();
                    System.out.println("За яким критерієм сортувати телефонну книгу?");
                    System.out.println("1 - за іменем, 2 - за датою народження або вкажіть -1 для виходу");
                    System.out.println("Зробіть свій вибір!");
                    Scanner scan5 = new Scanner(System.in);
                    int typeSort = scan5.nextInt();
                    if (typeSort == -1) {break;}
                    if (typeSort == 1) {
                        System.out.println("sorted by name persons : ");
                        persons.stream()
                                .sorted(Comparator.comparing(Person::getName))
                                .forEach(System.out::println);
                        //persons.sort(Comparator.comparing(p -> p.getName()));
                        //System.out.println("sorted by name persons = " + persons);
                    }
                    if (typeSort == 2) {
                        System.out.println("sorted by date of birthday persons : ");
                        persons.stream()
                                .sorted(Comparator.comparing(Person::getDateOfBirth))
                                .forEach(System.out::println);
                        //persons.sort(Comparator.comparing(p -> p.getDateOfBirth()));
                        //System.out.println("sorted by date of birthday persons = " + persons);
                    }
                    break;
                case "5":
                    for ( int i=0; i<persons.size();i++){
                        System.out.println();
                        System.out.println("Індекс запису = "+i);
                        System.out.println(persons.get(i));
                    }
                    System.out.println("Оберіть індекс елементу для редагування");
                    System.out.println();
                    Scanner scan6 = new Scanner(System.in);
                    index = scan6.nextInt();
                    System.out.println();
                    System.out.println(persons.get(index));
                    System.out.println("Якщо запис обрано вірно, введіть 1 або -1 для виходу");
                    int choise2 = scan6.nextInt();
                    if ( choise2 == 1) {
                        editRecord(index,persons);
                    };
                    if (choise2 == -1) {break;}

                    break;
                case "6":
                    saveToFile (path,personsJson);
                    System.out.println("Контакти успішно збережено до файлу!");
                    break;
                case "7":
                    List <com.pb.zakharenko.hw11.Person> text =readFromFile(path,mapper);
                    System.out.println(text);
                    //persons = mapper.rea(text);
                    //System.out.println(persons);
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
        System.out.println("1 - додавання контакту, 2 - видалення контакту, 3 - пошук контакту, 4 - виведення всіх контактів з сортуванням, 5 - редагування контакту, 6 - запис даних в файл, 7 - завантаження даних з файлу, -1 - вихід");
        Scanner scan = new Scanner(System.in);
        String choise = scan.next();
        return  choise;
    }

    public static  List<com.pb.zakharenko.hw11.Person> readFromFile (Path path, ObjectMapper mapper)  throws Exception {


     //   System.out.println(persons2);
        File file = Paths.get("phoneBook.json").toFile();
        System.out.println(file);
        com.pb.zakharenko.hw11.Person[] persons2 = mapper.readValue(file, com.pb.zakharenko.hw11.Person[].class);


        return Arrays.asList(persons2);


    }

    public static void editRecord (int index, List <Person> persons){
        System.out.println();
        while (true) {
            System.out.println(persons.get(index));
            System.out.println("Введіть параметр для редагування або код виходу");
            System.out.println(" 1 - для редаругвання імені, 2 - для редагування номерів телефонів, 3 - для редагування дати народження, -1 - для виходу до головного меню ");
            System.out.println("Зробіть свій вибір!");
            Scanner scan6 = new Scanner(System.in);
            int typeEdit = scan6.nextInt();
            if (typeEdit == -1){return;}
            if (typeEdit == 1){
                System.out.println(persons.get(index).getName());
                System.out.println("Введіть нове ім'я");
                persons.get(index).setName(scan6.nextLine());

                }
            if (typeEdit == 2){
                System.out.println(persons.get(index).getPhone());
                System.out.println("Введіть нові номери телефорнів через кому");
                System.out.println();
                List<String> phone = new ArrayList<>();
                String[] phones = scan6.nextLine().split(",");
                for (int count = 0; phones.length > count; count++) {
                    phone.add(phones[count].trim());
                }
                persons.get(index).setPhone(phone);
            }
            if (typeEdit == 3) {
                System.out.println(persons.get(index).getPhone());
                System.out.println();
                System.out.println("Введіть рік народження");
                int year = scan6.nextInt();
                System.out.println();
                System.out.println("Введіть місяць народження цифрою від 1 до 12");
                int month = scan6.nextInt();
                System.out.println();
                System.out.println("Введіть число народження цифрою від 1 до 31");
                int day = scan6.nextInt();
                LocalDate dayOfBirthday =LocalDate.of(year,month,day);
                persons.get(index).setDateOfBirth(dayOfBirthday);
            }
        }
    }

}
