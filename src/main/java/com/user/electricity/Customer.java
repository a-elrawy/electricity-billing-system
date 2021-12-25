package com.user.electricity;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Customer extends Person {
    private String address;
    private String region;
    private String meterCode;
    private String pathToContract;
    private double amount;
    private double realConsumption ;
    private static File file = new File(Utilities.CustomersFilename);
    public Customer(String username,String password){
        super(username,password);
    }
    public Customer(String username, String email , String password, String address, String region, String meterCode, String pathToContract) throws IOException {
        super(username,email,password);
        this.address = address;
        this.region = region;
        this.meterCode = meterCode;
        this.pathToContract = pathToContract;
    }
    public Customer(int id, String username, String email , String password, String address, String region, String meterCode, String pathToContract) {
        super(id, username, email, password);
        this.address = address;
        this.region = region;
        this.meterCode = meterCode;
        this.pathToContract = pathToContract;
    }
// For Reading Only

    public Customer(int id, String username, String email, String password, String address, String region, String meterCode, String pathToContract, double amount, double realConsumption) {
        super(id, username, email, password);
        this.address = address;
        this.region = region;
        this.meterCode = meterCode;
        this.pathToContract = pathToContract;
        this.amount = amount;
        this.realConsumption = realConsumption;
    }


    public String getAddress() {
        return address;
    }

    public String getMeterCode() {
        return meterCode;
    }

    public String getPathToContract() {
        return pathToContract;
    }
    @Override
    public String toString() {
        return "" + id +"|"+ username + "|" + email+ "|"+ password+ "|" + address+ "|" + region + "|" +  meterCode+ "|" + pathToContract + "|" + amount+"|" + realConsumption;
    }

    // To ve Generalized
    public static ArrayList<Customer> read_customers() throws IOException, ClassNotFoundException {
        Scanner scanner = new Scanner(file);
        ArrayList<Customer> customers = new ArrayList<Customer>();
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            String[] items = line.split("\\|");
            int id = Integer.parseInt(items[0]);
            Customer customer = new Customer(id,items[1],items[2],items[3],items[4],items[5],items[6],items[7],Double.parseDouble(items[8]),Double.parseDouble(items[9]));
            customers.add(customer);
        }
        return customers;
    }
    public static Customer read_customer(String meterCode) throws IOException, ClassNotFoundException {
        ArrayList<Customer> customers =  Customer.read_customers();
        for(Customer c:customers){
            if(c.getMeterCode().equals(meterCode))
                return c;
        }
        return null;
    }
    public static Customer read_customer(int userID) throws IOException, ClassNotFoundException {
        ArrayList<Customer> customers =  Customer.read_customers();
        for(Customer c:customers){
            if(c.getId() == userID)
                return c;
        }
        return null;
    }

    public static void printAllCustomers() throws IOException, ClassNotFoundException {
        ArrayList<Customer> customers =  Customer.read_customers();
        for(Customer c:customers){
            System.out.println(c.toString());
        }
    }
    public static void remove_customer(String meterCode) throws IOException, ClassNotFoundException {
        ArrayList<Customer> customers =  Customer.read_customers();
        file.delete();
        File file = new File(Utilities.CustomersFilename);
        file.createNewFile();
        customers.removeIf(c -> c.getMeterCode().equals(meterCode));
        for (int i = 0; i < customers.size(); i++) {
            Files.write(Paths.get(Utilities.CustomersFilename), (customers.get(i).toString()+ System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);
        }
    }
    public static void update_customer(Customer customer) throws IOException, ClassNotFoundException {
        ArrayList<Customer> customers =  Customer.read_customers();
        file.delete();
        File file = new File(Utilities.CustomersFilename);
        file.createNewFile();
        for (int i = 0; i < customers.size(); i++) {
            if (Objects.equals(customers.get(i).meterCode, customer.meterCode)) {
                if (Objects.equals(customer.password , ""))
                    customer.password = customers.get(i).password;
                customers.remove(i);
                customers.add(customer);
            }
        }
        for (int i = 0; i < customers.size(); i++) {
            Files.write(Paths.get(Utilities.CustomersFilename), (customers.get(i).toString()+ System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);
        }
    }
    public String getRegion() {
        return region;
    }
    public static ArrayList<Customer> getCustomersByRegion(String region) throws IOException, ClassNotFoundException {
        ArrayList<Customer> customers =  Customer.read_customers();
        ArrayList<Customer> customers2 =  new ArrayList<>();
        for (Customer c : customers)
            if (Objects.equals(c.getRegion(), region))
                customers2.add(c);
        return customers2;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setMeterCode(String meterCode) {
        this.meterCode = meterCode;
    }

    public double getRealConsumption() {
        return realConsumption;
    }

    public void setRealConsumption(double realConsumption) {
        this.realConsumption = realConsumption;
    }
}
