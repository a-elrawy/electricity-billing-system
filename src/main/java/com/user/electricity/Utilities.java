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
    public static ArrayList<Customer> read_customers() throws IOException, ClassNotFoundException {
        File file = new File(Utilities.CustomersFilename);
        Scanner scanner = new Scanner(file);
        ArrayList<Customer> customers = new ArrayList<Customer>();

        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            String[] items = line.split("\\|");
            int id = Integer.parseInt(items[0]);
            Customer customer = new Customer(id,items[1],items[2],items[3],items[4],items[5],items[6]);
            customers.add(customer);
        }
        return customers;
    }
    public static void printAllCustomers() throws IOException, ClassNotFoundException {
        File file = new File(Utilities.CustomersFilename);
        ArrayList<Customer> customers =  Utilities.read_customers();
        for(Customer c:customers){
            System.out.println(c.toString());
        }
    }
    public static int getNumberOfCustomers(){
        File file = new File(Utilities.CustomersFilename);
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
