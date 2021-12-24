package com.user.electricity;


import java.io.*;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Utilities {
    static String CustomersFilename = "customers.txt";
    static String OperatorsFilename = "operators.txt";
    static String AdminFilename = "admins.txt";
    static String ComplaintsFilename = "complaints.txt";
    static int UserCount =0;
    static int CurrentUserID;
    public static String generateMeterCode(String region){
        return  region.charAt(0)+ String.valueOf(UserCount);
    }

    public static void write(Object object, String filename ) throws IOException {
        try {
            Files.write(Paths.get(filename), (object.toString()+ System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);
        }catch (Exception e){
            File file = new File(filename);
            file.createNewFile();
            Files.write(Paths.get(filename), (object.toString()+ System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);
        }
    }
    public static int getNumberOfObjects(String filename){
        File file = new File(filename);
        int count = 0;
        try {
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()) {
                sc.nextLine();
                count++;
            }
            sc.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
        return count;
    }
    public static void readNumbers(String filename) throws IOException {
        try {
            Scanner scanner = new Scanner(new File(filename));
            UserCount = scanner.nextInt();
            FileWriter file = new FileWriter(filename);
            file.write(String.valueOf(UserCount++));
            file.close();
        } catch (Exception e) {
            writeNumbers(filename);
        }
    }
    public static void writeNumbers(String filename) throws IOException {
        FileWriter file = new FileWriter(filename);
        file.write(String.valueOf(UserCount));
        file.close();
    }
    public static boolean validate_login (Person person, String filename) throws IOException, ClassNotFoundException {
        boolean login = false;
        ArrayList<Person> people = Person.read_people(filename);
        for (Person c:  people) {
            if (c.getUsername().equals(person.getUsername()) && c.getPassword().equals(person.getPassword())) {
                login = true;
                Utilities.CurrentUserID = c.getId();
            }
        }
        return login;
    }



}
