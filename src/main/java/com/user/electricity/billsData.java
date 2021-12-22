package com.user.electricity;

public class billsData {
    private int billNo;
    private String name, address;
    private double value, comsuption;

    public billsData (int billNo, String name, String address, double value, double comsuption) {
        this.billNo = billNo;
        this.name = name;
        this.address = address;
        this.value = value;
        this.comsuption = comsuption;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setBillNo(int billNo) {
        this.billNo = billNo;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void setComsuption(double comsuption) {
        this.comsuption = comsuption;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getBillNo() {
        return billNo;
    }

    public double getValue() {
        return value;
    }

    public double getComsuption() {
        return comsuption;
    }
}
