package com.user.electricity;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Person {
    protected int id;
    protected String username;
    protected String email;
    protected String password;
    public Person( String username, String email, String password) throws IOException {
        Utilities.readNumbers("count.txt");
        this.id = Utilities.UserCount;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public Person(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Person(int id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
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



    public int getId() {
        return id;
    }
}
