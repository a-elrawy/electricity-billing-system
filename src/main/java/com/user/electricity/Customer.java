package com.user.electricity;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Customer extends Person {
    private String address;
    private String meterCode;
    private String pathToContract;
    private final static File file = new File(Utilities.CustomersFilename);
    public Customer(String username,String password){
        super(username,password);
    }
    public Customer(String username, String email , String password, String address, String meterCode, String pathToContract) {
        super(Utilities.getNumberOfObjects(Utilities.CustomersFilename),username,email,password);
        this.address = address;
        this.meterCode = meterCode;
        this.pathToContract = pathToContract;
    }
// For Reading Only
    public Customer(int id, String username, String email , String password, String address, String meterCode, String pathToContract) {
        super(id, username, email, password);
        this.address = address;
        this.meterCode = meterCode;
        this.pathToContract = pathToContract;
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
        return "" + id +"|"+ username + "|" + email+ "|"+ password+ "|" + address+ "|" + meterCode+ "|" + pathToContract;
    }

    // To ve Generalized
    public static ArrayList<Customer> read_customers() throws IOException, ClassNotFoundException {
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
        ArrayList<Customer> customers =  Customer.read_customers();
        for(Customer c:customers){
            System.out.println(c.toString());
        }
    }
}
