package com.user.electricity;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

public class HelloController {
    public Button sign;
    public Button log;
    //switching
    private Stage stage;
    private Scene scene;
    private Parent root;
    private final String[] files = {Utilities.CustomersFilename,Utilities.OperatorsFilename,Utilities.AdminFilename};
    private int index = 0;
    @FXML
    private Button admin;
    @FXML
    private Button operator;
    @FXML
    private Button customer;

    // Registration
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
        Utilities.write(customer,   Utilities.CustomersFilename);
        switchToLogin(event);
    }

    // Login and Validation
    public void login(ActionEvent event) throws IOException, ClassNotFoundException {
        boolean login = false;
        Person person = new Person(username.getText(),password.getText());
            // Customers
            if(!Files.exists(Path.of(files[index])))
                wrongCombination.setText("There must be Users");
            if(Utilities.validate_login(person, files[index])) {
                // To be Implemented
                System.out.println("Logged In");
            }
            else
                wrongCombination.setText("Wrong Username/password");
        }



        public void setAdmin(ActionEvent event) throws IOException {
            index=2;switchToLogin(event);
        }
        public void setCustomer(ActionEvent event) throws IOException {
            index=0;switchToLogin(event);
        }
        public void setOperator(ActionEvent event) throws IOException {
        index=1;switchToLogin(event);
    }
    // Switching
    public void switchToLogin(ActionEvent event) throws IOException {
        root= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("login.fxml")));
        stage  =(Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        if (index != 0){
            Node node = root.lookup("#sign");
            node.setVisible(false);
            node = root.lookup("#log");
            node.setLayoutX(390);
        }
        scene.getStylesheets().add(getClass().getResource("css/app.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
        }

    public void switchToSignup(ActionEvent event) throws IOException {
        root= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("SignUp.fxml")));
        stage  =(Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setWidth(625);stage.setHeight(525);
        scene.getStylesheets().add(getClass().getResource("css/app.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
}