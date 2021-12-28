package com.user.electricity;

public class Bill {
    private String meterCode;
    private String customer_name ;
    private double tariff ;
    private double charge ;
    private double amount ;

    public Bill() {

    }

    public Bill(String meterCode, String customer_name, double tariff, double charge, double amount) {
        this.meterCode = meterCode;
        this.customer_name = customer_name;
        this.tariff = tariff;
        this.charge = charge;
        this.amount = amount;
    }


    public String  getMeterCode() {
        return meterCode;
    }

    public void setMeterCode(String meterCode) {
        this.meterCode = meterCode;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public double getTariff() {
        return tariff;
    }

    public void setTariff(double tariff) {
        this.tariff = tariff;
    }

    public double getCharge() {
        return charge;
    }

    public void setCharge(double charge) {
        this.charge = charge;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Your Bill Details \n" +
                "-------------------------- \n" +
                "\n Your MeterCode is : " + meterCode +
                "\n Your Monthly Reading is : " + amount +
                "\n Your Tariff is : " + tariff +
                "\n You Have To Pay : " + charge ;
    }
}
