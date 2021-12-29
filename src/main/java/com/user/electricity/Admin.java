package com.user.electricity;

public class Admin extends Person {

    public Admin(int id, String username, String email, String password) {
        super(id, username, email, password);
    }
    public Admin(String username, String password) {
        super(username, password);
    }
    @Override
    public String toString() {
        return "" + id +"|"+ username + "|" + email+ "|"+ password+ "|";
    }

}
