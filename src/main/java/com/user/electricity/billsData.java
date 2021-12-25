package com.user.electricity;

public class billsData {
    private int billNo;
    private String name, address;
    private double value, consumption;

    public billsData (int billNo, String name, String address, double value, double consumption) {
        this.billNo = billNo;
        this.name = name;
        this.address = address;
        this.value = value;
        this.consumption = consumption;
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

    public void setConsumption(double consumption) {
        this.consumption = consumption;
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

    public double getConsumption() {
        return consumption;
    }

    @Override
    public String toString() {
        return "" + billNo +"|"+ name + "|" + address+ "|"+ value+ "|" + consumption;
    }
}
