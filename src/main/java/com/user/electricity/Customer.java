package com.user.electricity;

import java.io.Serializable;

public class Customer implements Serializable {
    private int id;
    private String username;
    private String email;
    private String password;
    private String address;
    private String meterCode;
    private String pathToContract;
    public Customer(String username,String password){
        this.username = username;
        this.password =password;
    }
    public Customer(String username, String email , String password, String address, String meterCode, String pathToContract) {
        this(username,password);
        this.email = email;
        this.address = address;
        this.meterCode = meterCode;
        this.pathToContract = pathToContract;
    }
// For Reading Only
    public Customer(int id, String username, String email , String password, String address, String meterCode, String pathToContract) {
        this(username,email,password,address,meterCode,pathToContract);
        this.id = id;
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
}
