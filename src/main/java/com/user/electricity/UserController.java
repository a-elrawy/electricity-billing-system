package com.user.electricity;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class UserController {
    private final String[] files = {Utilities.CustomersFilename,Utilities.OperatorsFilename,Utilities.AdminFilename};

    @FXML
    private TextField username;
    @FXML
    private TextField email;
    @FXML
    private TextField password;
    @FXML
    private TextField address;
    @FXML
    private TextField meterCode;
    @FXML
    private TextField path;
    @FXML
    private Label wrongCombination;


    // Sign UP
    public void signup(ActionEvent event) throws IOException {
        Customer  customer= new Customer(username.getText(),email.getText(),password.getText(),address.getText(),meterCode.getText(),path.getText());
        Utilities.write(customer,Utilities.CustomersFilename);
        SwitchingController.switchToLogin(event);
    }

    // Login and Validation
    public void login(ActionEvent event) throws IOException, ClassNotFoundException {
        Person person = new Person(username.getText(),password.getText());
            // Customers
            if(!Files.exists(Path.of(files[SwitchingController.index])))
                wrongCombination.setText("There must be Users");
            if(Utilities.validate_login(person, files[SwitchingController.index])) {
                // To be Implemented
                System.out.println("Logged In");
            }
            else
                wrongCombination.setText("Wrong Username/password");
        }


    // Switching Button Scene Builder
    public void switchToSignup(ActionEvent event) throws IOException {
        SwitchingController.switchToSignup(event);
    }



}