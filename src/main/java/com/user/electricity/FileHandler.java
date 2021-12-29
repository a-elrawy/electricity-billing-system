package com.user.electricity;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {
    private static File file = new File(Utilities.CustomersFilename);

    public static void write(Object object, String filename ) throws IOException {
        try {
            Files.write(Paths.get(filename), (object.toString()+ System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);
        }catch (Exception e){
            File file = new File(filename);
            file.createNewFile();
            Files.write(Paths.get(filename), (object.toString()+ System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);
        }
    }
    public static ArrayList<Customer> read_customers() throws IOException, ClassNotFoundException {
        Scanner scanner = new Scanner(file);
        ArrayList<Customer> customers = new ArrayList<Customer>();
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            String[] items = line.split("\\|");
            int id = Integer.parseInt(items[0]);
            Customer customer = new Customer(id,items[1],items[2],items[3],items[4],items[5],items[6],items[7],Double.parseDouble(items[8]),Double.parseDouble(items[9]),Integer.parseInt(items[10]));
            customers.add(customer);
        }
        return customers;
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
    public static ArrayList<Complaint> read_complaints() throws IOException {
        Scanner scanner = new Scanner(new File(Utilities.ComplaintsFilename));
        ArrayList<Complaint> complaints = new ArrayList<Complaint>();
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            String[] items = line.split("\\|");
            int id = Integer.parseInt(items[0]);
            Complaint complaint = new Complaint(id,items[1],items[2],items[3],items[4]);
            complaints.add(complaint);
        }
        return complaints;
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
}
