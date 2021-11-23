package com.pb.zakharenko.hw9;


import java.io.BufferedWriter;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.util.Scanner;

public class FileNumbers {

    public static void createNumbersFile(){

        Random random = new Random();
        Path path = Paths.get("numbers.txt");

        // write to file
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++){

                    int x = random.nextInt(100);
                    writer.write(x+" ");
                    System.out.print(x+" ");
            }

                writer.newLine();
            System.out.println();

        }
    } catch (Exception ex) {
        System.out.println("Error with file write: " + ex);
    }

        System.out.println("Write to file \"" + path.toAbsolutePath() + "\" done!");
        System.out.println();


    }
    public static void  createOddNumbersFile() {

        int digit;
        int i=0;

        //read from file
        Path path = Paths.get("numbers.txt");
        Path path2 = Paths.get("odd-numbers.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(path2)) {
            try (Scanner scan = new Scanner(path)) {

                while (scan.hasNextInt()) {

                    digit = scan.nextInt();
                    double res = (double) digit / 2;
                    int resInt = (int) res;
                    double res2 = res-resInt;
                    if (res2 == 0) {
                        writer.write(0 + " ");
                    } else {
                        writer.write(digit + " ");
                    }
                    if (i == 9) {
                        writer.newLine();
                        System.out.println();
                        i = 0;
                    } else {
                        i++;
                    }

                    System.out.print(digit+" ");
                }
            } catch (Exception ex) {
                System.out.println("Error with file write: " + ex);
            }

        } catch (Exception ex) {
            System.out.println("Error with file write: " + ex);
        }
        System.out.println();
        System.out.println("Read from file \"" + path.toAbsolutePath() + "\" done!");


    }

    public static void main(String[] args) {
        createNumbersFile();
        createOddNumbersFile();
    }
}
