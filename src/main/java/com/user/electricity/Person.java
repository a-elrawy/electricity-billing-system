package com.user.electricity;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Person {
    protected int id;
    protected String username;
    protected String email;
    protected String password;
    public Person(int id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public Person(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public static ArrayList<Person> read_people(String filename) throws IOException, ClassNotFoundException {
        File file = new File(filename);
        Scanner scanner = new Scanner(file);
        ArrayList<Person> people = new ArrayList<Person>();
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            String[] items = line.split("\\|");
            int id = Integer.parseInt(items[0]);
            Person person = new Person(id,items[1],items[2],items[3]);
            people.add(person);
        }
        return people;
    }

}
