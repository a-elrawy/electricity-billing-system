package com.user.electricity;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Complaint {
    int number;
    String customerName;
    String address;
    String region;
    String complaint;

    public Complaint(String customerName, String address, String region, String complaint) {
        this.number = FileHandler.getNumberOfObjects(Utilities.ComplaintsFilename);
        this.customerName = customerName;
        this.address = address;
        this.region = region;
        this.complaint = complaint;
    }

    public Complaint(int number, String customerName, String address, String region, String complaint) {
        this.number = number;
        this.customerName = customerName;
        this.address = address;
        this.region = region;
        this.complaint = complaint;
    }


    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getComplaint() {
        return complaint;
    }

    public void setComplaint(String complaint) {
        this.complaint = complaint;
    }

    public static ArrayList<Complaint> getComplaintsByRegion(String region) throws IOException {
        ArrayList<Complaint> complaints =  FileHandler.read_complaints();
        ArrayList<Complaint> complaints1 =  new ArrayList<>();
        for (Complaint c : complaints)
            if (Objects.equals(c.getRegion(), region))
                complaints1.add(c);
        return complaints1;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
    @Override
    public String toString() {
        return "" + number +"|"+ customerName + "|" + address+ "|"+ region+ "|" + complaint;
    }
}
