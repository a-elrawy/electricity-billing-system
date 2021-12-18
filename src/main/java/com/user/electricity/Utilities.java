package com.user.electricity;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Scanner;

public class Utilities {
    static String CustomersFilename = "customers.txt";
    static String OperatorsFilename = "operators.txt";
    static String AdminFilename = "admin.txt";


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

    public static boolean validate_login (Person person, String filename) throws IOException, ClassNotFoundException {
        boolean login = false;
        ArrayList<Person> people = Person.read_people(filename);
        for (Person c:  people) {
            if (c.getUsername().equals(person.getUsername()) && c.getPassword().equals(person.getPassword()))
                login = true;
        }
        return login;
    }



}
