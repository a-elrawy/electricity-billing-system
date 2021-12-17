package com.user.electricity;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class HelloController {
    private Stage stage;
    private Scene scene;
    private Parent root;

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

    public void submit(ActionEvent event) throws IOException {
        Customer  customer= new Customer(username.getText(),email.getText(),password.getText(),address.getText(),meterCode.getText(),path.getText());
        Utilities.write(customer,   Utilities.CustomersFilename);
        switchToLogin(event);
    }

    public void login(ActionEvent event) throws IOException, ClassNotFoundException {
        boolean login = false;
        Customer customer = new Customer(username.getText(),password.getText());
        ArrayList<Customer> customers = Utilities.read_customers();
        for (Customer c:  customers) {
            if (c.getUsername().equals(customer.getUsername()) && c.getPassword().equals(customer.getPassword()))
                login = true;
        }
        if(login)
            System.out.println("Logged In");
        else
            wrongCombination.setText("Wrong Username/password");

    }
        public void switchToLogin(ActionEvent event) throws IOException {
        root= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("login.fxml")));
        stage  =(Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("css/app.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
    public void switchToSignup(ActionEvent event) throws IOException {
        root= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("SignUp.fxml")));
        stage  =(Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("css/app.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
}