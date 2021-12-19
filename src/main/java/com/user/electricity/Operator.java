package com.user.electricity;

public class Operator extends Person {

    public Operator( String username, String email, String password) {
        super(Utilities.getNumberOfObjects(Utilities.CustomersFilename), username, email, password);
    }

    public Operator(String username, String password) {
        super(username, password);
    }

    @Override
    public String toString() {
        return "" + id +"|"+ username + "|" + email+ "|"+ password+ "|";
    }
}